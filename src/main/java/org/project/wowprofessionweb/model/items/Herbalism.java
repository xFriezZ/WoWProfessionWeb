package org.project.wowprofessionweb.model.items;

public class Herbalism {
    private String name;
    private String itemLvl;
    private String description;
    private String maxInStack;
    private String sellingPrice;
    private long idItem;

    public Herbalism(String name, String itemLvl, String description, String maxInStack, String sellingPrice, long idItem) {
        this.name = name;
        this.itemLvl = itemLvl;
        this.description = description;
        this.maxInStack = maxInStack;
        this.sellingPrice = sellingPrice;
        this.idItem = idItem;
    }
}
