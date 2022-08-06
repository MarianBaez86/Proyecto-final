package com.coderclase11.clientes.converter.entity;

import com.coderclase11.clientes.dto.ProductoDto;
import com.coderclase11.clientes.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoEntityADtoConverter {

    public ProductoDto convert(Producto producto) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setId(producto.getId());
        productoDto.setDescripcion(producto.getDescripcion());
        productoDto.setPrecio(producto.getPrecio());
        productoDto.setActivo(producto.isActivo());
        productoDto.setFechaCreacion(producto.getFechaCreacion());
        productoDto.setFechaActualizacion(producto.getFechaActualizacion());
        productoDto.setStock(producto.getStock());
        return productoDto;
    }

}
