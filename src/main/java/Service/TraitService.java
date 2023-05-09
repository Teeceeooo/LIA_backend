package Service;

import DTO.TraitDTO;
import Entities.Origin;
import Entities.Trait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraitService {

    @Autowired
    private Repository.TraitRepository traitRepository;

    public List<Trait> getTrait() {
        return traitRepository.getTrait();
    }
    public List<Trait> getTrait2(String searchText) {
        return traitRepository.getTrait2(searchText);
    }

    public void createTrait(TraitDTO traitDTO) {
        Trait trait = new Trait();
        trait.setName(traitDTO.getName());
        trait.setDescription(traitDTO.getDescription());
        traitRepository.postTraitDTOtoDatabase(trait);
    }
}