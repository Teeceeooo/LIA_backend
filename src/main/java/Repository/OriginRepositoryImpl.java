package Repository;

import Entities.Origin;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OriginRepositoryImpl implements OriginRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;

    @Override
    public Origin findById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Origin WHERE id = ?",
                new Object[]{id},
                new OriginRowMapper()
        );
    }

    @Override
    public void save(Origin origin) {
        jdbcTemplate.update(
                "INSERT INTO Origin (name) VALUES (?)",
                origin.getName()
        );
    }

    @Override
    public List<Origin> findAll() {
        String sql = "SELECT * FROM Origin";
        RowMapper<Origin> rowMapper = new OriginRowMapper();
        return jdbcTemplate.query(sql, rowMapper);
    }


    private class OriginRowMapper implements RowMapper<Origin> {
        @Override
        public Origin mapRow(ResultSet rs, int rowNum) throws SQLException {
            Origin origin = new Origin();
            origin.setId(rs.getLong("id"));
            origin.setName(rs.getString("name"));
            origin.setDescription(rs.getString("description"));
            return origin;
        }
    }
}