package org.project.wowprofessionweb.controller.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProfessionsController {

    @GetMapping
    @RequestMapping("/professionsInfo")
    public String getProfessionsInfoPage(Model model) {
        model.addAttribute("content", "professionsInfo");
        model.addAttribute("contentHeader", "professionsInfo");
        model.addAttribute("css", "/css/professionsInfo.css");
        return "layout";
    }
}
