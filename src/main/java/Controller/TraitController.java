package Controller;

import Entities.Trait;
import Service.TraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/traits")
public class TraitController {

    @Autowired
    private TraitService traitService;

    // list DTO instead of list Item
    // In service convert DTO
    @GetMapping("/getTraits")
    public List<Trait> getTrait() {
        return traitService.getTrait();
    }

    @GetMapping("/getTraits2")
    public List<Trait> getAll(@RequestParam(required = false) String search) {
        return traitService.getTrait2(search);
    }
}