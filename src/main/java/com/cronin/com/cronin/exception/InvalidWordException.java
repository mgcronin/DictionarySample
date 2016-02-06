package com.cronin.com.cronin.exception;

import java.io.Serializable;

/**
 * Created by matthewcronin on 2/6/16.
 */
public class InvalidWordException extends Exception implements Serializable {

    public InvalidWordException() {

    }

    public InvalidWordException(String message) {
        super(message);
    }

    public InvalidWordException(Throwable cause) {
        super(cause);
    }

    public InvalidWordException(String message, Throwable cause) {
        super(message, cause);
    }
}



