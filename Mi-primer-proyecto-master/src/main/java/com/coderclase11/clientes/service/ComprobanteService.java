package com.coderclase11.clientes.service;


import com.coderclase11.clientes.converter.entity.ComprobanteEntityADtoConverter;
import com.coderclase11.clientes.dto.ComprobanteDto;
import com.coderclase11.clientes.dto.ItemsComprobanteDto;
import com.coderclase11.clientes.model.*;
import com.coderclase11.clientes.repository.ClienteRepository;
import com.coderclase11.clientes.repository.ComprobanteRepository;
import com.coderclase11.clientes.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class ComprobanteService {
    private final ComprobanteRepository repository;
    private final ComprobanteEntityADtoConverter converter;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;
    private final RestTemplate restTemplate;


    public ComprobanteService(ComprobanteRepository repository,
                              ComprobanteEntityADtoConverter converter,
                              ClienteRepository clienteRepository,
                              ProductoRepository productoRepository, RestTemplate restTemplate) {
        this.repository = repository;
        this.converter = converter;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
        this.restTemplate = restTemplate;
    }

    public List<ComprobanteDto> listarTodosLosComprobantes(){
        List<Comprobante> comprobantes = repository.findAll();
        List<ComprobanteDto> comprobantesDto = new ArrayList<>();
        for (Comprobante comprobante : comprobantes) {
            ComprobanteDto comprobanteDto = this.converter.convert(comprobante);
            comprobantesDto.add(comprobanteDto);
        }
        return comprobantesDto;
    }

    public ComprobanteDto crearComprobante(ComprobanteDto comprobanteDto) {
        Cliente cliente = this.clienteRepository.findById(comprobanteDto.getCliente().getDni())
                .orElseThrow(() -> new RuntimeException("no existe el cliente"));

        Comprobante comprobante = new Comprobante();
        comprobante.setCliente(cliente);
        comprobante.setItemsComprobantes(new HashSet<>());

        List<ItemsComprobanteDto> items = comprobanteDto.getItems();
        for (ItemsComprobanteDto item: items) {
            Producto producto = this.productoRepository.findById(item.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("no existe el producto"));

            if (item.getCantidad() > producto.getStock()){
                throw new RuntimeException("no hay stock");
            }

            ItemsComprobante itemAGuardar = crearItem(item.getCantidad(), producto);

            //this.itemsComprobanteRepository.save(itemAGuardar);

            producto.setStock(producto.getStock() - item.getCantidad());

            this.productoRepository.save(producto);

            comprobante.addItemsComprobante(itemAGuardar);
        }

        Date fechaCreacion = getFechaCreacion();
        comprobante.setFecha_creacion(fechaCreacion);
        this.repository.save(comprobante);

        return this.converter.convert(comprobante);
    }

    private Date getFechaCreacion() {
        try{
            WorldClock worldClock = this.restTemplate.getForObject("http://worldclockapi.com/api/json/utc/now", WorldClock.class);
            return worldClock.getCurrentDateTime();
        }catch (Exception e){
            return new Date();
        }
    }

    private ItemsComprobante crearItem(int cantidad, Producto producto) {
        ItemsComprobante itemsComprobante = new ItemsComprobante();
        itemsComprobante.setCantidad(cantidad);
        itemsComprobante.setDetalle(producto.getDescripcion());
        itemsComprobante.setPrecio(producto.getPrecio().multiply(new BigDecimal(cantidad)));
        itemsComprobante.setPrecioUnitario(producto.getPrecio());
        return itemsComprobante;
    }
}
