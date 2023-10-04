package important;
import gametime.Amo;
import gametime.Armor;
import gametime.AttackBoost;
import gametime.Consumable;
import gametime.DefBoost;
import gametime.Defense;
import gametime.FanShirt;
import gametime.Food;
import gametime.Gun;
import gametime.Item;
import gametime.KingLeg;
import gametime.Leggings;
import gametime.Magic;
import gametime.Mana;
import gametime.MasterPlate;
import gametime.QuestionableStew;
import gametime.Shield;
import gametime.Weapon;
import gametime.WoodChest;
import gametime.WorkBoots;
/**
 * Write a description of class Adventurer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Adventurer extends Character
{
    //since every adventurer has a backpack: 
    Backpack backpack;
    int money;
    public Adventurer(String name, int health, int defense, int attack, int money, Backpack bp){
        //make the person - health stat, defense stat, attack stat
        super(name, health, defense, attack);
        backpack = bp;
        this.money = money;
    }
    //getting variables
    public Backpack getBackpack(){
        return backpack;
    }
    public int getMoney(){
        return money;
    }
    public void addMoney(int amt){
        money += amt; 
    }
    //changes the variables (I forgot the vocab word)
    public void consume(Consumable item){
        if(item instanceof Food){
            health += ((Food)item).getHealth();
            System.out.println("You consumed " + item.getName() + 
            ", it rose your health by " + ((Food)item).getHealth());
            if (item instanceof QuestionableStew){
                if (health == 0){
                    System.out.println("You ate too much questionable Stew! You died!");
                    System.exit(0);
                }
            }
        } else if (item instanceof DefBoost){
            defense += ((DefBoost)item).getDefense();
            System.out.println("You consumed " + item.getName() + 
            ", it rose your defense by " + ((DefBoost)item).getDefense());
        } else if (item instanceof AttackBoost){
            attack += ((AttackBoost)item).getAttack();
            System.out.println("You consumed " + item.getName() + 
            ", it rose your attack by " + ((AttackBoost)item).getAttack());
        } else if (item instanceof Mana){
            if (handSlot instanceof Magic){
                ((Magic)handSlot).addMana(((Mana)item).getManaPotion());
                System.out.println("You consumed " + item.getName() + 
            ", it rose your weapon mana by " + ((Mana)item).getManaPotion());
            } else {
                System.out.println("Please equip a magic item before using!");
            }
        } else if (item instanceof Amo){
            if (handSlot instanceof Gun){
                ((Gun)handSlot).addAmo(((Amo)item).getAmoPack());
                System.out.println("You consumed " + item.getName() + 
            ", it rose your weapon's amo by " + ((Amo)item).getAmoPack());
            } else {
                System.out.println("Please equip a gun before using!");
            }
        }
    }
    public void wear(Defense item){
        if (item instanceof Armor){
        	if (item instanceof Leggings || item instanceof WorkBoots || item instanceof KingLeg) {
        		legSlot = item;
        	} else if (item instanceof MasterPlate || item instanceof WoodChest ||  item instanceof FanShirt) {
        		chestSlot = item;
        	}
            defense +=  ((Armor)item).getDefense();
            backpack.useItem(item);
        } else if (item instanceof Shield){
            if(armSlot == null){
                defense += ((Shield)item).getDefense();
                backpack.useItem(item);
                armSlot = item;
            } else {
                unequip((Armor)item);
                defense += ((Shield)item).getDefense();
                backpack.useItem(item);
                armSlot = item;
            }
        }
    }

    public void equip(Weapon item){
        if (handSlot == null){
            attack += ((Weapon)item).getDamage();
            backpack.useItem(item);
            handSlot = item;
        } else {
            unequip((Weapon)handSlot);
            attack += ((Weapon)item).getDamage();
            backpack.useItem(item);
            handSlot = item;
        }
    }

    public void unequip(Item item){
    	backpack.storeItem(item);
        if (item instanceof Weapon){
            attack -= ((Weapon)item).getDamage();
            handSlot = null;
        } else if (item instanceof Defense){
            defense -= ((Defense)item).getDefense();
            armSlot = null;
        }
    }
}
