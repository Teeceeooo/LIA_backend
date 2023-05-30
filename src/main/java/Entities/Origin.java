package Entities;

import lombok.Data;

import javax.persistence.*;

@Data
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
}