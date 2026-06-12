package com.logistics.TDAs.Lista;

public interface IListas {
    public void insertarEnInicio(int elemento);
    public void insertarEnFinal(int elemento);
    public void insertarEnOrden(int elemento);
    public boolean eliminar(int elemento);
    public boolean buscar(int elemnto);
    public void mostrar();
    public boolean listaVacia();
}
