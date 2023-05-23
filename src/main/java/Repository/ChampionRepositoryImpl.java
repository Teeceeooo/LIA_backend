package Repository;
import DTO.ChampionDTO;
import DTO.ItemDTO;
import Entities.Champion;
import Entities.Item;
import Entities.Origin;
import Entities.Trait;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class ChampionRepositoryImpl implements ChampionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Champion> findAllChampion() {
        String sql = "SELECT * FROM Champion";
        RowMapper<Champion> rowMapper = new ChampionRowMapper();
        log.info("hejhej");

        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Champion retriveChampion(Long id) {
        String sql = "SELECT * FROM Champion WHERE ID = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
                Champion champ = new Champion();
                champ.setId(rs.getLong("id"));
                champ.setName(rs.getString("name"));
                champ.setUltimateInfo(rs.getString("ultimateInfo"));
                champ.setCost(rs.getInt("cost"));

                //Hämta alla Items tillhörande vald Champion
                String champItemIds = rs.getString("recommendedItemIds");
                if (champItemIds != null) {
                    String[] itemValues = champItemIds.split(",");
                    for (String itemId : itemValues) {
                        String itemSql = "SELECT * FROM Item WHERE id = ?";
                        Item item = jdbcTemplate.queryForObject(itemSql, new Object[]{itemId}, (itemRs, itemRowNum) -> {
                            Item newItem = new Item();
                            newItem.setId(itemRs.getLong("id"));
                            newItem.setName(itemRs.getString("name"));
                            newItem.setDescription(itemRs.getString("description"));
                            return newItem;
                        });
                        champ.getRecommendedItemIds().add(item);
                    }
                }

                //Hämta alla Origins tillhörande vald Champion
                String champOriginIds = rs.getString("recommendedOriginIds");
                if (champOriginIds != null) {
                    String[] originValues = champOriginIds.split(",");
                    for (String originId : originValues) {
                        String originSql = "SELECT * FROM Origin WHERE id = ?";
                        Origin origin = jdbcTemplate.queryForObject(originSql, new Object[]{originId}, (originRs, originRowNum) -> {
                            Origin newOrigin = new Origin();
                            newOrigin.setId(originRs.getLong("id"));
                            newOrigin.setName(originRs.getString("name"));
                            newOrigin.setDescription((originRs.getString("description")));
                            return newOrigin;
                        });
                        champ.getRecommendedOriginIds().add(origin);
                    }
                }

                //Hämta alla Traits tillhörande vald Champion
                String champTraitIds = rs.getString("recommendedTraitIds");
                if (champTraitIds != null) {
                    System.out.println("HÄR SKA VI INTE VA jk s jkdasasd jkads jk jklasd jlkö");
                    String[] traitValues = champTraitIds.split(",");
                    for (String traitId : traitValues) {
                        String traitSql = "SELECT * FROM Trait WHERE id = ?";
                        Trait trait = jdbcTemplate.queryForObject(traitSql, new Object[]{traitId}, (traitRs, traitRowNum) -> {
                            Trait newTrait = new Trait();
                            newTrait.setId(traitRs.getLong("id"));
                            newTrait.setName(traitRs.getString("name"));
                            newTrait.setDescription((traitRs.getString("description")));
                            return newTrait;
                        });
                        champ.getRecommendedTraitIds().add(trait);
                    }
                }
                return champ;
            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void updateChampionDTOtoDatabase(String name, ChampionDTO championDTO) {
        // Logic to update the champion
    }

    @Override
    public void deleteChampionDTOfromDatabase(String name) {
        String sql = "DELETE FROM Champion WHERE name = ?";
        jdbcTemplate.update(sql, name);
        System.out.println("Deleting " + name);
    }

    private class ChampionRowMapper implements RowMapper<Champion> {
        @Override
        public Champion mapRow(ResultSet rs, int rowNum) throws SQLException {
            Champion champion = new Champion();
            champion.setId(rs.getLong("id"));
            champion.setName(rs.getString("name"));
            return champion;
        }
    }
}
