package com.example.quickie.otherapp.controller;

import com.example.quickie.otherapp.model.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/example")
@Slf4j
public class ExampleController {

    @GetMapping
    public ResponseEntity<Example> getExample() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Example example = new Example();
        example.setId("titi");
        example.setName("toto");
        return ResponseEntity.ok(example);
    }

}
