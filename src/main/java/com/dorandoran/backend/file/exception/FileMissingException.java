package com.dorandoran.backend.file.exception;

public class FileMissingException extends RuntimeException{
    public FileMissingException() {
    }

    public FileMissingException(String message) {
        super(message);
    }
}
