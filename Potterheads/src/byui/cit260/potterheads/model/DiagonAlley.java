/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.io.Serializable;

/**
 *
 * @author alex
 */
public class DiagonAlley implements Serializable {

    private double galleons;
    private double dollars;
    private double cents;

    // constructor function
    public DiagonAlley() {
    }

    // getter and setters
    public double getGalleons() {
        return galleons;
    }

    public void setGalleons(double galleons) {
        this.galleons = galleons;
    }

    public double getDollars() {
        return dollars;
    }

    public void setDollars(double dollars) {
        this.dollars = dollars;
    }

    public double getCents() {
        return cents;
    }

    public void setCents(double cents) {
        this.cents = cents;
    }

    //equals and hashcode()
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.galleons) ^ (Double.doubleToLongBits(this.galleons) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.dollars) ^ (Double.doubleToLongBits(this.dollars) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.cents) ^ (Double.doubleToLongBits(this.cents) >>> 32));
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
        final DiagonAlley other = (DiagonAlley) obj;
        if (Double.doubleToLongBits(this.galleons) != Double.doubleToLongBits(other.galleons)) {
            return false;
        }
        if (Double.doubleToLongBits(this.dollars) != Double.doubleToLongBits(other.dollars)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cents) != Double.doubleToLongBits(other.cents)) {
            return false;
        }
        return true;
    }

    // toString()
    @Override
    public String toString() {
        return "DiagonAlley{" + "galleons=" + galleons + ", dollars=" + dollars + ", cents=" + cents + '}';
    }

}
