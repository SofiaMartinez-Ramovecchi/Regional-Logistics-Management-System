package com.logistics.controllers;

import com.logistics.services.OperarioService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OperarioController {

    @GetMapping("/operario/remitos")
    public List<Map<String, String>> obtenerRemitos() {

        return OperarioService.obtenerRemitos();
    }
}
