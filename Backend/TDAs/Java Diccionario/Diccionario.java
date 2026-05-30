import java.util.HashMap;

public class Diccionario implements IDiccionario {
    private HashMap<String, Integer> datos;

    public Diccionario() {
        datos = new HashMap<>();
    }

    @Override
    public void insertar(String clave, int valor) {
        datos.put(clave, valor);
        System.out.println("Se insertó: " + clave + " -> " + valor);
    }

    @Override
    public int obtener(String clave) {
        if (!datos.containsKey(clave)) {
            System.out.println("Clave no encontrada");
            return -1;
        }
        return datos.get(clave);
    }

    @Override
    public int eliminar(String clave) {
        if (!datos.containsKey(clave)) {
            System.out.println("Clave no encontrada");
            return -1;
        }
        return datos.remove(clave);
    }

    @Override
    public boolean estaVacio() {
        return datos.isEmpty();
    }

    @Override
    public int tamanio() {
        return datos.size();
    }

    @Override
    public void mostrar() {
        System.out.println("Contenido del diccionario:");
        for (String clave : datos.keySet()) {
            System.out.println(clave + " -> " + datos.get(clave));
        }
    }
}