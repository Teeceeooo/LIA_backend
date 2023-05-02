package Repository;

import Entities.Country;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;

    @Override
    public Country findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Country WHERE id = ?",
                new Object[]{id},
                new CountryRowMapper()
        );
    }

    @Override
    public void save(Country country) {
        jdbcTemplate.update(
                "INSERT INTO Country (name) VALUES (?)",
                country.getName()
        );
    }

    @Override
    public List<Country> findAll() {
        String sql = "SELECT * FROM Country";
        RowMapper<Country> rowMapper = new CountryRowMapper();
        return jdbcTemplate.query(sql, rowMapper);
    }


    private class CountryRowMapper implements RowMapper<Country> {
        @Override
        public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
            Country country = new Country();
            country.setId(rs.getLong("id"));
            country.setName(rs.getString("name"));
            return country;
        }
    }
}