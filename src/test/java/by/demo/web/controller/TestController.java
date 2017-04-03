package by.demo.web.controller;

import by.demo.entity.PersonDTO;
import by.demo.entity.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @RequestMapping(value = "/check",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseDTO check(@RequestBody PersonDTO personDTO) {
        System.out.println(personDTO);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setHttpStatus(HttpStatus.OK);
        responseDTO.setMessage("OK");
        return responseDTO;
    }
}