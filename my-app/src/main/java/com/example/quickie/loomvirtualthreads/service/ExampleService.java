package com.example.quickie.loomvirtualthreads.service;

import com.example.quickie.loomvirtualthreads.model.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class ExampleService {

    public List<Example> getAllExample() {
        log.info("Current thread before rest call is {}", Thread.currentThread());
        RestClient restClient = RestClient.create();
        Example response = restClient.get()
                .uri("http://127.0.0.1:8082/example")
                .accept(APPLICATION_JSON)
                .retrieve()
                .body(Example.class);
        log.info("Current thread after rest call is {}", Thread.currentThread());
        List<Example> examples = new ArrayList<>();
        examples.add(response);
        return examples;
    }

}
