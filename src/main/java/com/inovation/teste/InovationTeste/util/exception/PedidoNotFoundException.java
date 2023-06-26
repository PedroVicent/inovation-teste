package com.inovation.teste.InovationTeste.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PedidoNotFoundException extends Exception {
    public PedidoNotFoundException(String ex) { super(ex); }
}
