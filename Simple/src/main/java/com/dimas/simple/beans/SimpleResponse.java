package com.dimas.simple.beans;

/**
 * Copyright 2009-2014. NxSystems Inc.
 * PROPRIETARY/CONFIDENTIAL.
 * <p/>
 * Created: 24.03.14 12:55
 *
 * @author Dmitry Borovoy
 */
public class SimpleResponse {

    int valueOut;
    String nameOut;
    ResultCode resultCode = ResultCode.UNKNOWN;

    public int getValueOut() {
        return valueOut;
    }

    public void setValueOut(int valueOut) {
        this.valueOut = valueOut;
    }

    public String getNameOut() {
        return nameOut;
    }

    public void setNameOut(String nameOut) {
        this.nameOut = nameOut;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    @Override
    public String toString() {
        return "SimpleResponse{" +
                "valueOut=" + valueOut +
                ", nameOut='" + nameOut + '\'' +
                ", resultCode=" + resultCode +
                '}';
    }
}
