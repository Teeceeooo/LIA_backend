package Repository;

import Entities.Trait;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class TraitRepositoryImpl implements TraitRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;

    @Override
    public Trait findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Trait WHERE id = ?",
                new Object[]{id},
                new TraitRowMapper()
        );
    }

    @Override
    public void save(Trait trait) {
        jdbcTemplate.update(
                "INSERT INTO Trait (name) VALUES (?)",
                trait.getName()
        );
    }

    @Override
    public List<Trait> getTrait() {
        String sql = "SELECT * FROM Trait";
        RowMapper<Trait> rowMapper = new TraitRowMapper();
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public List<Trait> getTrait2() {
        return null;
    }

    @Override
    public List<Trait> getTrait2(String searchText) {
        String sql = "SELECT * FROM Trait WHERE LOWER(name) LIKE ?";
        String searchParam = searchText != null ? "%" + searchText.toLowerCase() + "%" : "";
        return jdbcTemplate.query(sql, new TraitRowMapper(), searchParam);
    }

    @Override
    public void postTraitDTOtoDatabase(Trait trait) {
        String traitDTOName = trait.getName();
        String traitDTODescription = trait.getDescription();
        String sql = "INSERT INTO Trait (name, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, traitDTOName, traitDTODescription);
    }


    private class TraitRowMapper implements RowMapper<Trait> {
        @Override
        public Trait mapRow(ResultSet rs, int rowNum) throws SQLException {
            Trait trait = new Trait();
            trait.setId(rs.getLong("id"));
            trait.setName(rs.getString("name"));
            trait.setDescription(rs.getString("description"));
            return trait;
        }
    }
}
