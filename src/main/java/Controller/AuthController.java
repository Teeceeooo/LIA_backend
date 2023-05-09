package Controller;

import DTO.ItemDTO;
import DTO.OriginDTO;
import Entities.Item;
import Entities.User;
import Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/item")
public class AuthController {

    @Autowired
    private AuthService authService;

    // list DTO instead of list Item
    // In service convert DTO
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return authService.findAllUsers();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createItem")
    public void validateLogin(@RequestBody User user) {
        authService.checkUser(user);
    }
}