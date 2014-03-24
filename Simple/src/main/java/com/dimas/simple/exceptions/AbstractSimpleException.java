package com.dimas.simple.exceptions;

import com.dimas.simple.beans.ResultCode;

/**
 * Copyright 2009-2014. NxSystems Inc.
 * PROPRIETARY/CONFIDENTIAL.
 * <p/>
 * Created: 24.03.14 12:55
 *
 * @author Dmitry Borovoy
 */

public abstract class AbstractSimpleException extends Exception {

    protected AbstractSimpleException() {
    }

    protected AbstractSimpleException(String message) {
        super(message);
    }

    protected AbstractSimpleException(String message, Throwable cause) {
        super(message, cause);
    }

    protected AbstractSimpleException(Throwable cause) {
        super(cause);
    }

    public abstract ResultCode getResponseCode();
}
