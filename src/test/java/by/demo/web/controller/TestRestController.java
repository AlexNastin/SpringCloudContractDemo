package by.demo.web.controller;

import by.demo.entity.PersonDTO;
import by.demo.entity.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URI;

/**
 * @author Marcin Grzejszczak
 */

@RestController
class TestRestController {

    @Autowired
    private RestTemplate restTemplate;

    int port = 9090;

    @RequestMapping(method = RequestMethod.POST,
            value = "/check",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String check(@RequestBody PersonDTO person) throws MalformedURLException {
        ResponseEntity<ResponseDTO> response = this.restTemplate.exchange(
                RequestEntity
                        .post(URI.create("http://localhost:" + port + "/check"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(person),
                ResponseDTO.class);
        return "OK";
    }
}
