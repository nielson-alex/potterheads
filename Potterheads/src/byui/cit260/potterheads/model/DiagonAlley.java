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
    private double usd;
    private double usdToGalleon;
    private double galleonToSickle;
    private double sickleToKnut;
    
    // constructor funciton
    public DiagonAlley() {
    }
    
    
    // getter and setters

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getUsdToGalleon() {
        return usdToGalleon;
    }

    public void setUsdToGalleon(double usdToGalleon) {
        this.usdToGalleon = usdToGalleon;
    }

    public double getGalleonToSickle() {
        return galleonToSickle;
    }

    public void setGalleonToSickle(double galleonToSickle) {
        this.galleonToSickle = galleonToSickle;
    }

    public double getSickleToKnut() {
        return sickleToKnut;
    }

    public void setSickleToKnut(double sickleToKnut) {
        this.sickleToKnut = sickleToKnut;
    }
    
    
    //equals and hashcode()
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.usd) ^ (Double.doubleToLongBits(this.usd) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.usdToGalleon) ^ (Double.doubleToLongBits(this.usdToGalleon) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.galleonToSickle) ^ (Double.doubleToLongBits(this.galleonToSickle) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.sickleToKnut) ^ (Double.doubleToLongBits(this.sickleToKnut) >>> 32));
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
        if (Double.doubleToLongBits(this.usd) != Double.doubleToLongBits(other.usd)) {
            return false;
        }
        if (Double.doubleToLongBits(this.usdToGalleon) != Double.doubleToLongBits(other.usdToGalleon)) {
            return false;
        }
        if (Double.doubleToLongBits(this.galleonToSickle) != Double.doubleToLongBits(other.galleonToSickle)) {
            return false;
        }
        if (Double.doubleToLongBits(this.sickleToKnut) != Double.doubleToLongBits(other.sickleToKnut)) {
            return false;
        }
        return true;
    }
    
    
    // toString()
    @Override
    public String toString() {
        return "DiagonAlley{" + "usd=" + usd + ", usdToGalleon=" + usdToGalleon + ", galleonToSickle=" + galleonToSickle + ", sickleToKnut=" + sickleToKnut + '}';
    }
}
