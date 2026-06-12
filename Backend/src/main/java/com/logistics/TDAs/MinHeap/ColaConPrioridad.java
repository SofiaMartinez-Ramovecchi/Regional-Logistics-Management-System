package com.logistics.TDAs.MinHeap;

public class ColaConPrioridad implements IColaConPrioridad {
    private int[] datos;
    private int[] prioridades;
    private int max;
    private int count;

    public ColaConPrioridad(int max) {
        this.max = max;
        this.datos = new int[max];
        this.prioridades = new int[max];
        this.count = 0;
    }

    @Override
    public void encolar(int elemento) {
        encolar(elemento, 0);
    }

    public void encolar(int elemento, int prioridad) {
        if (estaLlena()) {
            System.out.println("Cola llena. No se puede agregar " + elemento);
            return;
        }
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (prioridad > prioridades[i]) {
                datos[i + 1] = datos[i];
                prioridades[i + 1] = prioridades[i];
            } else {
                break;
            }
        }
        datos[i + 1] = elemento;
        prioridades[i + 1] = prioridad;
        count++;
        System.out.println("Se agrego " + elemento + " con prioridad " + prioridad);
    }

    @Override
    public int desencolar() {
        if (estaVacia()) {
            System.out.println("Cola vacia! No hay elementos");
            return -1;
        }
        int elemento = datos[0];
        for (int i = 0; i < count - 1; i++) {
            datos[i] = datos[i + 1];
            prioridades[i] = prioridades[i + 1];
        }
        count--;
        return elemento;
    }

    @Override
    public boolean estaVacia() {
        return count == 0;
    }

    @Override
    public boolean estaLlena() {
        return count == max;
    }

    @Override
    public int frente() {
        if (estaVacia()) {
            System.out.println("Cola vacia");
            return -1;
        }
        return datos[0];
    }

    @Override
    public int finalCola() {
        if (estaVacia()) {
            System.out.println("Cola vacia");
            return -1;
        }
        return datos[count - 1];
    }

    @Override
    public int tamanio() {
        return count;
    }

    @Override
    public void mosrtrar() {
        System.out.println("Datos de la cola con prioridad: ");
        if (estaVacia()) {
            System.out.println("Cola vacia");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Elemento: " + datos[i] + " - Prioridad: " + prioridades[i]);
        }
    }
}