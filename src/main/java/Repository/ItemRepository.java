package Repository;
import Entities.Country;
import Entities.Item;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ItemRepository {
    List<Item> findAllItems();
}
