package com.dimas.simple;

import com.dimas.simple.beans.ResultCode;
import com.dimas.simple.beans.SimpleRequest;
import com.dimas.simple.beans.SimpleResponse;
import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class CamelRouteTest {

    @Autowired
    @Qualifier(value = "simpleCamelContext")
    protected CamelContext camelContext;

    @EndpointInject(uri = "mock:result")
    protected MockEndpoint resultEndpoint;

    @Produce(uri = "direct:start")
    protected ProducerTemplate template;

    @Before
    public void setUp() throws Exception {
        assertNotNull(camelContext);
        assertNotNull(resultEndpoint);
        assertNotNull(template);
    }

    @Test
     public void successfulTest() throws Exception {
        SimpleRequest simpleRequest = initRequest();
        SimpleResponse response = (SimpleResponse)template.requestBody(simpleRequest);
        assertNotNull(response);
        assertEquals("Name is looser", response.getNameOut());
        assertEquals(144, response.getValueOut());
        assertEquals(ResultCode.OK, response.getResultCode());
        resultEndpoint.expectedMessageCount(1);
        resultEndpoint.assertIsSatisfied();
    }

    @Test
    public void returnsWrongInputDataIfNameIsEmpty() throws Exception {
        SimpleRequest simpleRequest = initRequest();
        simpleRequest.setName("");
        SimpleResponse response = (SimpleResponse)template.requestBody(simpleRequest);
        assertNotNull(response);
        assertEquals(null, response.getNameOut());
        assertEquals(ResultCode.INCORRECT_INPUT_DATA, response.getResultCode());
    }

    @Test
    public void returnsSystemErrorIfInputDataHasIncorrectType() throws Exception {
        SimpleResponse response = (SimpleResponse)template.requestBody("wrong request");
        assertNotNull(response);
        assertEquals(null, response.getNameOut());
        assertEquals(ResultCode.SYSTEM_ERROR, response.getResultCode());
    }

    private SimpleRequest initRequest() {
        SimpleRequest simpleRequest = new SimpleRequest();
        simpleRequest.setName("Name");
        simpleRequest.setValue(12);
        return simpleRequest;
    }
}
