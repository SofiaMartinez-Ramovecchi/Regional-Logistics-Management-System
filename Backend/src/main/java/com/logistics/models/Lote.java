package com.logistics.models;

import java.time.LocalDate;

public class Lote implements Comparable<Lote> {

    private String id;
    private String descripcion;
    private int cantidad;
    private double peso;
    private LocalDate fechaVencimiento;
    private String origen;
    private String destino;
    private int prioridad;

    public Lote(String id, String descripcion, int cantidad, double peso,
                LocalDate fechaVencimiento, String origen, String destino, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.peso = peso;
        this.fechaVencimiento = fechaVencimiento;
        this.origen = origen;
        this.destino = destino;
        this.prioridad = prioridad;
    }

    // El árbol AVL ordena los lotes por ID
    @Override
    public int compareTo(Lote otro) {
        return this.id.compareTo(otro.id);
    }

    @Override
    public String toString() {
        return "Lote{" + "id='" + id + '\'' + ", descripcion='" + descripcion + '\'' + ", cantidad=" + cantidad + ", peso=" + peso + ", fechaVencimiento=" + fechaVencimiento + ", origen='" + origen + '\'' + ", destino='" + destino + '\'' + ", prioridad=" + prioridad + '}';
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public int getPrioridad() { return prioridad; }
    public void setPrioridad(int prioridad) { this.prioridad = prioridad; }
}