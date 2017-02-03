/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package potterheads;

import byui.cit260.potterheads.model.Character;
import byui.cit260.potterheads.model.CharacterScene;
import byui.cit260.potterheads.model.DiagonAlley;
import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.Item;
import byui.cit260.potterheads.model.ItemScene;
import byui.cit260.potterheads.model.Location;
import byui.cit260.potterheads.model.Map;
import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.model.Polyjuice;
import byui.cit260.potterheads.model.PuzzleScene;
import byui.cit260.potterheads.model.Quidditch;
import byui.cit260.potterheads.model.Scene;
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
        
        chamberOfSecrets.setNumberOfObstacles(1);
        
        System.out.println(chamberOfSecrets.toString());
        
        
        // character class
        Character dumbledore = new Character();
        
        dumbledore.setName("Albus Dumbledore");
        dumbledore.setDescription("Wise old man wizard who runs the school.");
        dumbledore.setNumberOfItems(2);
        dumbledore.setCoordinates("HDM");
        
        String dumbledoreInfo = dumbledore.toString();
        System.out.println(dumbledoreInfo);
    
        
        // game class - Allie Glaser
        Game gameOne = new Game();
        
        gameOne.setNumberOfPlayers(3);
       
        System.out.println(gameOne.toString());
    

        // map class - Allie Glaser
        Map mapOne = new Map();
        
        mapOne.setRowCount(30);
        mapOne.setColumnCount(14);
       
        String mapInfo = mapOne.toString();
        System.out.println(mapInfo);
    

        // polyjuice class - Allie Glaser
        Polyjuice cauldronOne = new Polyjuice();
        
        cauldronOne.setWeight(3.2);
        cauldronOne.setTime(2.34);
        cauldronOne.setOunces(0.02);
        
        
        String polyjuiceInfo = cauldronOne.toString();
        System.out.println(polyjuiceInfo);


        //quidditch class - Allie Glaser
        Quidditch matchOne = new Quidditch();
        
        matchOne.setNimbusSpeed(15);
        matchOne.setFireboltSpeed(4);
        matchOne.setSnitchSpeed(7);
        
        
        String quidditchInfo = matchOne.toString();
        System.out.println(quidditchInfo);
        
        
        //location class-Alee Rees
        Location greatHall = new Location();
        
        greatHall.setRow(3);
        greatHall.setColumn(5);
        greatHall.setVisited(true);
        greatHall.setAmountRemaining(5);
        
        String locationInfo = greatHall.toString();
        System.out.println(locationInfo);
        
        
        //Scene Class-Alee Rees
        Scene sceneOne = new Scene();
        
        sceneOne.setDescription("Classroom");
        sceneOne.setDisplaySymbol("Use Spell");
        
        String sceneInfo = sceneOne.toString();
        System.out.println(sceneInfo);
        
        
        //CharacterScene Class-Alee Rees
        CharacterScene characterOne = new CharacterScene();
        
        characterOne.setNumberOfCharacters(3);
        
        String characterInfo = characterOne.toString();
        System.out.println(characterInfo);
        
        
        
        //ItemScene Class - Alee Rees
        ItemScene itemOne = new ItemScene();
        
        itemOne.setNumberOfItems(2);
        
        String itemInfo = itemOne.toString();
        System.out.println(itemInfo);
    }
}