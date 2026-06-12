package com.logistics.TDAs.Graph;

public class Sucursal {

    private String id;
    private String nombre;
    private String ciudad;

    public Sucursal(String id, String nombre, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Sucursal otra = (Sucursal) obj;
        return id.equals(otra.id);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " - " + ciudad;
    }
}
