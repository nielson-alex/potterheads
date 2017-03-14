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
    private String inventoryType;
    private int quantityInStock;

    
    
    //constructor function
    public InventoryItem() {
    }
    
    public InventoryItem(String name, String description, String inventoryType, int quantityInStock) {
        this.name = name;
        this.description = description;
        this.inventoryType = inventoryType;
        this.quantityInStock = quantityInStock;
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

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
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
        hash = 47 * hash + Objects.hashCode(this.inventoryType);
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
        if (!Objects.equals(this.inventoryType, other.inventoryType)) {
            return false;
        }
        return true;
    }

    
    
    
    // toString()
    @Override
    public String toString() {
        return "InventoryItem{" + "name=" + name + ", description=" + description + ", inventoryType=" + inventoryType + ", quantityInStock=" + quantityInStock + '}';
    }
}
