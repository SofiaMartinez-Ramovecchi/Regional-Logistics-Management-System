package com.logistics.TDAs.Lista;

public class Listas implements IListas {
    private Nodo cabeza;

    public Listas() {
        cabeza = null;
    }

    @Override
    public void insertarEnInicio(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    @Override
    public void insertarEnFinal(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    @Override
    public void insertarEnOrden(int elemento) {
        Nodo nuevo = new Nodo(elemento);
        if (cabeza == null || cabeza.dato > elemento) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null && actual.siguiente.dato < elemento) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
    }

    @Override
    public boolean eliminar(int elemento) {
        if (cabeza == null) return false;

        if (cabeza.dato == elemento) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.dato != elemento) {
            actual = actual.siguiente;
        }

        if (actual.siguiente == null) return false;

        actual.siguiente = actual.siguiente.siguiente;
        return true;
    }

    @Override
    public boolean buscar(int elemento) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == elemento) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    @Override
    public boolean listaVacia() {
        return cabeza == null;
    }
}
