/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.model;

import java.io.Serializable;

/**
 *
 * @author Alexandra
 */
public class Polyjuice implements Serializable {

    //class instance variables
    private double weight;
    private double timeTransformed;
    private double ounces;

    public Polyjuice() {
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTimeTransformed() {
        return timeTransformed;
    }

    public void setTimeTransformed(double timeTransformed) {
        this.timeTransformed = timeTransformed;
    }

    public double getOunces() {
        return ounces;
    }

    public void setOunces(double ounces) {
        this.ounces = ounces;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.weight) ^ (Double.doubleToLongBits(this.weight) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.timeTransformed) ^ (Double.doubleToLongBits(this.timeTransformed) >>> 32));
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.ounces) ^ (Double.doubleToLongBits(this.ounces) >>> 32));
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
        final Polyjuice other = (Polyjuice) obj;
        if (Double.doubleToLongBits(this.weight) != Double.doubleToLongBits(other.weight)) {
            return false;
        }
        if (Double.doubleToLongBits(this.timeTransformed) != Double.doubleToLongBits(other.timeTransformed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ounces) != Double.doubleToLongBits(other.ounces)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Polyjuice{" + "weight=" + weight + ", timeTransformed=" + timeTransformed + ", ounces=" + ounces + '}';
    }

}
