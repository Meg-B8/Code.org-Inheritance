
package gametime;

import java.lang.Math;
/**
 * Write a description of class Weapon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Weapon extends Item implements WeaponInterface
{
    //values to be used in weapon classes
    int damages;
    int durability;
    boolean parryAbility;
    public Weapon(String name, int val,
        String description, int damage, boolean parry, int dur){
        super(name, val, description);
        damages = damage; 
        parryAbility = parry;
        durability = dur;
    }
    public int getDamage(){ 
        return damages;
    }
    public boolean parry(boolean parryAbility){
        if (parryAbility == true){
            int num = (int)(Math.random());
            if (num == 0){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    public boolean getParryAbility(){
        return parryAbility;
    }
    public int getDurability(){
        return durability;
    }
}
