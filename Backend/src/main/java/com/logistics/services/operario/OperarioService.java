package com.logistics.services;

import java.util.List;
import java.util.Map;

public class OperarioService {

    public static List<Map<String, String>> obtenerRemitos() {

        return List.of(

                Map.of(
                        "id", "1",
                        "estado", "Pendiente",
                        "sucursal", "Carrefour San Justo"
                ),

                Map.of(
                        "id", "2",
                        "estado", "En viaje",
                        "sucursal", "Carrefour Ramos Mejia"
                )
        );
    }
}