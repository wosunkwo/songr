package com.osunkwo.code401d4.day12.firstWebApp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestParam;

import static org.junit.Assert.*;

public class HelloWorldControllerTest {

    HelloWorldController controller;
    @Before
    public void initilizingTheClass(){
         controller = new HelloWorldController();
    }

    //test case for the method that returns back hello world at path /hello
    @Test
    public void testForHelloWorldPath(){
        String expectedOutput = "Hello World";
        assertEquals("This should return through if the functions return value is the same as the expected output", expectedOutput, controller.getHellWorld());
    }

    //test case for the method that returns the capitalized version of any string passed to
    //it at path /capitalize/{any string}
    @Test
    public void testForCapitalizeWorldPath(){
        String expectedOutput = "HELLO WORLD";
        assertEquals("This should return through if the functions return value is the same as the expected output", expectedOutput, controller.capitalizeWorld("hello world"));
    }

    //test case for the method that returns the reverse of any sentence passed to it
    //at path /reverse
    @Test
    public void testForReverseSentencePath(){
        String expectedOutput = "WORLD HELLO";
        assertEquals("This should return through if the functions return value is the same as the expected output", expectedOutput, controller.reverseSentence("HELLO WORLD"));
    }
}