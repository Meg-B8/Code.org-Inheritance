package gametime;


/**
 * Write a description of class Magic here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Magic extends Ranged
{
    //variables for MAGIC
    int mana;
    public Magic(String name, int val,
    String description, int damage, boolean parry, int dur, int mana){
        super(name, val, description, damage, parry, dur);
        this.mana = mana;
    }

    public int getMana(){
        return mana;
    }
    
    public void addMana(int added){
        mana += added;
    }
    public boolean hasMana(){
        if (getMana() <= 0){
            return false;
        } else {
            return true;
        }
    }

    public int doMagic(){
        if (hasMana()){
            if(getMana() < 10){
                System.out.println("Your staff is depleting in mana. You preform a small spell.");
                int temp = getDamage()/3;
            } else if(getMana() < 20){
                //temp = damage
            }
        }
        return -1;
    }
}
