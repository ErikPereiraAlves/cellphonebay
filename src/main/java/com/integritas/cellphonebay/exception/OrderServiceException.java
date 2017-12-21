package com.integritas.cellphonebay.exception;

public class OrderServiceException extends Exception {

    private static final long serialVersionUID = 6817611783825305345L;

    public OrderServiceException(String message) {
        super(message);
    }

    public OrderServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderServiceException(Throwable cause) {
        super(cause);
    }
}
