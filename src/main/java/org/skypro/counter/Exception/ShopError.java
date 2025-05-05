package org.skypro.counter.Exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ShopError {
    private final String code;
    private final String message;
}
