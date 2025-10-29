package com.unibook.IdentityService.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String viewAbout() {
        return "page/about";
    }

    @GetMapping("/product")
    public String viewProduct() {
        return "page/product";
    }
}
