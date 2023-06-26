package com.inovation.teste.InovationTeste.service;

import com.inovation.teste.InovationTeste.entity.Pedido;
import com.inovation.teste.InovationTeste.entity.dto.PedidoDTO;
import com.inovation.teste.InovationTeste.repository.PedidoRepository;
import com.inovation.teste.InovationTeste.util.Constants;
import com.inovation.teste.InovationTeste.util.exception.PedidoNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    private ModelMapper mapper;

    public Pedido createPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = mapper.map(pedidoDTO, Pedido.class);
        pedido.setDataPedido(LocalDateTime.now());
        return repository.save(pedido);
    }

   public Pedido findPedidoById(Long id) throws PedidoNotFoundException {
       Optional<Pedido> pedidoFound = repository.findById(id);
       if (pedidoFound.isPresent())
           return pedidoFound.get();
       throw new PedidoNotFoundException(Constants.PEDIDO_NOT_FOUND);
   }

   public ResponseEntity deletePedidoById(Long id) throws PedidoNotFoundException {
       Optional<Pedido> pedidoFound = repository.findById(id);
       if (pedidoFound.isPresent()) {
           repository.delete(pedidoFound.get());
           return ResponseEntity.ok().build();
       }
       throw new PedidoNotFoundException(Constants.PEDIDO_NOT_FOUND);
   }

   public List<Pedido> findAllPedidos() {
        return repository.findAll();
   }

}
