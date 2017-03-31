/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.InventoryItem;
import byui.cit260.potterheads.model.Location;
import byui.cit260.potterheads.model.Map;
import byui.cit260.potterheads.model.Spell;
import java.util.ArrayList;
import java.util.Scanner;
import potterheads.Potterheads;
import byui.cit260.potterheads.control.GameControl;
import byui.cit260.potterheads.exceptions.GameControlException;
import byui.cit260.potterheads.model.Player;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author aleecrook
 */
public class GameMenuView extends View {
    protected final PrintWriter console = Potterheads.getOutFile();
    

    public GameMenuView() {
        super("\n"
                + "----------------------------------\n"
                + "|            Game Menu           |\n"
                + "----------------------------------\n"
                + "I - View Inventory\n"
                + "V - View Spells\n"
                + "M - View Map\n"
                + "R - Print Spells report\n"
//                + "S - Save game\n"
                + "Q - Quit");
    }

    @Override
    public boolean doAction(String choice) {
        choice = choice.toUpperCase();

        switch (choice) {
            case "Q":
                return true;
//                break;
            case "I":
                this.viewInventory();
                break;
            case "V":
                this.viewSpells();
                break;
            case "M":
                this.displayMap();
                break;
            case "G":
                this.displayGetSpellView();
                break;
            case "P":
                this.print();
                break;
            case "L":
                this.location();
                break;
            case "R":
                SpellReportView spellReport = new SpellReportView();
                spellReport.display();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid selection. Choose one of the items from the list.");
                break;
        }
        return false;
    }

    private void viewInventory() {
        StringBuilder line;

        Game game = Potterheads.getCurrentGame();
//        InventoryItem[] inventory = game.getInventory();

        ArrayList<InventoryItem> inventory = game.getTradeableInventory();

        this.console.println("\n          List of Inventory Items");
        line = new StringBuilder("                                                              ");
        line.insert(0, "NAME");
        line.insert(25, "DESCRIPTION");
        line.insert(50, "QUANTITY");
        this.console.println(line.toString());

        //for each inventory item
        for (InventoryItem tradeableInventory : inventory) {
            line = new StringBuilder("                                                  ");
            line.insert(0, tradeableInventory.getName());
            line.insert(25, tradeableInventory.getDescription());
            line.insert(50, tradeableInventory.getQuantityInStock());

            //Display the line
            this.console.println(line.toString());
        }

        GameControl gameControl = new GameControl();
        this.console.println("You have " + gameControl.getInventoryCount() + "/" + inventory.size() + " items.");
    }

    private void viewSpells() {
        StringBuilder line;

        Game game = Potterheads.getCurrentGame();
//        InventoryItem[] inventory = game.getInventory();

        ArrayList<Spell> inventory = game.getSpellInventory();

        this.console.println("\n          List of Spells Learned");
        line = new StringBuilder("                                                              ");
        line.insert(0, "NAME");
        line.insert(25, "EFFECT");
        this.console.println(line.toString());

        //for each inventory item
        for (Spell spellInventory : inventory) {
            line = new StringBuilder("                                                  ");
            line.insert(0, spellInventory.getName());
            line.insert(25, spellInventory.getEffect());

            //Display the line
            this.console.println(line.toString());
        }
    }

    private void displayMap() {
//        MapView mapView = new MapView();
//        mapView.display();
//        
//        boolean validAction = false;
//        while (!validAction) {
//            validAction = mapView.doAction(mapView.getInput());
//        }
        StringBuilder line;
        
        Map map = Potterheads.getCurrentGame().getMap();
        Location[][] locations = map.getLocations();
        
        line = new StringBuilder();
        StringBuilder hyphens = new StringBuilder();
        line.append("  ");
        hyphens.append("  ");

        for (int i = 1; i <= locations.length; i++) {
            line.append(i);
            line.append("    ");
            hyphens.append("-----");
        }

        this.console.println(line.toString());
        this.console.println(hyphens.toString());

        for (int rowIndex = 0; rowIndex < locations.length; rowIndex++) {
            line = new StringBuilder("");
            line.append(rowIndex + 1);

            Location[] row = locations[rowIndex];

            for (Location column : row) {
                line.append("| ");
                line.append(column.getScene().getMapSymbol());
                line.append(" ");
            }
            line.append("|");
            this.console.println(line.toString());
            this.console.println(hyphens.toString());
        }
        
        this.location();
    }

    private void displayGetSpellView() {
        GetSpellView getSpellView = new GetSpellView();
        getSpellView.display();
    }

