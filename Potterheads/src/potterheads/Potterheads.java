/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potterheads;

import byui.cit260.potterheads.model.DiagonAlley;
import byui.cit260.potterheads.model.Item;
import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.model.PuzzleScene;
import byui.cit260.potterheads.model.Character;

/**
 *
 * @author Alex test
 */


/* Alex: diagonalley, item, puzzle scene and character
Glaser: game, polyjuice, quidditch, and map
Reese: itemScene, location, scene, characterScene
*/
public class Potterheads {

    /**
     * @param args the command line arguments
     * second test
     */
    public static void main(String[] args) {
        // player class
        Player playerOne = new Player();
        
        playerOne.setName("Hermione Granger");
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        
        // item class
        Item wand = new Item();
        
        wand.setDescription("This is your wand, it has a dragon heartstring inside.");
        wand.setInventoryType("Magic");
        wand.setQuantity(1);
        
        String wandInfo = wand.toString();
        System.out.println(wandInfo);
        
        
        // diagon alley class
        DiagonAlley diagonAlley = new DiagonAlley();
        
        diagonAlley.setUsd(100);
        diagonAlley.setUsdToGalleon(50);
        diagonAlley.setGalleonToSickle(50);
        diagonAlley.setSickleToKnut(50);
        
        String diagonAlleyInfo = diagonAlley.toString();
        System.out.println(diagonAlleyInfo);
        
        
        // puzzle scene class
        PuzzleScene chamberOfSecrets = new PuzzleScene();
        
        chamberOfSecrets.setNumberOfObstancles(1);
        
        String chamberOfSecretsInfo = chamberOfSecrets.toString();
        System.out.println(chamberOfSecretsInfo);
        
        
        // character class
        Character dumbledore = new Character();
        
        dumbledore.setName("Albus Dumbledore");
        dumbledore.setDescription("Wise old man wizard who runs the school.");
        dumbledore.setNumberOfItems(2);
        dumbledore.setCoordinates("HDM");
        
        String dumbledoreInfo = dumbledore.toString();
        System.out.println(dumbledoreInfo);
    }
    
}
