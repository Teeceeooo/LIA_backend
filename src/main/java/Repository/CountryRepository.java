package Repository;

import Entities.Country;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository {

    Country findById(Long id);
    void save(Country country);

}