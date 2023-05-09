package Repository;

import DTO.OriginDTO;
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
    public Origin findById2(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM Origin WHERE id = ?",
                new Object[]{id},
                new OriginRowMapper()
        );
    }
    @Override
    public Origin findById(Long id) {
        return entityManager.find(Origin.class, id);
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

    @Override
    public List<OriginDTO> findAllDTO() {
        String sql = "SELECT id, name, description FROM Origin";
        RowMapper<OriginDTO> rowMapper = new OriginDTORowMapper();
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public void postOriginDTOtoDatabase(Origin origin) {
        Long originDTOID = origin.getId();
        String originDTOName = origin.getName();
        String originDTODescription = origin.getDescription();
        String sql = "INSERT INTO Origin (id, name, description) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, originDTOID, originDTOName, originDTODescription);
    }

    @Override
    public void updateOriginDTOtoDatabase(String name, OriginDTO originDTO) {
        String sql = "UPDATE Origin SET name = ?, description = ? WHERE name = ?";
        System.out.println("Updating origin with name: " + name);
        System.out.println("New origin name: " + originDTO.getName());
        System.out.println("New origin description: " + originDTO.getDescription());
        int rowsUpdated = jdbcTemplate.update(sql, originDTO.getName(), originDTO.getDescription(), name);
        System.out.println(rowsUpdated + " row(s) updated");
    }

    private class OriginDTORowMapper implements RowMapper<OriginDTO> {
        @Override
        public OriginDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            OriginDTO originDTO = new OriginDTO();
            //originDTO.setId(rs.getLong("id"));
            originDTO.setName(rs.getString("name"));
            originDTO.setDescription(rs.getString("description"));
            return originDTO;
        }
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