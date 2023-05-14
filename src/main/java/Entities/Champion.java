package Entities;
import java.util.ArrayList;
import java.util.List;

public class Champion {
    private Long id;
    private String name;
    private String ultimateInfo;
    private int cost;
    private Integer attackRange;
    private List<Item> recommendedItemIds;
    private List<Origin> recommendedOriginIds;
    private List<Trait> recommendedTraitIds;

    public Champion() {}

    public Champion(Long id, String name, String ultimateInfo, Integer cost, Integer attackRange, List<Item> recommendedItemIds, List<Origin> recommendedOriginIds, List<Trait> recommendedTraitIds) {
        this.id = id;
        this.name = name;
        this.ultimateInfo = ultimateInfo;
        this.cost = cost;
        this.attackRange = attackRange;
        this.recommendedItemIds = recommendedItemIds;
        this.recommendedOriginIds = recommendedOriginIds;
        this.recommendedTraitIds = recommendedTraitIds;
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

    public String getUltimateInfo() {
        return ultimateInfo;
    }

    public void setUltimateInfo(String ultimateInfo) {
        this.ultimateInfo = ultimateInfo;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


    public Integer getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(Integer attackRange) {
        this.attackRange = attackRange;
    }


    public List<Item> getRecommendedItemIds() {
        if (recommendedItemIds == null) {
            recommendedItemIds = new ArrayList<>();
        }
        return recommendedItemIds;
    }

    public void setRecommendedItemIds(List<Item> recommendedItemIds) {
        this.recommendedItemIds = recommendedItemIds;
    }



    public List<Origin> getRecommendedOriginIds() {
        if (recommendedOriginIds == null) {
            recommendedOriginIds = new ArrayList<>();
        }
        return recommendedOriginIds;
    }

    public void setRecommendedOriginIds(List<Origin> recommendedOriginIds) {
        this.recommendedOriginIds = recommendedOriginIds;
    }

    public List<Trait> getRecommendedTraitIds() {
        if (recommendedTraitIds == null) {
            recommendedTraitIds = new ArrayList<>();
        }
        return recommendedTraitIds;
    }

    public void setRecommendedTraitIds(List<Trait> recommendedTraitIds) {
        this.recommendedTraitIds = recommendedTraitIds;
    }
}
