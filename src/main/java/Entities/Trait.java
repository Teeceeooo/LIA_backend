package Entities;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.*;
//JDBC | JDBC TEMPLATE -> Serive -> API -> FRONTEND
@Entity
@Table(name = "Class")
public class Trait {
    private JdbcTemplate jdbcTemplate;
    //Läsa på Springboot config
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;


    public Trait() {
    }

    public Trait(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}