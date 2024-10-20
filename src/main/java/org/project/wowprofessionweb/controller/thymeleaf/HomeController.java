package org.project.wowprofessionweb.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/home")
    public String getHomePage(Model model) {
        model.addAttribute("content", "home");
        model.addAttribute("contentHeader", "home");
        model.addAttribute("css", "/css/home.css");
        return "layout";
    }
}