package Service;

import Entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private Repository.CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public List<Country> findAll2(String searchText) {return countryRepository.findAll2(searchText);}
}
