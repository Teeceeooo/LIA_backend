package Service;

import DTO.ItemDTO;
import DTO.OriginDTO;
import Entities.Item;
import Entities.Origin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    @Autowired
    private Repository.ItemRepository itemRepository;

    public List<Item> findAllItems() {
        return itemRepository.findAllItems();
    }
    public List<Item> findAllUser(String searchText) {
        return itemRepository.findAllItems2(searchText);
    }

    public void createItem(ItemDTO itemDTO){
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        itemRepository.postItemDTOtoDatabase(item);
    }
}