package com.backbase.test.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExampleController {

    private final RestTemplate restTemplate;

    public ExampleController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/message", produces = {
            "application/json"
    })
    @ResponseStatus(HttpStatus.OK)
    public Object getMessage() {
        String url = "http://access-control:8080/service-api/v3/accesscontrol/legal-entities/root";
       return restTemplate.getForObject(url, Object.class);

    }
}