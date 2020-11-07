package com.stepan.todoistback.web.api.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stepan.todoistback.BaseTest;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

public class ApiTest extends BaseTest {
    protected MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    protected ObjectMapper objectMapper;

    @Before
    public void setUp() {
        mvc = webAppContextSetup(context).build();
    }
}
