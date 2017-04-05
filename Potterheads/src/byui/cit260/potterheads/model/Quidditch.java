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

    private double nimbusSpeed;
    private double fireboltSpeed;
    private double kitchenBroomSpeed;
    private double timeOnBroom;
    private double snitchSpeed;

    // constructor function
    public Quidditch() {
    }

    // getters and setters
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

    public double getKitchenBroomSpeed() {
        return kitchenBroomSpeed;
    }

    public void setKitchenBroomSpeed(double kitchenBroomSpeed) {
        this.kitchenBroomSpeed = kitchenBroomSpeed;
    }

    public double getTimeOnBroom() {
        return timeOnBroom;
    }

    public void setTimeOnBroom(double timeOnBroom) {
        this.timeOnBroom = timeOnBroom;
    }

    public double getSnitchSpeed() {
        return snitchSpeed;
    }

    public void setSnitchSpeed(double snitchSpeed) {
        this.snitchSpeed = snitchSpeed;
    }

    // equals and hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.nimbusSpeed) ^ (Double.doubleToLongBits(this.nimbusSpeed) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.fireboltSpeed) ^ (Double.doubleToLongBits(this.fireboltSpeed) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.kitchenBroomSpeed) ^ (Double.doubleToLongBits(this.kitchenBroomSpeed) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.timeOnBroom) ^ (Double.doubleToLongBits(this.timeOnBroom) >>> 32));
        hash = 11 * hash + (int) (Double.doubleToLongBits(this.snitchSpeed) ^ (Double.doubleToLongBits(this.snitchSpeed) >>> 32));
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
        return true;
    }

    // toString
    @Override
    public String toString() {
        return "Quidditch{" + "nimbusSpeed=" + nimbusSpeed + ", fireboltSpeed=" + fireboltSpeed + ", kitchenBroomSpeed=" + kitchenBroomSpeed + ", timeOnBroom=" + timeOnBroom + ", snitchSpeed=" + snitchSpeed + '}';
    }

}
