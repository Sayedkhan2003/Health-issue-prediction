
package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        if (email.equals("admin@gmail.com") && password.equals("admin")) {
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @PostMapping("/predict")
    public String predict(@RequestParam String symptom, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://127.0.0.1:5000/predict?symptom=" + symptom, String.class);
        model.addAttribute("result", result);
        return "result";
    }
}
