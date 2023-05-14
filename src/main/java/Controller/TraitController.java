package Controller;

import DTO.OriginDTO;
import DTO.TraitDTO;
import Entities.Trait;
import Service.TraitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/trait")
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

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createTrait")
    public void createTrait(@RequestBody TraitDTO traitDTO) {
        traitService.createTrait(traitDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateTrait/{name}")
    public void updateTrait(@PathVariable String name, @RequestBody TraitDTO traitDTO) {
        traitService.updateTrait(name, traitDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteTrait/{name}")
    public void deleteTrait(@PathVariable String name) {
        traitService.deleteTrait(name);
    }
}