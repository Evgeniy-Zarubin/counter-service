package org.skypro.counter.Exception;

import java.lang.RuntimeException;

public class NoSuchProductException extends RuntimeException {
    public NoSuchProductException(String message) {
        super(message);
    }
}
