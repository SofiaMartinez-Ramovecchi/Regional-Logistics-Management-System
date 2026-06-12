package com.logistics.TDAs.Graph;

public class Graph implements IGraph {

    private Sucursal[] vertices;
    private double[][] matriz;   // ponderada: guarda distancia (0 = sin arista)
    private int cantidad;
    private int capacidad;

    public Graph(int capacidad) {
        this.capacidad = capacidad;
        this.cantidad = 0;
        this.vertices = new Sucursal[capacidad];
        this.matriz = new double[capacidad][capacidad];
    }

    // -------------------------------------------------------
    // Métodos base
    // -------------------------------------------------------

    @Override
    public void insertarVertice(Sucursal sucursal) {
        if (cantidad == capacidad) {
            System.out.println("Capacidad máxima alcanzada.");
            return;
        }
        if (existeVertice(sucursal)) {
            System.out.println("La sucursal ya existe.");
            return;
        }
        vertices[cantidad] = sucursal;
        cantidad++;
    }

    @Override
    public boolean existeVertice(Sucursal sucursal) {
        return obtenerIndice(sucursal) != -1;
    }

    private int obtenerIndice(Sucursal sucursal) {
        for (int i = 0; i < cantidad; i++) {
            if (vertices[i].equals(sucursal)) return i;
        }
        return -1;
    }

    @Override
    public void insertarArista(Sucursal origen, Sucursal destino, double distancia) {
        int o = obtenerIndice(origen);
        int d = obtenerIndice(destino);
        if (o == -1 || d == -1) {
            System.out.println("Una de las sucursales no existe.");
            return;
        }
        matriz[o][d] = distancia;
        matriz[d][o] = distancia; // no dirigido
    }

    @Override
    public void eliminarArista(Sucursal origen, Sucursal destino) {
        int o = obtenerIndice(origen);
        int d = obtenerIndice(destino);
        if (o == -1 || d == -1) {
            System.out.println("Una de las sucursales no existe.");
            return;
        }
        matriz[o][d] = 0;
        matriz[d][o] = 0;
    }

    @Override
    public boolean existeArista(Sucursal origen, Sucursal destino) {
        int o = obtenerIndice(origen);
        int d = obtenerIndice(destino);
        if (o == -1 || d == -1) return false;
        return matriz[o][d] != 0;
    }

    @Override
    public void eliminarVertice(Sucursal sucursal) {
        int pos = obtenerIndice(sucursal);
        if (pos == -1) {
            System.out.println("La sucursal no existe.");
            return;
        }
        for (int i = pos; i < cantidad - 1; i++) {
            vertices[i] = vertices[i + 1];
        }
        for (int i = pos; i < cantidad - 1; i++) {
            for (int j = 0; j < cantidad; j++) {
                matriz[i][j] = matriz[i + 1][j];
            }
        }
        for (int j = pos; j < cantidad - 1; j++) {
            for (int i = 0; i < cantidad; i++) {
                matriz[i][j] = matriz[i][j + 1];
            }
        }
        cantidad--;
        vertices[cantidad] = null;
        for (int i = 0; i < capacidad; i++) {
            matriz[cantidad][i] = 0;
            matriz[i][cantidad] = 0;
        }
    }

    @Override
    public void mostrarVertices() {
        System.out.println("Sucursales en la red logística:");
        for (int i = 0; i < cantidad; i++) {
            System.out.println("  - " + vertices[i]);
        }
    }

