package com.catalisa.sistemaEstoque.service.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
public DataIntegrityViolationException(String message){
    super(message);
}
}
