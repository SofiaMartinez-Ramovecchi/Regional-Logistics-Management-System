package com.logistics.TDAs.ArbolAVL;

public interface IArbolAVL {
    void insertar(int dato);
    void eliminar(int dato);
    boolean buscar(int dato);
    void inorden();
    void preorden();
    void postorden();
}