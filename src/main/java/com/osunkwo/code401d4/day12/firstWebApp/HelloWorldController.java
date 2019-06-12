package com.osunkwo.code401d4.day12.firstWebApp;

import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController

public class HelloWorldController {

    @GetMapping("/hello")
    public String getHellWorld() {
        return "Hello World";
    }

    @GetMapping("/capitalize/{name}")
    public String capitalizeWorld(@PathVariable String name) {
        return name.toUpperCase();
    }

    @GetMapping("/reverse")
    @ResponseBody
    public String reverseSentence(@RequestParam String sentence) {
        Pattern pattern = Pattern.compile("\\s"); //create a regex pattern to represent a whitespace
        String[] tempSentence = pattern.split((sentence)); //split the string into an array index whenever there is a whitespace
        sentence = "";
        for (int i = 0; i < tempSentence.length; i++) {
            if (i == tempSentence.length - 1)
                sentence = tempSentence[i] + sentence;
            else
                sentence = " " + tempSentence[i] + sentence;
        }
        return sentence;
    }
}