package com.dimas.simple.handlers;

import com.dimas.simple.beans.ResultCode;
import com.dimas.simple.beans.SimpleResponse;
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
public class SimpleErrorHandler {

    private final Logger l = LoggerFactory.getLogger(getClass());

    public SimpleErrorHandler() {
    }

    @Handler
    public SimpleResponse handle(@ExchangeException Exception e, @Headers Map<String, Object> headers, @Body Object request) {
        SimpleResponse response = new SimpleResponse();
        response.setResultCode(ResultCode.SYSTEM_ERROR);
        l.info("INSIDE error: headers={}, body={}", headers, request);
        l.error("{}", e.getMessage());
        l.debug("{}", e.getStackTrace());
        return response;
    }
}
