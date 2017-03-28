/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.potterheads.view;

import byui.cit260.potterheads.model.Spell;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import potterheads.Potterheads;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import potterheads.Potterheads;


/**
 *
 * @author aleecrook
 */
public class SpellReportView extends View{
    
    protected final PrintWriter console = Potterheads.getOutFile();
    
    public SpellReportView(){
        super("P - Print Menu\n"
            + "Q - Back to Main Menu");
    }
    
    @Override
    public boolean doAction(String value){
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
    
    public void printReport(){
        this.console.println("Enter the name of the file you want to save your report to.");
        
        Scanner input = new Scanner(System.in);
        
        String fileName = input.nextLine();
        
        FileWriter outFile = null;
        
        String fileLocation = fileName;
        
        try {
            outFile = new FileWriter(fileLocation);
            
            StringBuilder line;
            
            line = new StringBuilder("                                                              ");
            line.insert(0, "NAME");
            line.insert(25, "EFFECT");
        
            outFile.write("Spells Report\n");
            outFile.write(line.toString());
            
            ArrayList<Spell> spells = Potterheads.getPlayer().getSpells();
            
            for(int i = 0; i <= Potterheads.getPlayer().getSpells().size(); i++){
                
                line = new StringBuilder("                                                  ");
                line.insert(0, spells.get(i).getName());
                line.insert(25, spells.get(i).getEffect());
                outFile.write(line.toString() + "\n");
            }
            
            
            outFile.flush();
            
        } catch (IOException ex) {
            ErrorView.display(this.getClass().getName(), "Error saving spells report.");
            
        } finally {
            if (outFile != null) {
                try {
                    outFile.close();
                } catch (IOException ex) {
                    Logger.getLogger(SpellReportView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
