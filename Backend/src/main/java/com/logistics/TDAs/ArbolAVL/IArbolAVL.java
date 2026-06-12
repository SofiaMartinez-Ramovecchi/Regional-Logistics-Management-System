package com.logistics.TDAs.ArbolAVL;

public interface IArbolAVL<T extends Comparable<T>> {
    void insertar(T dato);
    boolean buscar(T dato);
    void inorden();
    void preorden();
    void postorden();
}