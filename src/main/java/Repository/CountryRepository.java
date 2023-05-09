package Repository;

import Entities.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository {

    Country findById(Long id);
    void save(Country country);

    List<Country> findAll();

    // test backend->frontend typeahead
    List<Country> findAll2(String search);
}