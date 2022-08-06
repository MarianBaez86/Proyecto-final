package com.coderclase11.clientes.controller;

import com.coderclase11.clientes.dto.ComprobanteDto;
import com.coderclase11.clientes.service.ComprobanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coderhouse/comprobante")
public class ComprobanteController {

    private final ComprobanteService comprobanteService;

    public ComprobanteController(ComprobanteService comprobanteService) {
        this.comprobanteService = comprobanteService;
    }

    @GetMapping
    public List<ComprobanteDto> obtenerTodosLosComprobantes(){
        return comprobanteService.listarTodosLosComprobantes();
    }

    @PostMapping
    public ComprobanteDto newEntity(@RequestBody ComprobanteDto comprobanteDto) {
        return this.comprobanteService.crearComprobante(comprobanteDto);
    }
}
