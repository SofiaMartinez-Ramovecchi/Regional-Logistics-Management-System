public interface IGrafo {

    // --- Estructura base ---
    void insertarVertice(Sucursal sucursal);

    void eliminarVertice(Sucursal sucursal);

    void insertarArista(Sucursal origen, Sucursal destino, double distancia);

    void eliminarArista(Sucursal origen, Sucursal destino);

    boolean existeVertice(Sucursal sucursal);

    boolean existeArista(Sucursal origen, Sucursal destino);

    void mostrarVertices();

    void mostrarMatriz();

    // --- Métodos logísticos (del diagrama de clases) ---

    // ServicioRutas: calcula la ruta de menor distancia entre dos sucursales (Dijkstra)
    void dijkstra(Sucursal origen);

    // ServicioRutas: devuelve el camino mínimo entre dos nodos
    void caminoMinimo(Sucursal origen, Sucursal destino);

    // ServicioRecoleccion: conecta dos pasillos/ubicaciones del almacén
    void conectarPasillos(Sucursal a, Sucursal b);

    // ServicioRecoleccion: calcula el recorrido óptimo para recolección
    void calcularRecorrido(Sucursal inicio);

    // ServicioExpedicion: encuentra la sucursal más cercana disponible
    void verProximo(Sucursal origen);
}
