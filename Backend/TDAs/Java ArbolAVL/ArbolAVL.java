public class ArbolAVL implements IArbolAVL {

    NodoAVL raiz;

    private int altura(NodoAVL nodo) {

        if (nodo == null) {
            return 0;
        }

        return nodo.altura;
    }

    private int obtenerBalance(NodoAVL nodo) {

        if (nodo == null) {
            return 0;
        }

        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    private NodoAVL rotarDerecha(NodoAVL y) {

        NodoAVL x = y.izquierdo;
        NodoAVL temp = x.derecho;

        x.derecho = y;
        y.izquierdo = temp;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        return x;
    }

    private NodoAVL rotarIzquierda(NodoAVL x) {

        NodoAVL y = x.derecho;
        NodoAVL temp = y.izquierdo;

        y.izquierdo = x;
        x.derecho = temp;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        return y;
    }

    @Override
    public void insertar(int dato) {

        raiz = insertarRecursivo(raiz, dato);
    }

    private NodoAVL insertarRecursivo(NodoAVL nodo, int dato) {

        if (nodo == null) {
            return new NodoAVL(dato);
        }

        if (dato < nodo.dato) {

            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);

        } else if (dato > nodo.dato) {

            nodo.derecho = insertarRecursivo(nodo.derecho, dato);

        } else {
            return nodo;
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        int balance = obtenerBalance(nodo);

        if (balance > 1 && dato < nodo.izquierdo.dato) {

            return rotarDerecha(nodo);
        }

        if (balance < -1 && dato > nodo.derecho.dato) {

            return rotarIzquierda(nodo);
        }

        if (balance > 1 && dato > nodo.izquierdo.dato) {

            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);

            return rotarDerecha(nodo);
        }

        if (balance < -1 && dato < nodo.derecho.dato) {

            nodo.derecho = rotarDerecha(nodo.derecho);

            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    @Override
    public boolean buscar(int dato) {

        return buscarRecursivo(raiz, dato);
    }

    private boolean buscarRecursivo(NodoAVL nodo, int dato) {

        if (nodo == null) {
            return false;
        }

        if (dato == nodo.dato) {
            return true;
        }

        if (dato < nodo.dato) {

            return buscarRecursivo(nodo.izquierdo, dato);

        } else {

            return buscarRecursivo(nodo.derecho, dato);
        }
    }

    @Override
    public void eliminar(int dato) {

        raiz = eliminarRecursivo(raiz, dato);
    }

    private NodoAVL eliminarRecursivo(NodoAVL nodo, int dato) {

        if (nodo == null) {
            return null;
        }

        if (dato < nodo.dato) {

            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, dato);

        } else if (dato > nodo.dato) {

            nodo.derecho = eliminarRecursivo(nodo.derecho, dato);

        } else {

            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }

            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            NodoAVL sucesor = minimo(nodo.derecho);

            nodo.dato = sucesor.dato;

            nodo.derecho = eliminarRecursivo(nodo.derecho, sucesor.dato);
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        int balance = obtenerBalance(nodo);

        if (balance > 1 && obtenerBalance(nodo.izquierdo) >= 0) {

            return rotarDerecha(nodo);
        }

        if (balance > 1 && obtenerBalance(nodo.izquierdo) < 0) {

            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);

            return rotarDerecha(nodo);
        }

        if (balance < -1 && obtenerBalance(nodo.derecho) <= 0) {

            return rotarIzquierda(nodo);
        }

        if (balance < -1 && obtenerBalance(nodo.derecho) > 0) {

            nodo.derecho = rotarDerecha(nodo.derecho);

            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    private NodoAVL minimo(NodoAVL nodo) {

        while (nodo.izquierdo != null) {

            nodo = nodo.izquierdo;
        }

        return nodo;
    }

    @Override
    public void inorden() {

        inordenRecursivo(raiz);

        System.out.println();
    }

    private void inordenRecursivo(NodoAVL nodo) {

        if (nodo != null) {

            inordenRecursivo(nodo.izquierdo);

            System.out.print(nodo.dato + " ");

            inordenRecursivo(nodo.derecho);
        }
    }

    @Override
    public void preorden() {

        preordenRecursivo(raiz);

        System.out.println();
    }

    private void preordenRecursivo(NodoAVL nodo) {

        if (nodo != null) {

            System.out.print(nodo.dato + " ");

            preordenRecursivo(nodo.izquierdo);

            preordenRecursivo(nodo.derecho);
        }
    }

    @Override
    public void postorden() {

        postordenRecursivo(raiz);

        System.out.println();
    }

    private void postordenRecursivo(NodoAVL nodo) {

        if (nodo != null) {

            postordenRecursivo(nodo.izquierdo);

            postordenRecursivo(nodo.derecho);

            System.out.print(nodo.dato + " ");
        }
    }
}