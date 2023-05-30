package DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChampionDTO implements Serializable {
    private String name;
    private String ultimateInfo;
    private int cost;
    private String recommendedItems;
    private String recommendedOrigins;
    private String recommendedTraits;
}
