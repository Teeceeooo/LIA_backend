package Service;

import DTO.ItemDTO;
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

    public void createItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setDescription(itemDTO.getDescription());
        itemRepository.postItemDTOtoDatabase(item);
    }

    public void updateItem(String name, ItemDTO itemDTO) {
        itemRepository.updateItemDTOtoDatabase(name, itemDTO);
    }

    public void deleteItem(String name) {
        itemRepository.deleteItemDTOfromDatabase(name);
    }
}