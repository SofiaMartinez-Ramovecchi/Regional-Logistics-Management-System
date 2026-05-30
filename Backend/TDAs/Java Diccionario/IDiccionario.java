public interface IDiccionario {
    public void insertar(String clave, int valor);
    public int obtener(String clave);
    public int eliminar(String clave);
    public boolean estaVacio();
    public int tamanio();
    public void mostrar();
}
