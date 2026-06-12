package com.logistics.datastore;

public class DataLoader {

    private final DataStore dataStore;

    public DataLoader(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public void cargarTodo() {

        cargarProductos();

        cargarLotes();

        cargarPedidos();

        cargarMovimientos();

        cargarDeposito();

    }

    private void cargarProductos() {

        // leer productos.json

        // convertir a objetos

        // insertar en AVL

    }

    private void cargarLotes() {

        // leer lotes.json

        // insertar en AVL

    }

    private void cargarPedidos() {

        // insertar en cola

    }

    private void cargarMovimientos() {

        // insertar en pila

    }

    private void cargarDeposito() {

        // construir grafo

    }

}
