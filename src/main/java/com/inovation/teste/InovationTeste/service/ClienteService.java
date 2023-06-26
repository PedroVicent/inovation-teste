package com.inovation.teste.InovationTeste.service;

import com.inovation.teste.InovationTeste.entity.Cliente;
import com.inovation.teste.InovationTeste.entity.dto.ClienteDTO;
import com.inovation.teste.InovationTeste.repository.ClienteRepository;
import com.inovation.teste.InovationTeste.util.Constants;
import com.inovation.teste.InovationTeste.util.exception.ClienteNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente createCliente(ClienteDTO clienteDTO) {
        ModelMapper mapper = new ModelMapper();
        Cliente cliente = mapper.map(clienteDTO, Cliente.class);
        return repository.save(cliente);
    }

    public Cliente findClienteById(Long id) throws ClienteNotFoundException {
        Optional<Cliente> clienteFound = repository.findById(id);
        if (clienteFound.isPresent())
            return clienteFound.get();
        throw new ClienteNotFoundException(Constants.CLIENTE_NOT_FOUND);
    }

    public ResponseEntity deleteClienteById(Long id) throws ClienteNotFoundException {
        Optional<Cliente> clienteFound = repository.findById(id);
        if (clienteFound.isPresent()) {
            repository.delete(clienteFound.get());
            return ResponseEntity.ok().build();
        }
        throw new ClienteNotFoundException(Constants.CLIENTE_NOT_FOUND);
    }

    public List<Cliente> findAllClientes() {
        return repository.findAll();
    }

}
