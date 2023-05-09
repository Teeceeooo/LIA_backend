package Controller;

import Entities.User;
import Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/users")
public class AuthController {

    @Autowired
    private AuthService authService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<String> validateLogin(@RequestBody User user) {
        if(authService.checkUser(user)){
            System.out.println("TRUE");
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).build();
        } else {
            System.out.println("FALSE");
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).build();
        }


    }
}