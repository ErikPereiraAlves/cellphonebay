package com.integritas.cellphonebay.exception;

public class ProductServiceException extends Exception {

    private static final long serialVersionUID = 6817611783825305345L;

    public ProductServiceException(String message) {
        super(message);
    }

    public ProductServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductServiceException(Throwable cause) {
        super(cause);
    }
}
