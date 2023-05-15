package DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChampionDTO implements Serializable {
    private String name;
    private String description;
}
