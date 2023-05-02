package Service;

import Entities.Country;
import Entities.Origin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginService {

    @Autowired
    private Repository.OriginRepository originRepository;

    public List<Origin> testing() {
        return originRepository.findAll();
    }
}