    private void location() {
        Scanner keyboard = new Scanner(System.in);
        
        this.console.println("\nChoose where you would like to go on the map:\n"
                + " 1. Hogwarts Great Hall      2. \n"                              //0,0   0,1
                + " 3. Knockturn Alley          4. \n"                              //0,2   0,3
                + " 5.                          6. Quidditch Pitch\n"               //0,4   1,0
                + " 7. The Leaky Cauldron       8. \n"                              //1,1   1,2
                + " 9. Dumbledore's Office     10. \n"                              //1,3   1,4
                + "11. Flourish and Blott's    12. Polyjuice Potion Lab\n"          //2,0   2,1
                + "13.                         14. Gringotts Bank\n"                //2,2   2,3
                + "15.                         16. Defense agst Dark Arts Room\n"   //2,4   3,0
                + "17.                         18. \n"                              //3,1   3,2
                + "19. Diagon Alley            20. \n"                              //3,3   3,4
                + "21. Ollivander's            22. \n"                              //4,0   4,1
                + "23. Hagrid's House          24. \n"                              //4,2   4,3
                + "25.\n\n"                                                         //4,4
                + "Q - quit");
       
        String selection = keyboard.nextLine();
        selection = selection.toUpperCase();
        
        switch (selection) {
            case "1": //startingLocation Hogwarts Great Hall
                // update location
                Potterheads.getPlayer().movePlayer(new Point(0,0));
                // print out new location
                this.printSceneDesc();
                break;
            case "2":
                Potterheads.getPlayer().movePlayer(new Point(0,1));
                this.printSceneDesc();
                
                break;
            case "3": //knockturnAlley
                Potterheads.getPlayer().movePlayer(new Point(0,2));
                this.printSceneDesc();
                
                break;
            case "4":
                Potterheads.getPlayer().movePlayer(new Point(0,3));
                this.printSceneDesc();
                
                break;
            case "5":
                Potterheads.getPlayer().movePlayer(new Point(0,4));
                this.printSceneDesc();
                
                break;
            case "6": //quidditchPitch
                Potterheads.getPlayer().movePlayer(new Point(1,0));
                this.printSceneDesc();

                QuidditchView quidditchView = new QuidditchView();
                quidditchView.display();
                break;
            case "7": //leakyCauldron
                Potterheads.getPlayer().movePlayer(new Point(1,1));
                this.printSceneDesc();
                
                break;
            case "8":
                Potterheads.getPlayer().movePlayer(new Point(1,2));
                this.printSceneDesc();
                
                break;
            case "9": //dumbledoresOffice
                Potterheads.getPlayer().movePlayer(new Point(1,3));
                this.printSceneDesc();
                
                break;
            case "10": 
                Potterheads.getPlayer().movePlayer(new Point(1,4));
                this.printSceneDesc();
                
                break;
            case "11": //flourishAndBlotts
                Potterheads.getPlayer().movePlayer(new Point(2,0));
                this.printSceneDesc();
                
                break;
            case "12":
                Potterheads.getPlayer().movePlayer(new Point(2,1));
                this.printSceneDesc();
                
                PolyjuiceView polyjuiceView = new PolyjuiceView();
                polyjuiceView.display();
                break;
            case "13":
                Potterheads.getPlayer().movePlayer(new Point(2,2));
                this.printSceneDesc();
                
                break;
            case "14": //gringottsBank
                Potterheads.getPlayer().movePlayer(new Point(2,3));
                this.printSceneDesc();
                
                GringottsView gringottsView = new GringottsView();
                gringottsView.display();
                break;
            case "15":
                Potterheads.getPlayer().movePlayer(new Point(2,4));
                this.printSceneDesc();
                
                break;
            case "16": //darkArtsClassroom
                Potterheads.getPlayer().movePlayer(new Point(3,0));
                this.printSceneDesc();
                
                break;
            case "17":
                Potterheads.getPlayer().movePlayer(new Point(3,1));
                this.printSceneDesc();
                
                break;
            case "18": 
                Potterheads.getPlayer().movePlayer(new Point(3,2));
                this.printSceneDesc();
                
                break;
            case "19": //diagonAlley
                Potterheads.getPlayer().movePlayer(new Point(3,3));
                this.printSceneDesc();
                
                DiagonAlleyView diagonAlleyView = new DiagonAlleyView();
                diagonAlleyView.display();
                break;
            case "20":
                Potterheads.getPlayer().movePlayer(new Point(3,4));
                this.printSceneDesc();
                
                break;
            case "21": //Ollivanders
                Potterheads.getPlayer().movePlayer(new Point(4,0));
                this.printSceneDesc();
                
                break;
            case "22":
                Potterheads.getPlayer().movePlayer(new Point(4,1));
                this.printSceneDesc();
                
                break;
            case "23": //Hagrid's House
                Potterheads.getPlayer().movePlayer(new Point(4,2));
                this.printSceneDesc();
                
                GetSpellView getSpellView = new GetSpellView();
                getSpellView.display();
                break;
            case "24":
                Potterheads.getPlayer().movePlayer(new Point(4,3));
                this.printSceneDesc();
                
                break;
            case "25": //Finish
                Potterheads.getPlayer().movePlayer(new Point(4,4));
                this.printSceneDesc();
                
                break;
            
            case "Q":
                return;
            default:
                ErrorView.display(this.getClass().getName(), "Invalid selection. Choose an item from the map");
                break;
        };
    }
    
    private void printSceneDesc() {
        Point loc = Potterheads.getPlayer().getCoordinates();
        Location[][] map = Potterheads.getCurrentGame().getMap().getLocations();
        Location location = map[loc.x][loc.y];
        
        this.console.println(location.getScene().getDescription());
    }

    private void print() {
        this.console.print("\nEnter the file path for the file where the game will be saved: ");
        
        String filePath = this.getInput();
        
        try {
            GameControl.print(Potterheads.getPlayer().getInventoryItems(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }
   

    }


