package com.tuwaner.controller.server;
import java.util.concurrent.atomic.AtomicLong;

import com.tuwaner.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private String name = "Java";

    @RequestMapping(value = "/greeting",method = GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, this.name));
    }

    @RequestMapping(value = "/greeting",method = PUT)
    public String greeting2(@RequestParam(value="name") String name, HttpServletRequest request) {

        this.name = (String) request.getAttribute("name");
        System.out.println(request.getAttribute("name"));
        return request.getAttributeNames().toString();
    }
}

