package Controller;

import Entities.Country;
import Service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountries")
    public List<Country> getCountries() {
        return countryService.testing();
    }
}