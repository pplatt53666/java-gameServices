package com.firmys.gameservice.inventory.service;

import com.firmys.gameservice.inventory.impl.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/inventory/items")
    private List<Item> getAllItems() {
        return StreamSupport
                .stream(itemService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/inventory/items/{id}")
    private Item getItem(@PathVariable("id") int id) {
        return itemService.getPersonById(id);
    }

    @DeleteMapping("/inventory/items/{id}")
    private void deleteItem(@PathVariable("id") int id) {
        itemService.delete(id);
    }

    @PostMapping("/inventory/items")
    private int savePerson(@RequestBody Item item) {
        itemService.saveOrUpdate(item);
        return item.getId();
    }
}
