/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

/**
 *
 * @author Alex
 */
public class AmericanMoney {
    public int dollars;
    public int cents;

    
    
    //constructor function
    public AmericanMoney(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    
    
    //getters and setters
    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

    
    
    //hashcode and equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.dollars;
        hash = 53 * hash + this.cents;
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
        final AmericanMoney other = (AmericanMoney) obj;
        if (this.dollars != other.dollars) {
            return false;
        }
        if (this.cents != other.cents) {
            return false;
        }
        return true;
    }

    
    
    //toString
    @Override
    public String toString() {
        return "AmericanMoney{" + "dollars=" + dollars + ", cents=" + cents + '}';
    }
}
