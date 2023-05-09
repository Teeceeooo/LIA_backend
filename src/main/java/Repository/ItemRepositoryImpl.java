package Repository;
import Entities.Origin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import jakarta.persistence.EntityManager;
import Entities.Item;

@Repository
public class ItemRepositoryImpl implements ItemRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Item> findAllItems() {
        String sql = "SELECT * FROM Item";
        RowMapper<Item> rowMapper = new ItemRowMapper();
        return jdbcTemplate.query(sql, rowMapper);
    }
    @Override
    public List<Item> findAllItems2(String searchText) {
        String sql = "SELECT * FROM Item WHERE LOWER(name) LIKE ?";
        String searchParam = searchText != null ? "%" + searchText.toLowerCase() + "%" : "";
        return jdbcTemplate.query(sql, new ItemRowMapper(), searchParam);
    }

    @Override
    public void postItemDTOtoDatabase(Item item) {
        String itemDTOName = item.getName();
        String itemDTODescription = item.getDescription();
        String sql = "INSERT INTO Item (name, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, itemDTOName, itemDTODescription);
    }


    private class ItemRowMapper implements RowMapper<Item> {
        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            Item item = new Item();
            item.setId(rs.getLong("id"));
            item.setName(rs.getString("name"));
            item.setDescription(rs.getString("description"));
            return item;
        }
    }
}
