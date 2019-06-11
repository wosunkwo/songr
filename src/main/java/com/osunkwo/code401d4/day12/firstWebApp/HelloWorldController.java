package com.osunkwo.code401d4.day12.firstWebApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {

    @GetMapping("/")
    public String getHellWorld(){
        return "Hello World";
    }

    @GetMapping("/hello/{name}")
    public String getHelloToMe(@PathVariable String name){
        return "Hello " + name;
    }

}
