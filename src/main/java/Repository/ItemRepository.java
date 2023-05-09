package Repository;
import Entities.Item;
import Entities.Origin;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository {
    List<Item> findAllItems();
    List<Item> findAllItems2(String searchText);

    void postItemDTOtoDatabase(Item item);


}
