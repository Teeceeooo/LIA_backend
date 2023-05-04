package Repository;


import DTO.OriginDTO;
import Entities.Origin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OriginRepository {

    Origin findById(Long id);
    void save(Origin origin);

    List<Origin> findAll();

    List<OriginDTO> findAllDTO();

    void postOriginDTOtoDatabase(OriginDTO originDTO);
}