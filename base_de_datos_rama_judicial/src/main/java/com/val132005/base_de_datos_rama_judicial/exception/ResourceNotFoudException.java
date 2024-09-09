package com.val132005.base_de_datos_rama_judicial.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class ResourceNotFoudException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    public ResourceNotFoudException(String message) {
        super(message);
    }

}
