package com.logistics.TDAs.DynamicQueue;

public interface ICola {
    public void encolar(int elemento);
    public int desencolar();
    public boolean estaVacia();
    public boolean estaLlena();
    public int frente();
    public int finalCola();
    public int tamanio();
    public void mosrtrar();
}
