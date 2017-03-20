package byui.cit260.potterheads.model;

import java.io.Serializable;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aleecrook
 */
public class ItemScene implements Serializable {

    private Item[] items;

    //constructor function
    public ItemScene() {
    }

    //getter and setter
    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    //hashcode and equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Arrays.deepHashCode(this.items);
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
        final ItemScene other = (ItemScene) obj;
        if (!Arrays.deepEquals(this.items, other.items)) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        return "ItemScene{" + "items=" + items + '}';
    }
}
