package com.coderclase11.clientes.dto;

public class ItemsComprobanteDto {
    private int cantidad;
    private ProductoDto producto;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public ProductoDto getProducto() {
        return producto;
    }

    public void setProducto(ProductoDto producto) {
        this.producto = producto;
    }
}



