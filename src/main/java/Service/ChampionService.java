package Service;

import DTO.ChampionDTO;
import DTO.ItemDTO;
import DTO.OriginDTO;
import Entities.Champion;
import Entities.Item;
import Entities.Origin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionService {

    @Autowired
    private Repository.ChampionRepository championRepository;

    public List<Champion> findAllChampions() {
        return championRepository.findAllChampion();
    }

    public Champion getSelectedChampService(Long id) {
        return championRepository.retriveChampion(id);
    }

    public void updateChampion(String name, ChampionDTO championDTO) {
        championRepository.updateChampionDTOtoDatabase(name, championDTO);
    }

    public void deleteChampion(String name) {
        championRepository.deleteChampionDTOfromDatabase(name);
    }
/*
    public void createChampion(ChampionDTO championDTO){
        Item item = new Item();
        item.setName(championDTO.getName());
        item.setDescription(championDTO.getDescription());
        itemRepository.postItemDTOtoDatabase(item);
    }

 */
}