public interface IGrafo {
    void insertarVertice(Sucursal sucursal);
    void eliminarVertice(Sucursal sucursal);
    void insertarArista(Sucursal origen, Sucursal destino, double distancia);
    void eliminarArista(Sucursal origen, Sucursal destino);
    boolean existeVertice(Sucursal sucursal);

    boolean existeArista(Sucursal origen, Sucursal destino);
    void mostrarVertices();
    void mostrarMatriz();
    void dijkstra(Sucursal origen);
    void caminoMinimo(Sucursal origen, Sucursal destino);
    void conectarPasillos(Sucursal a, Sucursal b);
    void calcularRecorrido(Sucursal inicio);
    void verProximo(Sucursal origen);
}
