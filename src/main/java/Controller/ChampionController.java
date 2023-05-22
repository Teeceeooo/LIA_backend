package Controller;

import DTO.ChampionDTO;
import DTO.ItemDTO;
import DTO.OriginDTO;
import Entities.Champion;
import Entities.Item;
import Service.ChampionService;
import Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/champion")
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @GetMapping("/getChampions")
    public List<Champion> getChampions() {
        return championService.findAllChampions();
    }

    @GetMapping("/getSelectedChampion/{id}")
    public Champion getSelectedChampion(@PathVariable Long id) {
        return championService.getSelectedChampService(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteChampion/{name}")
    public void deleteChampion(@PathVariable String name) {
        championService.deleteChampion(name);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateChampion/{name}")
    public void updateChampion(@PathVariable String name, @RequestBody ChampionDTO championDTO) {
        championService.updateChampion(name, championDTO);
    }

/*
    @CrossOrigin(origins = "http://localhost:4200")fd
    @PostMapping("/createChampion")
    public void createItem(@RequestBody ChampionDTO championDTO) {
        itemService.createItem(championDTO);
    }
 */
}