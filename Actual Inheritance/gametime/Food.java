package gametime;


/**
 * Write a description of class Food here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Food extends Consumable
{
   //variables used in consumables
   //"null" and 999 shall not be used anywhere else to distinguish
   //errors in code (because some items do not have a val)
   //augments health (either + or -)
   int health = 999;
   public Food(String name, int val, String description, int health){
        super (name, val, description);
        this.health = health;
   }
   public int getHealth(){ return health;}
}
