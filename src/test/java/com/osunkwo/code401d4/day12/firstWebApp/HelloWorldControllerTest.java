package com.osunkwo.code401d4.day12.firstWebApp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class HelloWorldControllerTest {

    //************** Integration Tests fo my Hello World Controller ******************
    @Autowired
    HelloWorldController helloWorldController;

    @Autowired
    MockMvc mockMvc;

    @Test
        public void contextLoads() {
    }

    @Test
        public void testControllerIsAutowired() {
        assertNotNull(helloWorldController);
    }

    @Test
        public void testRequestToRootGivesHelloWorld() throws Exception {
        mockMvc.perform(get("/hello")).andExpect(content().string(containsString("Hello World")));
    }


//************************* Normal Test for my Hello World Controller ********************
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