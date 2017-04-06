/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Game;
import byui.cit260.potterheads.model.Player;
import byui.cit260.potterheads.model.Spell;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import potterheads.Potterheads;

/**
 *
 * @author aleecrook
 */
public class SpellReportView extends View {

    protected final PrintWriter console = Potterheads.getOutFile();

    public SpellReportView() {
        super("P - Print Menu\n"
                + "Q - Back to Main Menu");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase();
        boolean done = false;

        while (!done) {
            if ("P".equals(value.toUpperCase())) {
                this.printReport();
            } else if (!("P".equals(value.toUpperCase())) && !("Q".equals(value.toUpperCase()))) {
                ErrorView.display(this.getClass().getName(), "Press 'P' to continue or 'Q' to go back.");
            } else if ("Q".equals(value.toUpperCase())) {
                return true;
            }
            break;
        }
        return false;

    }

    public void printReport() {
        Scanner keyboard = new Scanner(System.in);

//============SAVE TO ANY DIRECTORY YOU WANT PLUS FILE NAME.TXT==================
//        this.console.println("\nEnter the name of the filepath you want to save the report to.\n"
//                + "Followed by the name you want to name the file with the extension '.txt.'\n"
//                + "(example: 'spells_list.txt')");
//        String filePath = keyboard.nextLine();
//
//        FileWriter out = null;
//        StringBuilder line;
//        Game game = Potterheads.getCurrentGame();
//        ArrayList<Spell> inventory = game.getSpellInventory();
//
//        this.console.println("\n          List of Spells Learned");
//        line = new StringBuilder("                                                              ");
//        line.insert(0, "NAME");
//        line.insert(25, "EFFECT");
//        this.console.println(line.toString());
//
//        //for each inventory item
//        for (Spell spellInventory : inventory) {
//            line = new StringBuilder("                                                  ");
//            line.insert(0, spellInventory.getName());
//            line.insert(25, spellInventory.getEffect());
//
//            //Display the line
//            this.console.println(line.toString());
//        }
//
//        try (FileOutputStream fops = new FileOutputStream(filePath)) {
//            ObjectOutputStream output = new ObjectOutputStream(fops);
//
//            output.writeObject(line);
//        } catch (Exception e) {
//            this.console.println(e.getMessage());
//        }
//
//        this.console.println("\nYou have successfully saved the file " + filePath);
// ============SAVE TO POTTERHEADS PROJECT FILE AND CHOOSE FILE NAME=============
        FileWriter out = null;
        StringBuilder line;
        this.console.println("Enter the name of the file you want to save your report to.");

        String fileName = (keyboard.nextLine() + ".txt");
        String fileLocation = ("C:\\Users\\Alex\\Documents\\W2017_CIT 260\\Printed Reports\\" + fileName);

        Player player = potterheads.Potterheads.getPlayer();
        Game game = Potterheads.getCurrentGame();
        ArrayList<Spell> inventory = game.getSpellInventory();
        ArrayList<String> printable = new ArrayList<>();

        this.console.println("\n          List of Spells Learned");
        line = new StringBuilder("                                                              ");
        line.insert(0, "NAME");
        line.insert(25, "EFFECT");
        this.console.println(line.toString());

        //for each inventory item
        for (Spell spellInventory : inventory) {
            try {
                out = new FileWriter(fileLocation);

                out.write("Last spell learned: ");

                out.write(spellInventory.getName());

            } catch (Exception e) {
                this.console.println(e.getMessage());
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (Exception e) {
                    this.console.println(e.getMessage());
                }

            }
//            this.console.println(spellInventory.getName() + spellInventory.getEffect());
//            lined
////            new StringBuilder("                                                  ");
//            line.
//            line.insert(25, spellInventory.getEffect());
//
//            //Display the line
//            this.console.println(line.toString());
        }

        this.console.println("\nYou have successfully saved the file " + fileLocation);

//        =============IGNORE================
//        this.console.println("Enter the name of the file you want to save your report to.");
//
//        Scanner input = new Scanner(System.in);
//
//        String fileName = input.nextLine();
//
//        FileWriter outFile = null;
//
//        String fileLocation = fileName;
//
//        try {
//            outFile = new FileWriter(fileLocation);
//
//            StringBuilder line;
//
//            line = new StringBuilder("                                                              ");
//            line.insert(0, "NAME");
//            line.insert(25, "EFFECT");
//
//            outFile.write("Spells Report\n");
//            outFile.write(line.toString());
//
//            ArrayList<Spell> spells = Potterheads.getPlayer().getSpells();
//
//            for (int i = 0; i <= Potterheads.getPlayer().getSpells().size(); i++) {
//
//                line = new StringBuilder("                                                  ");
//                line.insert(0, spells.get(i).getName());
//                line.insert(25, spells.get(i).getEffect());
//                outFile.write(line.toString() + "\n");
//            }
//
//            out.flush();
//
//        } catch (IOException ex) {
//            ErrorView.display(this.getClass().getName(), "Error saving spells report.");
//
//        } finally {
//            if (outFile != null) {
//                try {
//                    outFile.close();
//                } catch (IOException ex) {
//                    Logger.getLogger(SpellReportView.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }
}
