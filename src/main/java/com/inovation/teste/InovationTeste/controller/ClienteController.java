package com.inovation.teste.InovationTeste.controller;

import com.inovation.teste.InovationTeste.entity.Cliente;
import com.inovation.teste.InovationTeste.entity.dto.ClienteDTO;
import com.inovation.teste.InovationTeste.service.ClienteService;
import com.inovation.teste.InovationTeste.util.exception.ClienteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente create(@RequestBody ClienteDTO clienteDTO) {
        return service.createCliente(clienteDTO);
    }

    @GetMapping(path = "/{id}")
    public Cliente findById(@PathVariable Long id) throws ClienteNotFoundException {
        return service.findClienteById(id);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteCliente(@PathVariable Long id) throws ClienteNotFoundException {
        service.deleteClienteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Cliente> findAllClientes() {
        return service.findAllClientes();
    }
}
