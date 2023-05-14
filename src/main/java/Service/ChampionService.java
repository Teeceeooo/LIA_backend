package Service;

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
/*
    public void createChampion(ChampionDTO championDTO){
        Item item = new Item();
        item.setName(championDTO.getName());
        item.setDescription(championDTO.getDescription());
        itemRepository.postItemDTOtoDatabase(item);
    }

 */
}