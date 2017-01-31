
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aleecrook
 */
public class ItemScene implements Serializable{
    private int numberOfItems; 

    public ItemScene() {
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.numberOfItems;
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
        if (this.numberOfItems != other.numberOfItems) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemScene{" + "numberOfItems=" + numberOfItems + '}';
    }
}
