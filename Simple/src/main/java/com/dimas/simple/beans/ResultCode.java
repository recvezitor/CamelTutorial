package com.dimas.simple.beans;

/**
 * Copyright 2009-2014. NxSystems Inc.
 * PROPRIETARY/CONFIDENTIAL.
 * <p/>
 * Created: 24.03.14 16:46
 *
 * @author Dmitry Borovoy
 */
public enum ResultCode {

    UNKNOWN(-1, "UNKNOWN"),
    OK(0, "OK"),
    SYSTEM_ERROR(1, "System resultCode"),
    INCORRECT_INPUT_DATA(2, "Incorrect input data");

    final int code;
    final String description;

    ResultCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return String.format("ResultCode{%s:%d}", name(), code);
    }
}
