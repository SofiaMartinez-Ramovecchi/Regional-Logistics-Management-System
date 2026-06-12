public class MainLogistica {

    public static void main(String[] args) {

        Sucursal deposito  = new Sucursal("DEP", "Depósito Central",  "Buenos Aires");
        Sucursal cordoba   = new Sucursal("CBA", "Sucursal Córdoba",   "Córdoba");
        Sucursal rosario   = new Sucursal("ROS", "Sucursal Rosario",   "Rosario");
        Sucursal mendoza   = new Sucursal("MDZ", "Sucursal Mendoza",   "Mendoza");
        Sucursal tucuman   = new Sucursal("TUC", "Sucursal Tucumán",   "Tucumán");

        IGrafo red = new GrafoMatrizAdyacencia(10);

        red.insertarVertice(deposito);
        red.insertarVertice(cordoba);
        red.insertarVertice(rosario);
        red.insertarVertice(mendoza);
        red.insertarVertice(tucuman);

        red.insertarArista(deposito, rosario,  300.0);
        red.insertarArista(deposito, cordoba,  700.0);
        red.insertarArista(rosario,  cordoba,  400.0);
        red.insertarArista(cordoba,  mendoza,  600.0);
        red.insertarArista(cordoba,  tucuman,  800.0);
        red.insertarArista(mendoza,  tucuman, 1100.0);

        red.mostrarVertices();
        System.out.println();
        red.mostrarMatriz();
        System.out.println();

        // Ruta óptima desde el depósito a todas las sucursales
        red.dijkstra(deposito);

        // Camino mínimo entre dos sucursales específicas
        red.caminoMinimo(deposito, tucuman);

        // Recorrido de recolección por niveles desde el depósito
        red.calcularRecorrido(deposito);

        // Sucursal más cercana al depósito
        red.verProximo(deposito);
    }
}
