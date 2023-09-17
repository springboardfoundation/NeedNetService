package org.springboardfoundation.common.web;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.SneakyThrows;

@SuppressWarnings("rawtypes")
public abstract class AbstractBaseController {
    
    public ResponseEntity ok() {
        return ResponseEntity.ok().build();
    }

    public ResponseEntity ok(Object body) {
        return ResponseEntity.ok(body);
    }

    @SneakyThrows
    public ResponseEntity created(URI location) {
        return ResponseEntity.created(location).build();
    }

    @SneakyThrows
    public ResponseEntity created(URI location, Object body) {
        return ResponseEntity.created(location).body(body);
    }

    public ResponseEntity noContent() {
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity internalServerError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
