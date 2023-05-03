package Controller;

import Entities.Item;
import Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // list DTO instead of list Item
    // In service convert DTO
    @GetMapping("/getItems")
    public List<Item> getItems() {
        return itemService.findAllItems();
    }

    @GetMapping("/getItems2")
    public List<Item> getAll(@RequestParam(required = false) String search) {
        return itemService.findAllItems2(search);
    }
}