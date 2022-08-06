package com.coderclase11.clientes.converter.dto;

import com.coderclase11.clientes.dto.ClienteDto;
import com.coderclase11.clientes.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteDtoAEntityConverter {
    public Cliente convert(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setDni(clienteDto.getDni() != null ? clienteDto.getDni() : null);
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellido(clienteDto.getApellido());
        cliente.setFechaNacimiento(clienteDto.getFechaDeNacimiento());
        return cliente;
    }
}

