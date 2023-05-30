package Entities;

import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;

@Data
public class Trait {
    private JdbcTemplate jdbcTemplate;
    private Long id;
    private String name;
    private String description;
}