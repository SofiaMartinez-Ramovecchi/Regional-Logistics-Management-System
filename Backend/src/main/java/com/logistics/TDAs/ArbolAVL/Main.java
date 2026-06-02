public class Main {

    public static void main(String[] args) {

        ArbolAVL arbol = new ArbolAVL();

        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(40);
        arbol.insertar(50);
        arbol.insertar(25);

        System.out.println("Inorden:");
        arbol.inorden();

        System.out.println("Preorden:");
        arbol.preorden();

        System.out.println("Postorden:");
        arbol.postorden();

        System.out.println(arbol.buscar(25));

        arbol.eliminar(30);

        arbol.inorden();
    }
}