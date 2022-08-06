package com.coderclase11.clientes.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ComprobanteDto {
    private ClienteDto cliente;
    private List<ItemsComprobanteDto> items;

    private BigDecimal total;
    private int cantidadDeProductos;
    private Long id;
    private Date fechaCreacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public List<ItemsComprobanteDto> getItems() {
        return items;
    }

    public void setItems(List<ItemsComprobanteDto> items) {
        this.items = items;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}