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
public class PuzzleScene implements Serializable {
    private int numberOfObstacles;
    
    // constructor function
    public PuzzleScene() {
    }
    
    
    // getter and setter
    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public void setNumberOfObstacles(int numberOfObstacles) {
        this.numberOfObstacles = numberOfObstacles;
    }
    
    
    // equals and hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.numberOfObstacles;
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
        final PuzzleScene other = (PuzzleScene) obj;
        if (this.numberOfObstacles != other.numberOfObstacles) {
            return false;
        }
        return true;
    }
    
    
    // toString
    @Override
    public String toString() {
        return "PuzzleScene{" + "numberOfObstacles=" + numberOfObstacles + '}';
    }
}
