package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Since there is no routing information, by default this method lives at the
    // root path, this can handle requests at the root path localhost:8080 or localhost:8080/
    @GetMapping
//    @ResponseBody
    public String rootPath() {
        return "I'm the root path!";
    }

    // Handle request to path /hello

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
//    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode

//    @GetMapping("hello")  //This handle get request
//    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

        // Handles get and post request
    // lives at /hello/hello
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
////    @ResponseBody
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }


    // Handles requests of the form /hello/LaunchCode

    // lives at /hello/hello/{name}
    @GetMapping("hello/{name}")
//    @ResponseBody
    public String helloWithPathParameter(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // Using a get request
//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action='hello'>" + // submits a request to /hello, by default it is a get request, so the handle above works
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "<html>";
//    }

    // Using a post request
    // lives at /hello/form
    @GetMapping("form")
//    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method ='post'>" +
                "<input type='text' name='name'>" +
                "<select name='language'>" +
                "<option value=''>---choose a language---</option>" +
                "<option value='English'>English</option>" +
                "<option value='German'>German</option>" +
                "<option value='Spanish'>Spanish</option>" +
                "<option value='French'>French</option>" +
                "<option value='Italian'>Italian</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "<html>";
    }

    @RequestMapping(method = RequestMethod.POST, value="hello")
    public String helloPost(@RequestParam String name, String language) {
        if (name == null) {name = "World";}
        return createMessage(name, language);
    }

    public static String createMessage(String name, String language) {
            String chosenLanguage;
            if (language.equals("English")) {
                chosenLanguage = "Hello";
            } else if (language.equals("German")) {
                chosenLanguage = "Hallo";
            } else if (language.equals("Spanish")) {
                chosenLanguage = "Hola";
            } else if (language.equals("French")) {
                chosenLanguage = "Bonjour";
            } else {
                chosenLanguage = "Ciao";
            }
//            return chosenLanguage + " " + name + "!";
            return "<html>" +
                    "<body>" +
                    "<h1 style='color: red'>" + chosenLanguage + " " + name + "!</h1>" +
                    "</body>" +
                    "</html>";
    }
}
