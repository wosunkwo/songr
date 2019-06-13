package com.osunkwo.code401d4.day12.firstWebApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotARestController {

    @GetMapping("/notresthello")
    public String getNotRestHello(Model m){
        String[] allTheNames = new String[] {"nneka", "sonny", "chiko","stella"};
        m.addAttribute("names", allTheNames);
        return "hello";
    }
}
