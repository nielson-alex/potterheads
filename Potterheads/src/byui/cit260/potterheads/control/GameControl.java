/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.control;

import byui.cit260.potterheads.exceptions.GameControlException;
import byui.cit260.potterheads.exceptions.MapControlException;
import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
import byui.cit260.potterheads.model.InventoryItem.InventoryItemType;
import byui.cit260.potterheads.model.Item;
import byui.cit260.potterheads.model.Location;
import byui.cit260.potterheads.model.Map;
import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.model.Scene;
import byui.cit260.potterheads.model.Scene.SceneType;
import byui.cit260.potterheads.model.Spell;
import byui.cit260.potterheads.view.GameMenuView;
import byui.cit260.potterheads.view.HagridsHouseView;
import java.util.ArrayList;
import potterheads.Potterheads;
import byui.cit260.potterheads.model.TradeableItem;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.System.console;

public class GameControl {

    public static void createNewGame(Player player) {
        Game game = new Game();
        Potterheads.setCurrentGame(game);

        game.setPlayer(player);

        //create the inventory list and save inthe game
        ArrayList<InventoryItem> tradeableInventoryList = GameControl.createTradeableInventoryList();
        game.setTradeableInventory(tradeableInventoryList);
        
        ArrayList<InventoryItem> inventoryItems = Potterheads.getPlayer().getInventoryItems();

        ArrayList<Spell> spellInventoryList = GameControl.createSpellList();
        game.setSpellInventory(spellInventoryList);

        Map map = new Map(5, 5);
        game.setMap(map);
        GameControl.createMap();
        
        // move actors to starting position in the map
        try {
            MapControl.moveCharactersToStartingLocation(map);
        } catch (MapControlException me) {
            System.out.println(me.getMessage());
        }
    }
    
