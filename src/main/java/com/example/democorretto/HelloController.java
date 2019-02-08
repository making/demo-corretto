package com.example.democorretto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @GetMapping(path = "/")
    public Map<Object, Object> javaProps() {
        Map<Object, Object> props = System.getProperties().entrySet().stream()
            .filter(e -> e.getKey().toString().startsWith("java.")) //
            .filter(e -> !e.getKey().toString().equals("java.class.path")) //
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return props;
    }
}
