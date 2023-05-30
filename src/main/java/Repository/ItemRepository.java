package Repository;
import DTO.ItemDTO;
import Entities.Item;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository {
    List<Item> findAllItems();
    List<Item> findAllItems2(String searchText);

    void postItemDTOtoDatabase(Item item);
    void updateItemDTOtoDatabase(String name, ItemDTO itemDTO);
    void deleteItemDTOfromDatabase(String name);


}
