package org.skypro.counter.Exception;

import lombok.Getter;
import java.lang.RuntimeException;
import java.util.UUID;


@Getter
public class NoSuchProductException extends RuntimeException {
    private final UUID id;

    public NoSuchProductException(UUID id) {
        super("No such product, id: [%S]".formatted(id));
        this.id = id;
    }

}
