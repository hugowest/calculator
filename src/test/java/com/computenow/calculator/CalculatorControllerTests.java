package com.computenow.calculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class CalculatorControllerTests {

    @Mock
    private Calculator calculator;

    @InjectMocks
    private CalculatorController calculatorController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(new CalculatorController()).build();
        this.mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    @Test
    public void testController() throws java.lang.Exception
    {
        this.mockMvc.perform(get("/sum?a=1&b=2")).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"));
    }

}
