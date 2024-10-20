package org.project.wowprofessionweb.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ResourcesController {

    @GetMapping("/resources")
    public String getResourcesPage(Model model) {
        model.addAttribute("content", "resources");
        model.addAttribute("contentHeader", "resources");
        model.addAttribute("css", "/css/resources.css");
        return "layout";
    }
}
