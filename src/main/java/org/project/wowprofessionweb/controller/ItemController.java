package org.project.wowprofessionweb.controller;

import org.project.wowprofessionweb.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;


    @GetMapping("/add-items")
    public void addItems() {
        itemService.addAndSaveItems();
    }

}
