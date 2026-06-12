package com.logistics.TDAs.ArbolAVL;

public class ArbolAVL<T extends Comparable<T>> implements IArbolAVL<T> {

    NodoAVL<T> raiz;

    private int altura(NodoAVL<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return nodo.getAltura();
    }

    private int obtenerBalance(NodoAVL<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return altura(nodo.getIzquierdo()) - altura(nodo.getDerecho());
    }

    private NodoAVL<T> rotarDerecha(NodoAVL<T> y) {
        NodoAVL<T> x = y.getIzquierdo();
        NodoAVL<T> temp = x.getDerecho();

        x.setDerecho(y);
        y.setIzquierdo(temp);
        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);
        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);

        return x;
    }

    private NodoAVL<T> rotarIzquierda(NodoAVL<T> x) {
        NodoAVL<T> y = x.getDerecho();
        NodoAVL<T> temp = y.getIzquierdo();

        y.setIzquierdo(x);
        x.setDerecho(temp);
        x.setAltura(Math.max(altura(x.getIzquierdo()), altura(x.getDerecho())) + 1);
        y.setAltura(Math.max(altura(y.getIzquierdo()), altura(y.getDerecho())) + 1);

        return y;
    }

    @Override
    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoAVL<T> insertarRecursivo(NodoAVL<T> nodo, T dato) {
        if (nodo == null) {
            return new NodoAVL<>(dato);
        }

        if (dato.compareTo(nodo.getDato()) < 0) {
            nodo.setIzquierdo(insertarRecursivo(nodo.getIzquierdo(), dato));
        } else if (dato.compareTo(nodo.getDato()) > 0) {
            nodo.setDerecho(insertarRecursivo(nodo.getDerecho(), dato));
        } else {
            return nodo;
        }

        nodo.setAltura(1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho())));

        int balance = obtenerBalance(nodo);

        // Caso LL
        if (balance > 1 && dato.compareTo(nodo.getIzquierdo().getDato()) < 0) {
            return rotarDerecha(nodo);
        }

        // Caso RR
        if (balance < -1 && dato.compareTo(nodo.getDerecho().getDato()) > 0) {
            return rotarIzquierda(nodo);
        }

        // Caso LR
        if (balance > 1 && dato.compareTo(nodo.getIzquierdo().getDato()) > 0) {
            nodo.setIzquierdo(rotarIzquierda(nodo.getIzquierdo()));
            return rotarDerecha(nodo);
        }

        // Caso RL
        if (balance < -1 && dato.compareTo(nodo.getDerecho().getDato()) < 0) {
            nodo.setDerecho(rotarDerecha(nodo.getDerecho()));
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    @Override
    public boolean buscar(T dato) {
        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(NodoAVL<T> nodo, T dato) {
        if (nodo == null) {
            return false;
        }

        int cmp = dato.compareTo(nodo.getDato());

        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return buscarRecursivo(nodo.getIzquierdo(), dato);
        } else {
            return buscarRecursivo(nodo.getDerecho(), dato);
        }
    }

    private NodoAVL<T> minimo(NodoAVL<T> nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    @Override
    public void inorden() {
        inordenRecursivo(raiz);
        System.out.println();
    }

    private void inordenRecursivo(NodoAVL<T> nodo) {
        if (nodo != null) {
            inordenRecursivo(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + " ");
            inordenRecursivo(nodo.getDerecho());
        }
    }

    @Override
    public void preorden() {
        preordenRecursivo(raiz);
        System.out.println();
    }

    private void preordenRecursivo(NodoAVL<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " ");
            preordenRecursivo(nodo.getIzquierdo());
            preordenRecursivo(nodo.getDerecho());
        }
    }

    @Override
    public void postorden() {
        postordenRecursivo(raiz);
        System.out.println();
    }

    private void postordenRecursivo(NodoAVL<T> nodo) {
        if (nodo != null) {
            postordenRecursivo(nodo.getIzquierdo());
            postordenRecursivo(nodo.getDerecho());
            System.out.print(nodo.getDato() + " ");
        }
    }
}