//Cola
public class Cola implements ICola {
    private int inicio;
    private int fin;
    private int[] datos;
    private int max;
    //Constructor
    public Cola(int max) {
        this.max = max;
        this.datos = new int[max];
        this.inicio = 0;
        this.fin = -1;
    }

    @Override
    public void encolar(int elemento) {
        if (estaLlena()){
            System.out.println("Cola llena. No se puede agregar a "+elemento);
        }else{
            fin +=1;
            datos[fin] = elemento;
            System.out.println("Se agrego a la cola el: "+elemento);
        }
    }

    @Override
    public int desencolar() {
        if (estaVacia()){
            System.out.println("Cola Vacia! No hay elementos");
            return -1;
        }else{
            int auxiliar = datos[inicio];
            inicio +=1;
            return auxiliar;
        }
    }

    @Override
    public boolean estaVacia() {
        if (inicio > fin){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean estaLlena() {
        if (fin == (max-1)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int frente() {
        if (estaVacia()) {
            System.out.println("Cola vacia");
            return -1;
        } else {
            return datos[inicio];
        }
    }

    @Override
    public int finalCola() {
        if (estaVacia()) {
            System.out.println("Cola vacia");
            return -1;
        } else {
            return datos[fin];
        }
    }

    @Override
    public int tamanio() {
        return (fin - inicio + 1);
    }

    @Override
    public void mosrtrar() {
        System.out.println("Datos de la cola: ");
        for (int i = 0;i <= fin; i++){
            System.out.println(datos[i]+" - ");
        }
        System.out.println();
    }
}
