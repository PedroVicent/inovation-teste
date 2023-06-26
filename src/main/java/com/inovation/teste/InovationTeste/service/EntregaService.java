package com.inovation.teste.InovationTeste.service;

import com.inovation.teste.InovationTeste.entity.Entrega;
import com.inovation.teste.InovationTeste.entity.dto.EntregaDTO;
import com.inovation.teste.InovationTeste.repository.EntregaRepository;
import com.inovation.teste.InovationTeste.util.Constants;
import com.inovation.teste.InovationTeste.util.exception.EntregaNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository repository;

    private ModelMapper mapper;

    public Entrega createEntrega (EntregaDTO entregaDTO) {
        Entrega entrega = mapper.map(entregaDTO, Entrega.class);
        return repository.save(entrega);
    }

    public Entrega findEntregaById(Long id) throws EntregaNotFoundException {
        Optional<Entrega> entregaFound = repository.findById(id);
        if (entregaFound.isPresent())
            return entregaFound.get();
        throw new EntregaNotFoundException(Constants.ENTREGA_NOT_FOUND);
    }

    public ResponseEntity deleteEntregaById(Long id) throws EntregaNotFoundException {
        Optional<Entrega> entregaFound = repository.findById(id);
        if (entregaFound.isPresent()) {
            repository.delete(entregaFound.get());
            return ResponseEntity.ok().build();
        }
        throw new EntregaNotFoundException(Constants.ENTREGA_NOT_FOUND);
    }

    public List<Entrega> findAllEntregas() {
        return repository.findAll();
    }

}
