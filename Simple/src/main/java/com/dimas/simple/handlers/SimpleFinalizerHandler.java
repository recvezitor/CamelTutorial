package com.dimas.simple.handlers;

import com.dimas.simple.beans.ResultCode;
import com.dimas.simple.beans.SimpleResponse;
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
public class SimpleFinalizerHandler {

    private final Logger l = LoggerFactory.getLogger(getClass());

    public SimpleFinalizerHandler() {
    }

    @Handler
    public void handle(@Body SimpleResponse simpleResponse) {
        l.info("finalizer. do some final stuff");
    }
}
