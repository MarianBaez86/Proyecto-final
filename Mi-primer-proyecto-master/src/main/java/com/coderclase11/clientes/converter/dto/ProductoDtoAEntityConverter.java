package com.coderclase11.clientes.converter.dto;

import com.coderclase11.clientes.dto.ProductoDto;
import com.coderclase11.clientes.model.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoDtoAEntityConverter {
    public Producto convert(ProductoDto productoDto) {
        Producto producto = new Producto();
        producto.setId(productoDto.getId() != null ? productoDto.getId() : null);
        producto.setDescripcion(productoDto.getDescripcion());
        producto.setPrecio(productoDto.getPrecio());
        producto.setActivo(productoDto.isActivo());
        producto.setFechaCreacion(productoDto.getFechaCreacion());
        producto.setFechaActualizacion(productoDto.getFechaActualizacion());
        producto.setStock(productoDto.getStock());
        return producto;
    }
}
