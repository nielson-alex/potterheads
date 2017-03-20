/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.util.Objects;

/**
 *
 * @author Alex
 */
public class InventoryItem {

    private String name;
    private String description;
    private int quantityInStock;
    private InventoryItemType type;

    public enum InventoryItemType {
        snitch,
        timeTurner,
        maraudersMap,
        invisibilityCloak,
        americanMoney,
        gillyweed,
        firecrackers,
        replacementWand;
    }

    //constructor function
    public InventoryItem() {
    }

    public InventoryItem(InventoryItemType inventoryItemType) {
        this.type = inventoryItemType;

        switch (inventoryItemType) {
            case snitch:
                this.name = "Expelliarmus";
                this.description = "Disarms the enemy";
                this.quantityInStock = 0;
                break;
            case timeTurner:
                this.name = "Stupify";
                this.description = "Stuns the enemy";
                this.quantityInStock = 0;
                break;
            case maraudersMap:
                this.name = "petrificusTotalus";
                this.description = "Slashes the enemy";
                this.quantityInStock = 0;
                break;
            case invisibilityCloak:
                this.name = "Sectumsempra";
                this.description = "Does something";
                this.quantityInStock = 0;
                break;
            case americanMoney:
                this.name = "Wingardium Leviosa";
                this.description = "Makes objects float";
                this.quantityInStock = 0;
                break;
            case gillyweed:
                this.name = "Gillyweed";
                this.description = "Neville gave this to you";
                this.quantityInStock = 0;
                break;
            case firecrackers:
                this.name = "Firecrackers";
                this.description = "Fred and George would like these";
                this.quantityInStock = 0;
                break;
            case replacementWand:
                this.name = "Replacement Wand";
                this.description = "Ron might need this";
                this.quantityInStock = 0;
                break;
        }
    }

    //getters and setters
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

    public InventoryItemType getType() {
        return type;
    }

    public void setType(InventoryItemType type) {
        this.type = type;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + this.quantityInStock;
        return hash;
    }

    //hashcode and equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InventoryItem other = (InventoryItem) obj;
        if (this.quantityInStock != other.quantityInStock) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    // toString()
    @Override
    public String toString() {
        return "InventoryItem{" + "name=" + name + ", description=" + description + ", quantityInStock=" + quantityInStock + '}';
    }
}
