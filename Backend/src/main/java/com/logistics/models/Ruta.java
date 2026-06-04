package com.logistics.models;

import java.util.List;

public class Ruta {

    private String id;
    private List<String> nodos;
    private double distanciaTotal;

    public boolean esValida() {
        return false;
    }

    public List<String> getNodos() {
        return nodos;
    }
}