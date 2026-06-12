//Pila

public class Pila implements IPila{
    private int tope;
    private int[] datos;
    private int max;
    //Constructor
    public Pila(int max) {
        this.max = max;
        this.datos = new int[max];
        this.tope = -1;
    }

    @Override
    public void apilar(int elemento) {
        if (estaLlena()){
            System.out.println("Pila llena. No se puede agregar a "+elemento);
        }else{
            tope +=1;// tope = tope + 1
            datos[tope] = elemento;
            System.out.println("Se agrego a la pila el: "+elemento);
        }
    }

    @Override
    public int desapilar() {
        if (estaVacia()){
            System.out.println("Pila Vacia! No hay elementos");
            return -1;
        }else{
            int auxiliar = datos[tope];
            tope -=1;
            return auxiliar;
        }
    }

    @Override
    public boolean estaVacia() {
        if (tope == -1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean estaLlena() {
        if (tope == (max-1)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int tamanio() {
        return (tope + 1);
    }

    @Override
    public int tope() {
        if (estaVacia()){
            System.out.println("Pila Vacia! No hay elementos");
            return -1;
        }else{
            return datos[tope];
        }
    }

    @Override
    public void mosrtrar() {
        System.out.println("Datos de la pila: ");
        for (int i = 0;i <= tope; i++){
            System.out.println(datos[i]+" - ");
        }
        System.out.println();
    }
}
