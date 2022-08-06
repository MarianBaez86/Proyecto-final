package com.coderclase11.clientes.service;

import com.coderclase11.clientes.converter.dto.ProductoDtoAEntityConverter;
import com.coderclase11.clientes.converter.entity.ProductoEntityADtoConverter;
import com.coderclase11.clientes.dto.ProductoDto;
import com.coderclase11.clientes.model.Producto;
import com.coderclase11.clientes.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;
    private final ProductoEntityADtoConverter converter;
    private final ProductoDtoAEntityConverter converterDto;

    public ProductoService(ProductoRepository repository, ProductoEntityADtoConverter converter, ProductoDtoAEntityConverter converterDto) {
        this.repository = repository;
        this.converter = converter;
        this.converterDto = converterDto;
    }

    public List<ProductoDto> buscarTodosLosProductos() {

        List<Producto> productos = repository.findAll();
        List<ProductoDto> productosDto = new ArrayList<>();

        for (Producto producto : productos) {
            ProductoDto productoDto = this.converter.convert(producto);
            productosDto.add(productoDto);

        }
        return productosDto;
    }

    public ProductoDto buscarPorId(long id) {
        Producto producto = repository.findById(id).orElse(null);
        if (producto == null){
            return new ProductoDto();
        }
        ProductoDto productoDto = this.converter.convert(producto);
        return productoDto;
    }

    public ProductoDto agregarProducto(ProductoDto productoDto){
        Producto producto = this.converterDto.convert(productoDto);
        this.repository.save(producto);
        return productoDto;
    }

    public ProductoDto actualizarProducto(ProductoDto productoDto){
        Producto producto = this.converterDto.convert(productoDto);
        this.repository.save(producto);
        return productoDto;
    }
}
