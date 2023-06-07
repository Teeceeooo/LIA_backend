package Repository;
import DTO.ChampionDTO;
import DTO.ItemDTO;
import Entities.Champion;
import Entities.Item;
import Entities.Origin;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChampionRepository {
    List<Champion> findAllChampion();

    Champion retriveChampion(Long id);

    void updateChampionDTOtoDatabase(String name, ChampionDTO championDTO);

    void deleteChampionDTOfromDatabase(String name);

    void postChampionDTOtoDatabase(ChampionDTO championDTO);



}
