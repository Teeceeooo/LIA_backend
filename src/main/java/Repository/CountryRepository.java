package Repository;

import Entities.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository {

    Country findById(Long id);
    void save(Country country);

    List<Country> findAll();

}