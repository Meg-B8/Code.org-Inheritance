package gametime;


/**
 * Write a description of class Guns here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gun extends NonMagic
{
    //variables for GUN 
    int amo;
    public Gun(String name, int val,
    String description, int damage, boolean parry, int dur, int amunition){
        super(name, val, description, damage, parry, dur);
        amo = amunition;
    }
    public int getAmo(){
        return amo;
    }
    public boolean haveAmo(){
        if (getAmo() <= 0){
            return false;
        } else {
            return true;
        }
    }
    public void addAmo(int added){
        amo += added;
    }
}
