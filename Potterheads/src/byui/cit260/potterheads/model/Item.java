/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author alex
 */
public class Item implements Serializable {
    private String description;
    private String inventoryType;
    private int quantity;
    
    // constructor function
    public Item() {
    }
    
    
    // getter and setter
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    // equals and hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.inventoryType);
        hash = 29 * hash + this.quantity;
        return hash;
    }

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
        final Item other = (Item) obj;
        if (this.quantity != other.quantity) {
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
    
    
    
    // toString
    @Override
    public String toString() {
        return "Item{" + "description=" + description + ", inventoryType=" + inventoryType + ", quantity=" + quantity + '}';
    }
    
}
