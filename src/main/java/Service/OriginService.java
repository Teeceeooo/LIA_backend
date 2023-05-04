package Service;

import DTO.OriginDTO;
import Entities.Country;
import Entities.Origin;
import Repository.OriginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OriginService {

    @Autowired
    private OriginRepository originRepository;

    public List<OriginDTO> getAllDTOOrigin() {
        return originRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    private OriginDTO convertEntityToDto(Origin origin) {
        OriginDTO originDTO = new OriginDTO();
       // originDTO.setId(origin.getId());
        originDTO.setName(origin.getName());
        originDTO.setDescription(origin.getDescription());
        return originDTO;
    }

    public void createOrigin(OriginDTO originDTO){
       OriginDTO newOriginDTO = new OriginDTO();
       newOriginDTO.setName(originDTO.getName());
       newOriginDTO.setDescription(originDTO.getDescription());
        originRepository.postOriginDTOtoDatabase(newOriginDTO);
    }




}
