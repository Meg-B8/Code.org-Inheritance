package important;

import gametime.Defense;
import gametime.Item;
import gametime.Melee;

/**
 * Abstract class Character - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Character
{
    int health = 999;
    int defense = 999;
    int attack = 999;
    int distance = 999;
    String name = "null";
    Item armSlot = null;
    Item chestSlot = null;
    Item handSlot = null;
    Item legSlot = null;
    public Character(String name, int health, int defense, int attack){
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.attack = attack;
    }

    public void attack(Character target, int damage){
        target.takeDMG(damage, target);
    }

    public int takeDMG(int damage, Character target){
        if (handSlot instanceof Melee){
            if (((Melee)handSlot).close(distance) == false){
                System.out.println(target + " is not close enough!");
                return health;
            }
        }
        health -= (damage - (target.getDefense()));
        if (health <= 0){
            System.out.println(target + "has died!");
            if (target.getName() == name){
                System.exit(0);
            }
            return 0;
        } else {
            return health;
        }
    }
    public void checkNull(Item equip) {
    	if (equip.equals(null)) {
    		System.out.print(" NOTHING ");
    	}
    }

    //slots
    public Item getArm(){
        if (armSlot instanceof Defense){
            if (((Defense)armSlot).isBroken() == true){
                armSlot = null;
            }
        }
        return armSlot;
    }

    public Item getChest(){
        if (armSlot instanceof Defense){
            if (((Defense)armSlot).isBroken() == true){
                armSlot = null;
            }
        }
        return chestSlot;
    }

    public Item getHand(){
        return handSlot;
    }

    public Item getLeg(){
        if (armSlot instanceof Defense){
            if (((Defense)armSlot).isBroken() == true){
                armSlot = null;
            }
        }
        return legSlot;
    }

    public int getHealth(){
        return health;
    }

    public int getDefense(){
        return defense;
    }

    public int getAttack(){
        return attack;
    }

    public String getName(){
        return name;
    }

    public int getDistance(){
        return distance;
    }

    public void setDistance(int dis){
        distance = dis;
    }
    
    public void setHand(Item obj){
        handSlot = obj;
    }
    
    public void setArm(Item obj){
        armSlot = obj;
    }

    public void setChest(Item obj){
        handSlot = obj;
    }

    public void setLeg(Item obj){
        legSlot = obj;
    }
   
}
