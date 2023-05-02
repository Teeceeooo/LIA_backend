package Service;

import Entities.Country;
import Entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private Repository.ItemRepository itemRepository;

    public List<Item> findAllItems() {
        return itemRepository.findAllItems();
    }
}