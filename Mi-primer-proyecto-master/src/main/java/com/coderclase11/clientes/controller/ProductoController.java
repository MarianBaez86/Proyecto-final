package com.coderclase11.clientes.controller;
import com.coderclase11.clientes.dto.ProductoDto;
import com.coderclase11.clientes.service.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coderhouse/producto")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<ProductoDto> obtenerTodosLosProductos(){
        return productoService.buscarTodosLosProductos();
    }

    @GetMapping("/{id}")
    public ProductoDto buscarPorId(@PathVariable Long id){
        return productoService.buscarPorId(id);
    }

    @PostMapping
    public ProductoDto agregarProducto(@RequestBody ProductoDto productoDto){
        return productoService.agregarProducto(productoDto);
    }

    @PutMapping
    public ProductoDto actualizarProducto(@RequestBody ProductoDto productoDto) {
        return productoService.actualizarProducto(productoDto);
    }
}
