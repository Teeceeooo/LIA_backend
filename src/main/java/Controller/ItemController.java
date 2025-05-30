package Controller;

import DTO.ItemDTO;
import Entities.Item;
import Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getItems")
    public List<Item> getItems() {
        return itemService.findAllItems();
    }

    @GetMapping("/getItems2")
    public List<Item> getAll(@RequestParam(required = false) String search) {
        return itemService.findAllItems2(search);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createItem")
    public void createItem(@RequestBody ItemDTO itemDTO) {
        itemService.createItem(itemDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateItem/{name}")
    public void updateItem(@PathVariable String name, @RequestBody ItemDTO itemDTO) {
        itemService.updateItem(name, itemDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteItem/{name}")
    public void deleteItem(@PathVariable String name) {
        itemService.deleteItem(name);
    }
}