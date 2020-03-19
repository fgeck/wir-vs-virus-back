package org.wirvsvirushackathon.projekt1.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String getHomeContent() {
        return "Hello world";
    }
}
