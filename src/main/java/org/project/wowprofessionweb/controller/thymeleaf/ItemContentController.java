package org.project.wowprofessionweb.controller.thymeleaf;

import org.project.wowprofessionweb.repository.ItemRepository;
import org.project.wowprofessionweb.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ItemContentController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/item/{id}")
    public String getItemById(@PathVariable("id") Long id, Model model) {
        Repository item = itemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid item Id:" + id));

        model.addAttribute("item", item);
        model.addAttribute("contentHeader", "cardInfo");
        model.addAttribute("content", "cardInfo");
        model.addAttribute("css", "/css/cardInfo.css");

        return "layout";
    }
}
