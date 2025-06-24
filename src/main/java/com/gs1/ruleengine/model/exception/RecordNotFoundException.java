package com.gs1.ruleengine.model.exception;

import java.io.Serial;

/**
 * DB Record not found exception
 *
 * @author Mahmoud Shtayeh
 */
public class RecordNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -4328743L;

    /**
     * Create exception using a passed in message
     *
     * @param message Exception message
     */
    public RecordNotFoundException(final String message) {
        super(message);
    }
}