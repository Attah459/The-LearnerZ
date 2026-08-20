package com.thelearnerz.controller;

import com.thelearnerz.model.User;
import com.thelearnerz.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public MainController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping({"/", "/home"})
    public String homePage() { return "home"; }

    @GetMapping("/courses")
    public String courseBrowserPage() { return "course-list"; }

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @GetMapping("/admin")
    public String adminDashboardPage() { return "admin"; }

    @GetMapping("/registration")
    public String registrationPage() { return "registration"; }

    @PostMapping("/registration")
    public String processRegistration(@RequestParam String name,
                                      @RequestParam String email,
                                      @RequestParam String password,
                                      @RequestParam String role) {
        if(userRepository.findByEmail(email).isPresent()) {
            return "redirect:/registration?error=exists";
        }
        User newUser = new User(name, email, passwordEncoder.encode(password), role);
        userRepository.save(newUser);
        return "redirect:/login?registered=true";
    }
}
