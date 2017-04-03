package by.demo.test;

import by.demo.entity.PersonDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.springframework.boot.test.json.JacksonTester;

public abstract class AbstractTest {

    public JacksonTester<PersonDTO> json;

    @Before
    public void setup() {
        ObjectMapper objectMappper = new ObjectMapper();
        JacksonTester.initFields(this, objectMappper);
    }
}
