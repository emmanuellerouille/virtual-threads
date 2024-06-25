package com.example.quickie.loomvirtualthreads.controller;

import com.example.quickie.loomvirtualthreads.model.Example;
import com.example.quickie.loomvirtualthreads.service.ExampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/examples")
@Slf4j
public class ExampleController {

    @Autowired
    public ExampleService exampleService;

    @GetMapping
    public ResponseEntity<List<Example>> getExamples() {
        //System.out.println("Number of threads " + Thread.activeCount());
        log.info("Current thread is {}", Thread.currentThread());
        return ResponseEntity.ok(exampleService.getAllExample());
    }

}
