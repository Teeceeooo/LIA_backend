package Service;

import DTO.OriginDTO;
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

    public List<Origin> getOrigin() {
        return originRepository.getOrigin();
    }
    /*
    public List<OriginDTO> getAllDTOOrigin() {
        return originRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }
     */

    private OriginDTO convertEntityToDto(Origin origin) {
        OriginDTO originDTO = new OriginDTO();
        originDTO.setName(origin.getName());
        originDTO.setDescription(origin.getDescription());
        return originDTO;
    }

    public void createOrigin(OriginDTO originDTO) {
        Origin origin = new Origin();
        origin.setName(originDTO.getName());
        origin.setDescription(originDTO.getDescription());
        originRepository.postOriginDTOtoDatabase(origin);
    }

    public void updateOrigin(String name, OriginDTO originDTO) {
        originRepository.updateOriginDTOtoDatabase(name, originDTO);
    }

    public void deleteOrigin(String name) {
        originRepository.deleteOriginDTOfromDatabase(name);
    }
}
