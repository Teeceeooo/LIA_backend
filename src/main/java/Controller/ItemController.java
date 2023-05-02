package Controller;

import Entities.Country;
import Entities.Item;
import Service.CountryService;
import Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getItems")
    public List<Item> getItems() {
        return itemService.findAllItems();
    }
}