package byui.cit260.potterheads.model;

public enum Item {
        timeTurner,
        snitch,
        maraudersMap,
        invisibilityCloak,
        americanMoney,
        gillyweed,
        firecrackers,
        replacementWand,
        expelliarmus,
        stupify,
        sectumsempra,
        petrificusTotalus,
        wingardiumLeviosa;
    }
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package byui.cit260.potterheads.model;
//
//import java.io.Serializable;
//import java.util.Objects;
//
///**
// *
// * @author alex
// */
//public class Item implements Serializable {
//    
//    
//            
//    private String name;
//    private String description;
//    private String inventoryType;
//
//    // constructor function
//    public Item() {
//    
//    }
//    
//    public String getName() {
//        return name;
//    }
//
//    // getter and setter
//    public void setName(String name) {    
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getInventoryType() {
//        return inventoryType;
//    }
//
//    public void setInventoryType(String inventoryType) {
//        this.inventoryType = inventoryType;
//    }
//    
//    
//    // equals and hashcode
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 71 * hash + Objects.hashCode(this.name);
//        hash = 71 * hash + Objects.hashCode(this.description);
//        hash = 71 * hash + Objects.hashCode(this.inventoryType);
//        return hash;
//    }
//
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Item other = (Item) obj;
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        if (!Objects.equals(this.description, other.description)) {
//            return false;
//        }
//        if (!Objects.equals(this.inventoryType, other.inventoryType)) {
//            return false;
//        }
//        return true;
//    }
//
//    // toString
//    @Override
//    public String toString() {
//        return "Item{" + "name=" + name + ", description=" + description + ", inventoryType=" + inventoryType + '}';
//    }
//
//
//}
