package tdas.avl;

public class NodoAVL<T> {

    private T dato;

    private int altura;

    private NodoAVL<T> izquierdo;

    private NodoAVL<T> derecho;

    public NodoAVL(T dato) {

        this.dato = dato;

        this.altura = 1;

    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoAVL<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL<T> derecho) {
        this.derecho = derecho;
    }

}
