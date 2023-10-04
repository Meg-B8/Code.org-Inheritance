package important;
import java.util.ArrayList;
import java.util.Scanner;

import gametime.Consumable;
import gametime.Defense;
import gametime.Item;
import gametime.Weapon;
/**
 * Write a description of class AdConf here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AdConf
{
    private boolean configuring = true; 
    private Adventurer play;
    private Backpack packs;
    private String name;
    private Boolean notInPack = true;
    private ArrayList<Item> packItems;
    Scanner scanner = new Scanner(System.in).useDelimiter("~");
    public AdConf(Adventurer player){
        play = player;
        name = player.getName();
        packs = player.getBackpack();
        Configuring();
    }

    public Adventurer Configuring(){
        if (configuring){
            System.out.println("What would you like to do?");
            System.out.println("1. Look at stats \n2. Look at backpack \n3. Stop");
            String looking = scanner.nextLine();
            if (looking.toLowerCase().equals("look at stats") || 
            looking.toLowerCase().equals("stats") || 
            looking.toLowerCase().equals("1")){
                stats();
            } else if (looking.toLowerCase().equals("look at backpack") || 
            looking.toLowerCase().equals("backpack") || 
            looking.toLowerCase().equals("2")){
                pack();
            } else if (looking.toLowerCase().equals("stop") || looking.toLowerCase().equals("3")){
                configuring = false;
                System.out.println("Stopped configuring for now!");
                return play;
            }
            
        }
        return play;
    }
    public void stats(){
        System.out.print("Name: " + name);
        System.out.println("  Coins: " + play.getMoney());
        System.out.print("Health: " + play.getHealth());
        System.out.print("  Defense: " + play.getDefense());
        System.out.println("  Attack: " + play.getAttack());
        System.out.println("Equiped: " + play.getHand() + " in hands");
        System.out.println("Equiped: " + play.getArm() + " on their arm");
        System.out.println("Equiped: " + play.getChest() + " on their chest");
        System.out.println("Equiped: " + play.getLeg() + " on their leg area");
        System.out.println("-------------------------");
         if (configuring) {continueConf();}
    }

    public Adventurer continueConf(){
        System.out.println("Would you like to continue configuring?");
        String cont = scanner.nextLine();
        if (cont.toLowerCase().equals("yes") || cont.toLowerCase().equals("y")){
            Configuring();
        } else if (cont.toLowerCase().equals("no") || cont.toLowerCase().equals("n")){
            configuring = false;
            System.out.println("Alright! Stopping configurations...");
        }
        return play;
    }

    public Adventurer pack(){
        if (configuring){
            System.out.println("Here are the items in your backpack! Type in 'cancel' to use none.");
            packItems = packs.getInventory();
            //All but the last item
            for (int i = 0; i < packItems.size()-1; i++){
                System.out.print(" " + packItems.get(i).getName() + ",");
            }
            //Print last item
            System.out.print(" " + packItems.get(packItems.size()-1).getName());
            System.out.println();
            
            System.out.println("What would you like to use?");
            String obj = scanner.nextLine();
            if (obj.toLowerCase().equals("cancel")) {
            	Configuring();
            } else {
            for (int i = 0; i < packItems.size(); i++){
                if (obj.toLowerCase().equals(packItems.get(i).getName().toLowerCase())){
                	packContinued(packItems.get(i));
                	notInPack = false;
                	break;
                } else {notInPack = true;} 
            }
           if (notInPack) {
            	System.out.println("Sorry, please type that again!");
              	pack();
            	}
            }
         }
                if (configuring) {
                	   continueConf();	
                }
        
        return play;
    }
    public Adventurer packContinued(Item equip) {
    	  if (equip instanceof Consumable){
              play.consume((Consumable)equip); 
          } else if (equip instanceof Weapon){
        	  System.out.println("Your attack rose " + ((Weapon) equip).getDamage() + "!");
              play.equip((Weapon)equip);
          } else if (equip instanceof Defense){
        	  System.out.println("Your defense rose " + ((Defense) equip).getDefense() + "!");
              play.wear((Defense)equip);
          } else {
          	System.out.println("Sorry, please type that again!");
          	pack();
          }
    	  System.out.println("The item " + equip.getName() + " has been removed from your backpack.");
    	return play;
    }
}
