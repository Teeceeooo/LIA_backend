package Entities;
import jakarta.persistence.*;

import java.util.List;


public class Champion {

    private Long id;

    private String name;

    private String ultimateInfo;

    private int cost;

    private List<Trait> traits;

    private List<Item> items;

    private List<Origin> origins;

    private int attackRange;

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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }


    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Origin> getOrigins() {
        return origins;
    }

    public void setOrigins(List<Origin> origins) {
        this.origins = origins;
    }
}

