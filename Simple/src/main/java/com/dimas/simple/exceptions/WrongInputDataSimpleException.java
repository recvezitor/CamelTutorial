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

public class WrongInputDataSimpleException extends AbstractSimpleException {

    public WrongInputDataSimpleException() {
    }

    public WrongInputDataSimpleException(String message) {
        super(message);
    }

    public WrongInputDataSimpleException(String message, Throwable cause) {
        super(message, cause);
    }

    public WrongInputDataSimpleException(Throwable cause) {
        super(cause);
    }

    @Override
    public ResultCode getResponseCode() {
        return ResultCode.INCORRECT_INPUT_DATA;
    }
}
