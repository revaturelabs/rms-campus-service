package com.revature.rms.campus.controllers;

import com.revature.rms.campus.entities.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = TestController.class)
public class TestControllerTest {


    private MockMvc mockMvc;

    @Autowired
    private void setMockMvc(MockMvc mockMvc){
        this.mockMvc = mockMvc;
    }

    @Before
    public void setup() {
        final TestController testController = new TestController();
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }


    @Test
    public void shouldReturnString() throws Exception {
        User test = new User(1,"Juan","Valencia");
        this.mockMvc.perform(get("/v2/test/user"))
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", is("application/json")))
                .andExpect(jsonPath("$.firstName", is("Juan")));
    }
}