    @Override
    public void mostrarMatriz() {
        System.out.println("Matriz de adyacencia (distancias en km):");
        System.out.printf("%-12s", "");
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("%-12s", vertices[i].getId());
        }
        System.out.println();
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("%-12s", vertices[i].getId());
            for (int j = 0; j < cantidad; j++) {
                if (matriz[i][j] == 0) {
                    System.out.printf("%-12s", "-");
                } else {
                    System.out.printf("%-12.1f", matriz[i][j]);
                }
            }
            System.out.println();
        }
    }

    // -------------------------------------------------------
    // Dijkstra — ruta de menor distancia desde un origen
    // Usado por ServicioRutas.calcularRutaOptima()
    // -------------------------------------------------------

    @Override
    public void dijkstra(Sucursal origen) {
        int inicio = obtenerIndice(origen);
        if (inicio == -1) {
            System.out.println("La sucursal de origen no existe.");
            return;
        }

        double[] dist = new double[cantidad];
        int[] anterior = new int[cantidad];
        boolean[] visitado = new boolean[cantidad];

        for (int i = 0; i < cantidad; i++) {
            dist[i] = Double.MAX_VALUE;
            anterior[i] = -1;
        }
        dist[inicio] = 0;

        for (int iter = 0; iter < cantidad; iter++) {
            // Nodo no visitado con menor distancia
            int u = -1;
            for (int i = 0; i < cantidad; i++) {
                if (!visitado[i] && (u == -1 || dist[i] < dist[u])) u = i;
            }
            if (u == -1 || dist[u] == Double.MAX_VALUE) break;
            visitado[u] = true;

            for (int v = 0; v < cantidad; v++) {
                if (matriz[u][v] != 0 && !visitado[v]) {
                    double nueva = dist[u] + matriz[u][v];
                    if (nueva < dist[v]) {
                        dist[v] = nueva;
                        anterior[v] = u;
                    }
                }
            }
        }

        System.out.println("=== Dijkstra desde " + origen.getNombre() + " ===");
        for (int i = 0; i < cantidad; i++) {
            if (i == inicio) continue;
            if (dist[i] == Double.MAX_VALUE) {
                System.out.println("  -> " + vertices[i].getNombre() + ": sin conexión");
            } else {
                System.out.printf("  -> %-20s %.1f km   Ruta: %s%n",
                        vertices[i].getNombre(), dist[i],
                        reconstruirCamino(anterior, inicio, i));
            }
        }
        System.out.println();
    }

    // -------------------------------------------------------
    // Camino mínimo entre dos sucursales específicas
    // Usado por ServicioRutas.caminoMinimo()
    // -------------------------------------------------------

    @Override
    public void caminoMinimo(Sucursal origen, Sucursal destino) {
        int inicio = obtenerIndice(origen);
        int fin    = obtenerIndice(destino);

        if (inicio == -1 || fin == -1) {
            System.out.println("Una de las sucursales no existe.");
            return;
        }

        double[] dist = new double[cantidad];
        int[] anterior = new int[cantidad];
        boolean[] visitado = new boolean[cantidad];

        for (int i = 0; i < cantidad; i++) {
            dist[i] = Double.MAX_VALUE;
            anterior[i] = -1;
        }
        dist[inicio] = 0;

        for (int iter = 0; iter < cantidad; iter++) {
            int u = -1;
            for (int i = 0; i < cantidad; i++) {
                if (!visitado[i] && (u == -1 || dist[i] < dist[u])) u = i;
            }
            if (u == -1 || dist[u] == Double.MAX_VALUE) break;
            visitado[u] = true;

            for (int v = 0; v < cantidad; v++) {
                if (matriz[u][v] != 0 && !visitado[v]) {
                    double nueva = dist[u] + matriz[u][v];
                    if (nueva < dist[v]) {
                        dist[v] = nueva;
                        anterior[v] = u;
                    }
                }
            }
        }

        System.out.println("=== Camino mínimo: " + origen.getNombre() + " -> " + destino.getNombre() + " ===");
        if (dist[fin] == Double.MAX_VALUE) {
            System.out.println("  No existe conexión entre ambas sucursales.");
        } else {
            System.out.printf("  Distancia total: %.1f km%n", dist[fin]);
            System.out.println("  Ruta: " + reconstruirCamino(anterior, inicio, fin));
        }
        System.out.println();
    }

    private String reconstruirCamino(int[] anterior, int inicio, int destino) {
        if (destino == inicio) return vertices[inicio].getId();
        if (anterior[destino] == -1) return "sin ruta";
        return reconstruirCamino(anterior, inicio, anterior[destino])
                + " -> " + vertices[destino].getId();
    }

    // -------------------------------------------------------
    // Conectar pasillos — versión simplificada sin distancia
    // Usado por ServicioRecoleccion.conectarPasillos()
    // -------------------------------------------------------

    @Override
    public void conectarPasillos(Sucursal a, Sucursal b) {
        // Conecta con distancia 1 cuando no se conoce la distancia exacta
        insertarArista(a, b, 1.0);
        System.out.println("Pasillo conectado: " + a.getId() + " <-> " + b.getId());
    }

    // -------------------------------------------------------
    // Calcular recorrido — BFS por niveles
    // Usado por ServicioRecoleccion.calcularRecorrido()
    // -------------------------------------------------------

    @Override
    public void calcularRecorrido(Sucursal inicio) {
        int posInicio = obtenerIndice(inicio);
        if (posInicio == -1) {
            System.out.println("La sucursal no existe.");
            return;
        }

        boolean[] visitado = new boolean[cantidad];
        int[] nivel = new int[cantidad];
        int[] cola = new int[cantidad];
        int frente = 0, fin = 0;

        visitado[posInicio] = true;
        nivel[posInicio] = 0;
        cola[fin++] = posInicio;

        System.out.println("=== Recorrido de recolección desde " + inicio.getNombre() + " ===");
        int nivelActual = -1;

        while (frente < fin) {
            int idx = cola[frente++];
            if (nivel[idx] != nivelActual) {
                nivelActual = nivel[idx];
                System.out.println("Nivel " + nivelActual + ":");
            }
            System.out.println("  Visitando: " + vertices[idx]);

            for (int j = 0; j < cantidad; j++) {
                if (matriz[idx][j] != 0 && !visitado[j]) {
                    visitado[j] = true;
                    nivel[j] = nivel[idx] + 1;
                    cola[fin++] = j;
                }
            }
        }
        System.out.println();
    }

    // -------------------------------------------------------
    // Ver próximo — sucursal más cercana (un salto directo)
    // Usado por ServicioExpedicion.verProximo()
    // -------------------------------------------------------

    @Override
    public void verProximo(Sucursal origen) {
        int posOrigen = obtenerIndice(origen);
        if (posOrigen == -1) {
            System.out.println("La sucursal no existe.");
            return;
        }

        double menorDist = Double.MAX_VALUE;
        int indiceMasCercano = -1;

        for (int j = 0; j < cantidad; j++) {
            if (matriz[posOrigen][j] != 0 && matriz[posOrigen][j] < menorDist) {
                menorDist = matriz[posOrigen][j];
                indiceMasCercano = j;
            }
        }

        System.out.println("=== Sucursal más cercana a " + origen.getNombre() + " ===");
        if (indiceMasCercano == -1) {
            System.out.println("  No hay sucursales conectadas.");
        } else {
            System.out.printf("  %s  (%.1f km)%n", vertices[indiceMasCercano], menorDist);
        }
        System.out.println();
    }
}
