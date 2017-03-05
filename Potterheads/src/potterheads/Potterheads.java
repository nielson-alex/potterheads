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
import byui.cit260.potterheads.view.StartProgramView;
/**
 *
 * @author Alex test
 */


/* Alex: diagonalley, item, puzzle scene and character
Glaser: game, polyjuice, quidditch, and map
Reese: itemScene, location, scene, characterScene
*/
public class Potterheads {

    private static Game currentGame = null;
    private static Player player = null;
    /**
     * @param args the command line arguments
     * second test
     */
    public static void main(String[] args) {
        
        //create StartProgramViewORg and display the start program view
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();
        
        
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Potterheads.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Potterheads.player = player;
    }

    
}