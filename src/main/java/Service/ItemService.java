package Service;

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
    public List<Item> findAllItems2(String searchText) {
        return itemRepository.findAllItems2(searchText);
    }
}