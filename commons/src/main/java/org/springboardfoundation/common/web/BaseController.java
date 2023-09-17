package org.springboardfoundation.common.web;

import static org.springboardfoundation.common.utiliy.Constants.OPERATION_ID;

import java.net.URI;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("rawtypes")
public class BaseController extends AbstractBaseController {

    public ResponseEntity okBody(Optional body) {
        return body.isPresent() ? super.ok(body) : super.ok();
    }

    public ResponseEntity ok(String operationId) {
        return ResponseEntity.ok().header(OPERATION_ID, operationId).build();
    }

    public ResponseEntity ok(Object body, String operationId) {
        return ResponseEntity.ok().header(OPERATION_ID, operationId).body(body);
    }

    public ResponseEntity ok(Object body, HttpHeaders httpHeaders) {
        return ResponseEntity.ok().headers(httpHeaders).body(body);
    }

    public ResponseEntity ok(HttpHeaders httpHeaders) {
        return ResponseEntity.ok().headers(httpHeaders).build();
    }

    public ResponseEntity ok(Object body, String operationId, MediaType contentType) {
        return ResponseEntity.ok().header(OPERATION_ID, operationId).contentType(contentType).body(body);
    }

    public ResponseEntity ok(Object body, MediaType contentType) {
        return ResponseEntity.ok().contentType(contentType).body(body);
    }

    public ResponseEntity created(URI location, String operationId) {
        return ResponseEntity.created(location).header(OPERATION_ID, operationId).build();
    }

    public ResponseEntity created(URI location, Object body, String operationId) {
        return ResponseEntity.created(location).header(OPERATION_ID, operationId).body(body);
    }

    public ResponseEntity seeOther(URI location, String operationId, String message) {
        return ResponseEntity.status(HttpStatus.SEE_OTHER).header(OPERATION_ID, operationId).header("Location", location.toString()).body(message);
    }

    public ResponseEntity noContent(String operationId) {
        return ResponseEntity.noContent().header(OPERATION_ID, operationId).build();
    }

    public ResponseEntity forbidden(Object body, String operationId) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).header(OPERATION_ID, operationId).body(body);
    }

    public ResponseEntity badRequest(String operationId) {
        return ResponseEntity.badRequest().header(OPERATION_ID, operationId).build();
    }

    public ResponseEntity accepted(String operationId) {
        return ResponseEntity.accepted().header(OPERATION_ID, operationId).build();
    }

    public ResponseEntity internalServerError(String operationId) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).header(OPERATION_ID, operationId).build();
    }

    public ResponseEntity conflict(String operationId, String message) {
        return ResponseEntity.status(HttpStatus.CONFLICT).header(OPERATION_ID, operationId).body(message);
    }

    public ResponseEntity notAcceptable(String operationId) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).header(OPERATION_ID, operationId).build();
    }
}
