package gametime;

import java.lang.Math;
/**
 * Write a description of class Mana here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mana extends StatBoost
{
   int mana = 999;
   public Mana(){
       super("Mana Potion", 20, 
       "Restores mana by a random amount to your magic items when used.");
       mana = (int)(Math.random() * 20) + 5;
    }
   public int getManaPotion(){
       return mana;
    }
}
