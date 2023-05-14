package Repository;
import Entities.Champion;
import Entities.Item;
import Entities.Origin;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChampionRepository {
    List<Champion> findAllChampion();

    Champion retriveChampion(Long id);



}
