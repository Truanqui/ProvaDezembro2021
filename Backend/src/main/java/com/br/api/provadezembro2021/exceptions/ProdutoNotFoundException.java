package com.br.api.provadezembro2021.exceptions;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProdutoNotFoundException extends ServiceException{

    public ProdutoNotFoundException(String message){
        super(message);
    }

}
