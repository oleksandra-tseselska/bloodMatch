package com.bloodMatch.business.exceptions;

public class ExistInDataBaseException extends IllegalArgumentException {
    public ExistInDataBaseException(String message) {
        super(message);
    }
}