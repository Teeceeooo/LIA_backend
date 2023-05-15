package Repository;
import DTO.ItemDTO;
import DTO.OriginDTO;
import Entities.Item;
import Entities.Origin;
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
