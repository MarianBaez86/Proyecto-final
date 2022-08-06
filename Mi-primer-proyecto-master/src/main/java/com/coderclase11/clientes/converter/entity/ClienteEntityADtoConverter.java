package com.coderclase11.clientes.converter.entity;

import com.coderclase11.clientes.dto.ClienteDto;
import com.coderclase11.clientes.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteEntityADtoConverter {
    public ClienteDto convert(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setDni(cliente.getDni());
        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setApellido(cliente.getApellido());
        clienteDto.setFechaDeNacimiento(cliente.getFechaNacimiento());
        return clienteDto;
    }

}
