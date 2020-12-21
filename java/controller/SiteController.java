package com.darkside.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
    @GetMapping("/contact-us")
    public String contact() {
        return "contact-us";
    }
}
