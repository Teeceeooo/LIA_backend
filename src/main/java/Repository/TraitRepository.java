package Repository;

import Entities.Trait;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TraitRepository {
    Trait findById(Long id);
    void save(Trait trait);

    List<Trait> getTrait();
    List<Trait> getTrait2();

    List<Trait> getTrait2(String searchText);
}
