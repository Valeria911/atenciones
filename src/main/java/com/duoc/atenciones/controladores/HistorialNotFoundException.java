package com.duoc.atenciones.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HistorialNotFoundException extends RuntimeException {

    public HistorialNotFoundException(String mensaje) {
        super(mensaje);
    }
}
