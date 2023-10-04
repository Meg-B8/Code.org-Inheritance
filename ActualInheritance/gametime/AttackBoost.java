package gametime;


/**
 * Write a description of class AttackBoost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class AttackBoost extends StatBoost
{
    //variables used in consumables
   //"null" and 999 shall not be used anywhere else to distinguish
   //errors in code (because some items do not have a val)
   //augments health (either + or -)
   int attack = 999;
   public AttackBoost(String name, int val, String description, int attack){
        super(name, val, description);
        this.attack = attack;
   }
   public int getAttack(){ return attack;}
}
