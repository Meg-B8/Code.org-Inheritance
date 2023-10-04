package gametime;


/**
 * Write a description of class Sword here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sword extends Melee
{
   public Sword(String name, int val,
    String description, int damage, boolean parry, int dur){
        super(name, val, description, damage, parry, dur);
    }
}
