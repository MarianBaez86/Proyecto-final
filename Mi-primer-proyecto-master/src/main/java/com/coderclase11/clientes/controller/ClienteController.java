package com.coderclase11.clientes.controller;

import com.coderclase11.clientes.dto.ClienteDto;
import com.coderclase11.clientes.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coderhouse/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteDto> obtenerTodosLosClientes(){
        return clienteService.buscarTodosLosClientes();
    }

    @GetMapping("/{dni}")
    public ClienteDto buscarPorDni(@PathVariable Long dni){
        return clienteService.buscarPordni(dni);
    }

    @PostMapping
    public ClienteDto agregarCliente(@RequestBody ClienteDto clienteDto) {
        return clienteService.agregarCliente(clienteDto);
    }

    @PutMapping
    public ClienteDto actualizarCliente(@RequestBody ClienteDto clienteDto) {
        return clienteService.actualizarCliente(clienteDto);
    }

}
