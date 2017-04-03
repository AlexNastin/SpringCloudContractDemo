package by.demo;


import by.demo.web.controller.TestController;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContractVerifierBase {


    @InjectMocks
    private TestController testController;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(testController);
    }
}
