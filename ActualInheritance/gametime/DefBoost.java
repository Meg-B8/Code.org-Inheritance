package gametime;


/**
 * Write a description of class DefBoost here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DefBoost extends StatBoost
{
      //variables used in consumables
   //"null" and 999 shall not be used anywhere else to distinguish
   //errors in code (because some items do not have a val)
   //augments health (either + or -)
   int def = 999;
   public DefBoost(String name, int val, String description, int defense){
        super (name, val, description);
        this.def = defense;
   }
   public int getDefense(){ return def;}
}
