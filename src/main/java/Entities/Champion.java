package Entities;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Champion {
    private Long id;
    private String name;
    private String ultimateInfo;
    private int cost;
    private Integer attackRange;
    private List<Item> recommendedItemIds = new ArrayList<>();
    private List<Origin> recommendedOriginIds = new ArrayList<>();
    private List<Trait> recommendedTraitIds = new ArrayList<>();
}
