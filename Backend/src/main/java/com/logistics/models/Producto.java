package com.logistics.models;

public class Producto implements Comparable<Producto> {

    private String codigoUniversal;
    private String nombre;
    private int stock;
    private UbicacionFisica ubicacion;
    private int stockMinimo;

    @Override
    public int compareTo(Producto otro) {
        return codigoUniversal.compareTo(otro.codigoUniversal);
    }

    public void actualizarStock(int cantidad) {
    }

    public boolean esCritico() {
        return false;
    }
}
