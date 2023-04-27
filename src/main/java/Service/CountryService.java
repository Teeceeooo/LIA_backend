package Service;

import Entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private Repository.CountryRepository countryRepository;

    public List<Country> testing() {
        return countryRepository.findAll();
    }
}
