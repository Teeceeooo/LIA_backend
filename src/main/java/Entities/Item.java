package Entities;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private String name;
    private String icon;
    private String description;
}
