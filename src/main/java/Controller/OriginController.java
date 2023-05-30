package Controller;

import DTO.OriginDTO;
import Service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/origin")
public class OriginController {

    @Autowired
    private OriginService originService;

    @GetMapping("/getOrigin")
    public List<OriginDTO> getOrigin() {
        return originService.getAllDTOOrigin();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/createOrigin")
    public void createOrigin(@RequestBody OriginDTO originDTO) {
        originService.createOrigin(originDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/updateOrigin/{name}")
    public void updateOrigin(@PathVariable String name, @RequestBody OriginDTO originDTO) {
        originService.updateOrigin(name, originDTO);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/deleteOrigin/{name}")
    public void deleteOrigin(@PathVariable String name) {
        originService.deleteOrigin(name);
    }
}