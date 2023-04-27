package Repository;

import Entities.Country;
import Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Country findById(Long id) {
        Country country = jdbcTemplate.queryForObject(
                "SELECT * FROM Country WHERE id = ?",
                new Object[]{id},
                new CountryRowMapper()
        );
        return country;
    }

    @Override
    public void save(Country country) {
        jdbcTemplate.update(
                "INSERT INTO Country (name) VALUES (?)",
                country.getName()
        );
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