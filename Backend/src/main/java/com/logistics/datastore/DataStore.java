package com.logistics.datastore;
import com.logistics.TDAs.ArbolAVL.ArbolAVL;
import com.logistics.TDAs.MinHeap.MinHeap;
import com.logistics.TDAs.DynamicQueue.DynamicQueue;
import com.logistics.TDAs.Graph.Graph;
import com.logistics.TDAs.DynamicStack.DynamicStack;
import com.logistics.models.Pedido;
import com.logistics.models.Producto;
import com.logistics.models.Lote;



public class DataStore {

    private ArbolAVL<Producto> productos;
    private ArbolAVL<Lote> lotes;

    private MinHeap<Producto> inventarioCritico;

    private DynamicQueue<Pedido> expedicion;

    private DynamicStack<Movimiento> movimientos;

    private Graph deposito;

    public DataStore() {

        this.productos = new ArbolAVL<>();
        this.lotes = new ArbolAVL<>();

        this.inventarioCritico = new MinHeap<>();

        this.expedicion = new DynamicQueue<>();

        this.movimientos = new DynamicStack<>();

        this.deposito = new Graph();
    }

    public ArbolAVL<Producto> getProductos() {
        return productos;
    }

    public ArbolAVL<Lote> getLotes() {
        return lotes;
    }

    public MinHeap<Producto> getInventarioCritico() {
        return inventarioCritico;
    }

    public DynamicQueue<Pedido> getExpedicion() {
        return expedicion;
    }

    public DynamicStack<Movimiento> getMovimientos() {
        return movimientos;
    }

    public Graph getDeposito() {
        return deposito;
    }

}
