package com.thelearnerz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({"/", "/home"})
    public String homePage() {
        return "home";
    }

    @GetMapping("/courses")
    public String courseBrowserPage() {
        return "course-list";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

  
}
