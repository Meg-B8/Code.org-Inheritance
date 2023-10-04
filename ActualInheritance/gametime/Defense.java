package gametime;

import java.lang.Math;
/**
 * Write a description of class Defense here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Defense extends Item implements DefenseCommands
{
    //variables for defense 
    //"null" and 999 shall not be used anywhere else to distinguish
    //errors in code (because some items do not have a val)
    int durability = 999;
    int defense = 999;
    public Defense(String name, int val, 
    String description, int dur, int defense){
        super(name, val, description);
        durability = dur;
        this.defense = defense;
    }

    public boolean blocked(){
        int num = (int)(Math.random() * 3);
        if (num == 0){
            return false;
        } else {
            durability--;
            if (durability <= 0){
                System.out.println("Your" + name + " broke!");
            }
            return true;
        }
    }

    public int getDurability(){
        return durability;
    }
    public boolean isBroken(){
        return durability <= 0;
    }
    public int getDefense(){
        return defense;
    }
}
