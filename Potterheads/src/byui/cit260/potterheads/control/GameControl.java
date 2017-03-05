/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.view.GameMenuView;
import potterheads.Potterheads;

/**
 *
 * @author alex
 */
public class GameControl {

    public static void createNewGame(Player player) {
        System.out.println("");

    }

    public static Player createPlayer(String name) {
        if (name == null) {
            return null;
        }
        Player player = new Player();
        player.setName(name);
        Potterheads.setPlayer(player);
        return player;
    }
}
