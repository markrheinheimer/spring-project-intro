package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // Since there is no routing information, by default this method lives at the
    // root path, this can handle requests at the root path localhost:8080 or localhost:8080/
    @GetMapping
    @ResponseBody
    public String rootPath() {
        return "I'm the root path!";
    }

    // Handle request to path /hello

    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }
}