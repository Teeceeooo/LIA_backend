package Repository;
import Entities.Item;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository {
    List<Item> findAllItems();
    List<Item> findAllItems2(String searchText);


}
