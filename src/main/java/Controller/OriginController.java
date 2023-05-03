package Controller;

import DTO.OriginDTO;
import Entities.Country;
import Entities.Origin;
import Service.CountryService;
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
}