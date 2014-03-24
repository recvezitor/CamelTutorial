package com.dimas.simple.handlers;

import com.dimas.simple.beans.SimpleRequest;
import com.dimas.simple.beans.SimpleResponse;
import com.dimas.simple.exceptions.AbstractSimpleException;
import org.apache.camel.Body;
import org.apache.camel.ExchangeException;
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
public class SimpleExceptionHandler {

    private final Logger l = LoggerFactory.getLogger(getClass());

    public SimpleExceptionHandler() {
    }

    @Handler
    public SimpleResponse handle(@ExchangeException AbstractSimpleException e, @Headers Map<String, Object> headers, @Body SimpleRequest simpleRequest) {
        SimpleResponse response = new SimpleResponse();
        response.setResultCode(e.getResponseCode());
        l.info("INSIDE exception: headers={}, body={}", headers, simpleRequest);
        l.error("{}", e.getMessage());
        l.debug("{}", e.getStackTrace());
        return response;
    }
}
