package gametime;

import important.Character;
/**
 * Write a description of class Melee here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Melee extends Weapon
{
    //variables for melee 
    public Melee(String name, int val,
    String description, int damage, boolean parry, int dur){
        super(name, val, description, damage, parry, dur);
        
    }
    
    public boolean close(int distance){
        if (distance <= 10){
            durability--;
            if (durability <= 0){
                System.out.println("Your" + name + " broke!");
            }
            return true;
        } else {
            return false;
        }
    }
    
    public int getDist(Character target){
        return target.getDistance();
    }
}
