package by.demo.web.controller;

import by.demo.test.AbstractTest;
import by.demo.entity.PersonDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Marcin Grzejszczak
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(workOffline = true, ids = "by.demo:contract:+:stubs:9090")
@DirtiesContext
public class ControllerTest extends AbstractTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_test() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/check")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json.write(new PersonDTO("Alex", 1)).getJson()))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }
}
