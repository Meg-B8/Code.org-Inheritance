package gametime;




/**
 * Write a description of class Amo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Amo extends StatBoost
{
   int amo = 10;
   public Amo(){
       super("Amo Pack", 20, "Replenish amo by 10");
    }
   public int getAmoPack(){
       return amo; 
    }
}
