package com.br.api.provadezembro2021.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProdutoAlreadyExistsException extends ServiceException{

    public ProdutoAlreadyExistsException(String message){
        super(message);
    }
}
