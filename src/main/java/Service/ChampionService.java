package Service;

import DTO.ChampionDTO;
import Entities.Champion;
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

    public void createChampion(ChampionDTO championDTO){
        Champion champion = new Champion();
        champion.setName(championDTO.getName());
        champion.setCost(championDTO.getCost());
        champion.setUltimateInfo(championDTO.getUltimateInfo());
        championRepository.postChampionDTOtoDatabase(champion);
    }

}