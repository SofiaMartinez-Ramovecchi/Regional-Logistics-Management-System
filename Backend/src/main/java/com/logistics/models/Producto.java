public class Producto implements Comparable<Producto> {

    private String codigo;

    @Override
    public int compareTo(Producto otro) {

        return codigo.compareTo(otro.codigo);

    }

}
