package com.coderclase11.clientes.converter.entity;

import com.coderclase11.clientes.dto.ClienteDto;
import com.coderclase11.clientes.dto.ComprobanteDto;
import com.coderclase11.clientes.dto.ItemsComprobanteDto;
import com.coderclase11.clientes.dto.ProductoDto;
import com.coderclase11.clientes.model.Comprobante;
import com.coderclase11.clientes.model.ItemsComprobante;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ComprobanteEntityADtoConverter {

    public ComprobanteDto convert(Comprobante comprobante) {
        ComprobanteDto comprobanteDto = new ComprobanteDto();

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setDni(comprobante.getCliente().getDni());

        comprobanteDto.setId(comprobante.getId());
        comprobanteDto.setCliente(clienteDto);

        BigDecimal total = BigDecimal.ZERO;
        List<ItemsComprobanteDto> items = new ArrayList<>();
        int cantidad = 0;
        for (ItemsComprobante item: comprobante.getItemsComprobantes()) {

            ItemsComprobanteDto i = new ItemsComprobanteDto();
            i.setCantidad(item.getCantidad());

            ProductoDto productoDto = new ProductoDto();
            productoDto.setId(item.getId());
            productoDto.setDescripcion(item.getDetalle());
            productoDto.setPrecio(item.getPrecio());
            productoDto.setPrecioUnitario(item.getPrecioUnitario());

            i.setProducto(productoDto);

            items.add(i);

            cantidad = cantidad + item.getCantidad();
            total = total.add(item.getPrecio());
        }
        comprobanteDto.setTotal(total);
        comprobanteDto.setItems(items);
        comprobanteDto.setCantidadDeProductos(cantidad);
        comprobanteDto.setFechaCreacion(comprobante.getFecha_creacion());
        return comprobanteDto;
    }
}

