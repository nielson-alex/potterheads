/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potterheads;

import byui.cit260.potterheads.model.Player;

/**
 *
 * @author Alex test
 */
public class Potterheads {

    /**
     * @param args the command line arguments
     * second test
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Hermione Granger");
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
    
}
