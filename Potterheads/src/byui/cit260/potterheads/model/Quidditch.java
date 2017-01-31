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
public class Quidditch implements Serializable {
    
    //class instance variables
    private double nimbusSpeed;
    private double fireboltSpeed;
    private double snitchSpeed;

    public Quidditch() {
    }
    

    public double getNimbusSpeed() {
        return nimbusSpeed;
    }

    public void setNimbusSpeed(double nimbusSpeed) {
        this.nimbusSpeed = nimbusSpeed;
    }
    public double getFireboltSpeed() {
        return fireboltSpeed;
    }

    public void setFireboltSpeed(double fireboltSpeed) {
        this.fireboltSpeed = fireboltSpeed;
    }

    public double getSnitchSpeed() {
        return snitchSpeed;
    }

    public void setSnitchSpeed(double snitchSpeed) {
        this.snitchSpeed = snitchSpeed;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.nimbusSpeed) ^ (Double.doubleToLongBits(this.nimbusSpeed) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.fireboltSpeed) ^ (Double.doubleToLongBits(this.fireboltSpeed) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.snitchSpeed) ^ (Double.doubleToLongBits(this.snitchSpeed) >>> 32));
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
        final Quidditch other = (Quidditch) obj;
        if (Double.doubleToLongBits(this.nimbusSpeed) != Double.doubleToLongBits(other.nimbusSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.fireboltSpeed) != Double.doubleToLongBits(other.fireboltSpeed)) {
            return false;
        }
        if (Double.doubleToLongBits(this.snitchSpeed) != Double.doubleToLongBits(other.snitchSpeed)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quidditch{" + "nimbusSpeed=" + nimbusSpeed + ", fireboltSpeed=" + fireboltSpeed + ", snitchSpeed=" + snitchSpeed + '}';
    }
    
}
