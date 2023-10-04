package gametime;

import java.lang.Math;
/**
 * Write a description of class Ranged here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ranged extends Weapon
{
   public Ranged(String name, int val,
        String description, int damage, boolean parry, int dur){
        super(name, val, description, damage, parry, dur);
    }
   public boolean hits(){
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
}
