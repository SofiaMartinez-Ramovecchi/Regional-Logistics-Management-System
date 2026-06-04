package com.logistics.models;

import java.util.List;

public class Pedido {

    private String id;
    private List<ItemPedido> items;
    private String estado;

    public boolean estaListo() {
        return false;
    }

    public boolean validar() {
        return false;
    }
}