    public static void saveGame(Game game, String filepath) 
            throws GameControlException {
        try (FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(game);
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }
    
    public static void print(ArrayList<InventoryItem> inventoryItems, String filepath) 
            throws GameControlException {
        try (FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            
            output.writeObject(inventoryItems);
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
        }
    }
    
    public static void getSavedGame(String filepath) 
            throws GameControlException {
        Game game = null;
        
        try (FileInputStream fips = new FileInputStream(filepath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            game = (Game) input.readObject();
        } catch (Exception e) {
            throw new GameControlException(e.getMessage());
            }
        
        Potterheads.setCurrentGame(game);
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

    public static ArrayList<InventoryItem> createTradeableInventoryList() {      
        ArrayList<InventoryItem> tradeableInventory = potterheads.Potterheads.getPlayer().getInventoryItems();

//            ----------ITEMS-----------
//        InventoryItem snitch = new InventoryItem(InventoryItemType.snitch);
//        tradeableInventory.add(snitch);
//
//        InventoryItem timeTurner = new InventoryItem(InventoryItemType.timeTurner);
//        tradeableInventory.add(timeTurner);
//
//        InventoryItem maraudersMap = new InventoryItem(InventoryItemType.maraudersMap);
//        tradeableInventory.add(maraudersMap);
//
//        InventoryItem invisibilityCloak = new InventoryItem(InventoryItemType.invisibilityCloak);
//        tradeableInventory.add(invisibilityCloak);
//
//        InventoryItem americanMoney = new InventoryItem(InventoryItemType.americanMoney);
//        tradeableInventory.add(americanMoney);
//
//        InventoryItem gillyweed = new InventoryItem(InventoryItemType.gillyweed);
//        tradeableInventory.add(gillyweed);
//
//        InventoryItem firecrackers = new InventoryItem(InventoryItemType.firecrackers);
//        tradeableInventory.add(firecrackers);
//
//        InventoryItem replacementWand = new InventoryItem(InventoryItemType.replacementWand);
//        tradeableInventory.add(replacementWand);

        return tradeableInventory;
    }

    public static ArrayList<Spell> createSpellList() {
        ArrayList<Spell> spellInventory = potterheads.Potterheads.getPlayer().getSpells();

//        How to add new spells to the ArrayList
//        Spell expelliarmus = new Spell(SpellType.expelliarmus);
//        spellInventory.add(expelliarmus);

        return spellInventory;
    }

    private static Map createMap() {
        //create the map
        Map map = Potterheads.getCurrentGame().getMap();

        //create the scenes for the game
        Scene[] scenes = createScenes();

        //assign scenes to locations
        GameControl.assignScenesToLocations(map, scenes);

        return map;
    }

    private static Scene[] createScenes() {
        Scene[] scenes = new Scene[SceneType.values().length];

        // #1
        Scene startingScene = new Scene();
        startingScene.setDescription(
                "Welcome to the game! You find yourself...(rest of text goes here)");
        startingScene.setMapSymbol("GH");
        startingScene.setBlocked(false);
        scenes[SceneType.start.ordinal()] = startingScene;

        
        Scene puzzleScene = new Scene();
        puzzleScene.setDescription("bad things happen here");
        puzzleScene.setMapSymbol("PZ");
        puzzleScene.setBlocked(false);
        scenes[SceneType.puzzle.ordinal()] = puzzleScene;

    
        Scene characterScene = new Scene();
        characterScene.setDescription("***These scenes have characters***");
        characterScene.setMapSymbol("CH");
        characterScene.setBlocked(false);
        scenes[SceneType.character.ordinal()] = characterScene;

  
        Scene itemScene = new Scene();
        itemScene.setDescription("***These scenes have items***");
        itemScene.setMapSymbol("IT");
        itemScene.setBlocked(false);
        scenes[SceneType.item.ordinal()] = itemScene;


        Scene unknownScene = new Scene();
        unknownScene.setDescription("You don't have enough wizarding cred to go here yet.");
        unknownScene.setMapSymbol("??");
        unknownScene.setBlocked(false);
        scenes[SceneType.unknown.ordinal()] = unknownScene;
        
        // #2
        
        
        
        // #3
        Scene knockTurnAlley = new Scene();
        knockTurnAlley.setDescription(
                "Congratulations, you beat the game.");
        knockTurnAlley.setMapSymbol("KA");
        knockTurnAlley.setBlocked(false);
        scenes[SceneType.knockTurnAlley.ordinal()] = knockTurnAlley;
        
        // #4
        
        // #5
        Scene libraryScene = new Scene();
        unknownScene.setDescription("You enter the library and see dozens of students\n"
                + "studying for exams and practicing spells.");
        unknownScene.setMapSymbol("LI");
        unknownScene.setBlocked(false);
        scenes[SceneType.unknown.ordinal()] = unknownScene;
        
        // #6
        Scene quidditchPitch = new Scene();
        quidditchPitch.setDescription(
                "\n'Hey,'" + Potterheads.getPlayer().getName() + "!' You hear a voice\n"
                + "call your name from across the quidditch pitch. You look up to see\n"
                + "Cedric Diggery greeting you."
                + "'So you want to try your hand at Quidditch? Well, I'm afraid that\n"
                + "all of the positions on the team are already filled. I'll tell you\n"
                + "what though, if you can can fly one of the brooms and catch the\n"
                + "snitch in a certain amount of time, I'll let you keep it. How does\n"
                + "that sound?' He asks.\n"
                + "He gestures across the Hogwards quidditch field to the opposite wall, where\n"
                + "you see a long rack containing dozens of different types of brooms.\n"
                + "'You can choose to ride a Nimbus 2000 or a Firebolt. Or if you're feeling\n"
                + "really confident, see you if you can catch the snith on a kitchen broom.'\n\n");
        quidditchPitch.setMapSymbol("QP");
        quidditchPitch.setBlocked(false);
        scenes[SceneType.quidditchPitch.ordinal()] = quidditchPitch;
        
        // #7
        Scene leakyCauldron = new Scene();
        leakyCauldron.setDescription(
                "\nYou see all sorts of sketchy figures here. .");
        leakyCauldron.setMapSymbol("LC");
        knockTurnAlley.setBlocked(false);
        scenes[SceneType.leakyCauldron.ordinal()] = leakyCauldron;
        
        // #8
        
        // #9
        Scene dumbledoresOffice = new Scene();
        dumbledoresOffice.setDescription(
                "\nYou enter Dumbledore's office. Books of magical spells line the\n"
                        + "shelves on all the walls of his room. His pet phoenix sits\n"
                        + "sleeping in its cage, and you spot the headmaster himself\n"
                        + "busy at work behind his enormous ornate desk.");
        dumbledoresOffice.setMapSymbol("DO");
        dumbledoresOffice.setBlocked(false);
        scenes[SceneType.dumbledoresOffice.ordinal()] = dumbledoresOffice;
        
        // #10
        
        // #11
        Scene flourishAndBlotts = new Scene();
        flourishAndBlotts.setDescription(
                "Congratulations, you beat the game.");
        flourishAndBlotts.setMapSymbol("FB");
        flourishAndBlotts.setBlocked(false);
        scenes[SceneType.flourishAndBlotts.ordinal()] = flourishAndBlotts;
        
        // #12
        Scene polyjuice = new Scene();
        polyjuice.setDescription(
                "\nYou're in the potions laboratory where you have access to all of\n"
                + "the potions. Would like to brew the polyjuice potion now?\n"
                + "asks you if you would like to make any currency exchanges.\n\n");
        polyjuice.setMapSymbol("PJ");
        polyjuice.setBlocked(false);
        scenes[SceneType.polyjuice.ordinal()] = polyjuice;
        
        // #13
        
        // #14
        Player player = Potterheads.getPlayer();
        double money = player.getMoney();
        
        Scene gringottsBank = new Scene();
        gringottsBank.setDescription(
                "You enter Gringotts Bank, where an old troll behind the counter\n" +
                "asks you if you would like to make any currency exchanges. You have\n"
                        + money + " dollars to exchange.");
        gringottsBank.setMapSymbol("GG");
        gringottsBank.setBlocked(false);
        scenes[SceneType.gringottsBank.ordinal()] = gringottsBank;
        
        // #15
        
        // #16
        Scene darkArtsClassroom = new Scene();
        darkArtsClassroom.setDescription(
                "\n \n");
        darkArtsClassroom.setMapSymbol("DO");
        darkArtsClassroom.setBlocked(false);
        scenes[SceneType.darkArtsClassroom.ordinal()] = darkArtsClassroom;
        
        // #17
        
        // #18
        Scene darkDungeon = new Scene();
        darkDungeon.setDescription("\nEverything is pitch black. You don't have a\n"
                + "lantern or any matches. If only there was some way to light the\n"
                + "room up...");
        darkDungeon.setMapSymbol("DD");
        darkDungeon.setBlocked(false);
        scenes[SceneType.darkDungeon.ordinal()] = darkDungeon;
        
        // #19
        Scene diagonAlley = new Scene();
        diagonAlley.setDescription(
                "\n \n");
        diagonAlley.setMapSymbol("DA");
        diagonAlley.setBlocked(false);
        scenes[SceneType.diagonAlley.ordinal()] = diagonAlley;
        
        // #20
        
        // #21
        Scene ollivanders = new Scene();
        ollivanders.setDescription(
                "\n \n");
        ollivanders.setMapSymbol("OL");
        ollivanders.setBlocked(false);
        scenes[SceneType.ollivanders.ordinal()] = ollivanders;
        
        // #22
        
        // #23
        Scene hagridsHouse = new Scene();
        hagridsHouse.setDescription(
                "\nHagid greets you at the door to his shack.\n"
                + "''ey there!' he greets you. 'You mus' be that new American\n"
                + "student e'rywone keeps goin' on about! M'names Hagrid, it's\n"
                + "a pleasure to meet a non-Muggle from the western hemisphere, we\n"
                + "sure don' get many of ya 'round here.' He leads you into his living\n\n"
                + "'Oh!' he says, as if he just remembered something. 'I got somethin'\n"
                + "for ya. I live my life at Hogwarts, so I don' got much need for\n"
                + "this. Consider it a house welcome gift from Hogwarts.\n");
        hagridsHouse.setMapSymbol("HH");
        hagridsHouse.setBlocked(false);
        scenes[SceneType.hagridsHouse.ordinal()] = hagridsHouse;

        // #24
        
        // #25
        Scene finishScene = new Scene();
        finishScene.setDescription(
                "Congratulations, you beat the game.");
        finishScene.setMapSymbol("FN");
        finishScene.setBlocked(false);
        scenes[SceneType.finish.ordinal()] = finishScene;
        
        return scenes;
    }

    private static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();
        
        //start point
        locations[0][0].setScene(scenes[SceneType.start.ordinal()]);            // #01 Hogwarts castle great hall
        locations[0][1].setScene(scenes[SceneType.character.ordinal()]);        // #02 
        locations[0][2].setScene(scenes[SceneType.knockTurnAlley.ordinal()]);   // #03 Knockturn Alley
        locations[0][3].setScene(scenes[SceneType.item.ordinal()]);             // #04
        locations[0][4].setScene(scenes[SceneType.unknown.ordinal()]);          // #05
        locations[1][0].setScene(scenes[SceneType.quidditchPitch.ordinal()]);   // #06 quidditchPitch
        locations[1][1].setScene(scenes[SceneType.leakyCauldron.ordinal()]);    // #07 leakyCauldron
        locations[1][2].setScene(scenes[SceneType.unknown.ordinal()]);          // #08
        locations[1][3].setScene(scenes[SceneType.dumbledoresOffice.ordinal()]);// #09 dumbledoresOffice
        locations[1][4].setScene(scenes[SceneType.unknown.ordinal()]);          // #10
        locations[2][0].setScene(scenes[SceneType.flourishAndBlotts.ordinal()]);// #11 flourishAndBotts
        locations[2][1].setScene(scenes[SceneType.polyjuice.ordinal()]);        // #12 Polyjuice Potion lab
        locations[2][2].setScene(scenes[SceneType.unknown.ordinal()]);          // #13
        locations[2][3].setScene(scenes[SceneType.gringottsBank.ordinal()]);    // #14 gringottsBank
        locations[2][4].setScene(scenes[SceneType.unknown.ordinal()]);          // #15
        locations[3][0].setScene(scenes[SceneType.darkArtsClassroom.ordinal()]);// #16 darkArtsClassroom
        locations[3][1].setScene(scenes[SceneType.unknown.ordinal()]);          // #17
        locations[3][2].setScene(scenes[SceneType.unknown.ordinal()]);          // #18
        locations[3][3].setScene(scenes[SceneType.diagonAlley.ordinal()]);      // #19 Diagon Alley
        locations[3][4].setScene(scenes[SceneType.unknown.ordinal()]);          // #20 
        locations[4][0].setScene(scenes[SceneType.ollivanders.ordinal()]);      // #21 ollivanders
        locations[4][1].setScene(scenes[SceneType.unknown.ordinal()]);          // #22
        locations[4][2].setScene(scenes[SceneType.hagridsHouse.ordinal()]);     // #23 Hagrid's House
        locations[4][3].setScene(scenes[SceneType.unknown.ordinal()]);          // #24
        locations[4][4].setScene(scenes[SceneType.finish.ordinal()]);           // #25 Finish
    }

    public int getInventoryCount() {
        Game game = new Game();
        ArrayList<InventoryItem> inventory = game.getTradeableInventory();
        int counter = 0;
        for (InventoryItem i : inventory) {
            if (i != null) {
                counter++;
            }
        }
        return counter;
    }
}
