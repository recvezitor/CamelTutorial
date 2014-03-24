package com.dimas.simple.handlers;

import com.dimas.simple.beans.ResultCode;
import com.dimas.simple.beans.SimpleRequest;
import com.dimas.simple.beans.SimpleResponse;
import com.dimas.simple.exceptions.WrongInputDataSimpleException;
import org.apache.camel.Body;
import org.apache.camel.Handler;
import org.apache.camel.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Copyright 2009-2014. NxSystems Inc.
 * PROPRIETARY/CONFIDENTIAL.
 * <p/>
 * Created: 24.03.14 12:55
 *
 * @author Dmitry Borovoy
 */
public class SimpleRequestHandler {

    private final Logger l = LoggerFactory.getLogger(getClass());

    public SimpleRequestHandler() {
    }

    @Handler
    public SimpleResponse handle(@Body SimpleRequest simpleRequest) throws WrongInputDataSimpleException {
        SimpleResponse response = new SimpleResponse();
        if (simpleRequest.getName() == null || simpleRequest.getName().isEmpty()) {
            throw new WrongInputDataSimpleException("Name field null or empty");
        }
        if (simpleRequest.getValue() <0) {
            throw new WrongInputDataSimpleException("Value field must be positive integer");
        }
        response.setNameOut(simpleRequest.getName() + " is looser");
        response.setValueOut(simpleRequest.getValue() * simpleRequest.getValue());
        l.info("INSIDE request handler");
        response.setResultCode(ResultCode.OK);
        return response;
    }
}
