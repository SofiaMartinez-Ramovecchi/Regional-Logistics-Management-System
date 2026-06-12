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




    private Graph deposito;

    public DataStore() {

        this.productos = new ArbolAVL<>();
        this.lotes = new ArbolAVL<>();

    }

    public ArbolAVL<Producto> getProductos() {
        return productos;
    }

    public ArbolAVL<Lote> getLotes() {
        return lotes;
    }



    public Graph getDeposito() {
        return deposito;
    }

}
