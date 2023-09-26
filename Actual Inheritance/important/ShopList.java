package important;

import java.util.Scanner;
import gametime.StatBoost;
import gametime.Stick;
import gametime.StrongHeart;
import gametime.Sword;
import gametime.TortiseShell;
import gametime.TotallyMetal;
import gametime.Ambrosia;
import gametime.Amo;
import gametime.Armor;
import gametime.AttackBoost;
import gametime.COSMOS;
import gametime.DefBoost;
import gametime.Defense;
import gametime.Donut;
import gametime.DragonKiller;
import gametime.FanShirt;
import gametime.Food;
import gametime.FriedRice;
import gametime.Gandolf;
import gametime.GoldShield;
import gametime.GordonRamsay;
import gametime.Gun;
import gametime.HighAttack;
import gametime.HighDef;
import gametime.Item;
import gametime.KingLeg;
import gametime.Leggings;
import gametime.LowAttack;
import gametime.LowDef;
import gametime.Machine;
import gametime.Magic;
import gametime.Mana;
import gametime.MasterPlate;
import gametime.MedAttack;
import gametime.MedDef;
import gametime.Nerf;
import gametime.OldWest;
import gametime.PaintBrush;
import gametime.Pistol;
import gametime.QuestionableStew;
import gametime.Rusty;
import gametime.Sandwich;
import gametime.Short;
import gametime.Shield;
import gametime.Shiv;
import gametime.Slime;
import gametime.Staff;
import gametime.Weapon;
import gametime.WoodChest;
import gametime.WorkBoots;
import gametime.YeOldePractice;

import java.util.ArrayList;
/**
 * Write a description of class shopList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShopList
{
    //vars needed for this 
    Scanner scanner = new Scanner(System.in).useDelimiter("~");
    private int money = 0;
    private boolean shopping = true;
    private ArrayList<Item> foodList = new ArrayList<Item>();
    private ArrayList<Item> statList = new ArrayList<Item>();
    private ArrayList<Item> armorList = new ArrayList<Item>();
    private ArrayList<Item> shieldList = new ArrayList<Item>();
    private ArrayList<Item> staffList = new ArrayList<Item>();
    private ArrayList<Item> swordList = new ArrayList<Item>();
    private ArrayList<Item> gunList = new ArrayList<Item>();
    //items taken
    private ArrayList<Item> gotItems = new ArrayList<Item>();
    public int getShopMon(){
        return money;
    }

    public ArrayList<Item> getShoppedItems(){
        return gotItems;
    }

    public ShopList(Adventurer player){
        money = player.getMoney();
        ArmorList();
        ShieldList();
        FoodList();
        StatBoost();
        SwordList();
        StaffList();
        GunList();
    }
    //needed
    public Item ShoppingSpree(){
        if (shopping){
            System.out.println("-------------------------------");
            System.out.println("Please choose from these three categories to shop from:"
                + "\n 1. Consumables" + "\n 2. Defenses" + "\n 3. Weapons" + "\n 4. Stop Shopping");
            String cat = scanner.nextLine();
            // while (cat != 0)
            if (cat.toLowerCase().equals("consumables") 
            || cat.toLowerCase().equals("1")){
                return consumables();
            } else if (cat.toLowerCase().equals("defenses") || 
            cat.toLowerCase().equals("2")){
                return defenses();
            } else if (cat.toLowerCase().equals("weapons") || 
            cat.toLowerCase().equals("3")){
                return weapons();
            } else if (cat.toLowerCase().equals("stop shopping") || cat.toLowerCase().equals("4")) {
            	shopping = false;
            }
        } 
        return null;
    }

    public void getInfo(Item obj){
        System.out.println("Name: " + obj.getName());
        System.out.println("Cost: " + obj.getVal() + " coins");
        System.out.println("Description: " + obj.getDescript());
        if (obj instanceof Food){
            System.out.println("Adds " + ((Food)obj).getHealth() + " health");
        } else if (obj instanceof DefBoost){
            System.out.println("Adds " + ((DefBoost)obj).getDefense() + " defense");
        } else if (obj instanceof AttackBoost){
            System.out.println("Boosts attack by " + ((AttackBoost)obj).getAttack());
        } else if (obj instanceof Defense){
            System.out.print("Adds " + ((Defense)obj).getDefense() + " defense.");
            System.out.println("  Durability: " + ((Defense)obj).getDurability());
        } else if (obj instanceof Weapon){
            System.out.print("Does " + ((Weapon)obj).getDamage() + " damage");
            if (obj instanceof Magic) {
                System.out.println("  Has " + ((Magic)obj).getMana() + " mana");
            } else if (obj instanceof Gun){
                System.out.println("  Has " + ((Gun)obj).getAmo() + " amo");
            }
        }
    }

    public Item Shop(ArrayList<Item> list){
    	int num = 0;
        System.out.println("-------------------------------");
        System.out.println("What would you like more info on?");
        System.out.println("Please print out the full name ^^");
        String info = scanner.nextLine();
        for (Item i : list){
        	num++;
            String name = i.getName().toLowerCase();
            if (info.toLowerCase().equals(name)){
                getInfo(i);
                return Buy(i);
            } else if (info.equals(Integer.toString(num))) {
            	getInfo(i);
            	return Buy(i);
            } 
            else if (info.toLowerCase().equals("back") || info.toLowerCase().equals("<<")){
                //I am so sorry for this crap code I'm hard coding this cause it's the last day 
                if (list == foodList || list == statList){
                    return consumables();
                } else if (list == armorList || list == shieldList){
                    return defenses();
                } else if (list == staffList || list == swordList || list == gunList){
                    return weapons();
                }
            }  
        }
        System.out.println("That's not in our system!");
        return ShoppingSpree();
    }

    public Item Buy(Item obj){
        System.out.println("-------------------------------");
        System.out.println("Would you like to buy? *v*");
        String buying = scanner.nextLine();
        if (buying.toLowerCase().equals("y") || buying.toLowerCase().equals("yes")){
            if (money >= obj.getVal()){
                money -= obj.getVal();
                System.out.println("You now have " + money + " coins!");
                System.out.println(obj.getName() + " has been added to your backpack.");
                System.out.println("Once you get out of the shop you can equip items! \n");
                continueBuying();
                gotItems.add(obj);
            } else {
                System.out.println("Oops! You can't buy that. It's too expensive! \n");
                return ShoppingSpree();
            }
        } else if (buying.toLowerCase().equals("n") || buying.toLowerCase().equals("no")){
            //continueBuying();
            if (shopping == true){
                if (obj instanceof Food){return goToList(foodList);} 
                else if (obj instanceof StatBoost){ return goToList(statList);}
                else if (obj instanceof Armor){ return goToList(armorList);}
                else if (obj instanceof Shield) {return goToList(shieldList);}
                else if (obj instanceof Sword) {return goToList(swordList);}
                else if (obj instanceof Staff) {return goToList(staffList);}
                else if (obj instanceof Gun) {return goToList(gunList);}
            }
        }
        return ShoppingSpree();
    }
    public Item goToList(ArrayList<Item> List) {
    	int listNum = 1;
    	System.out.println("Aww...alright! Look here!");
    	for (Item i : List) {
    		 System.out.println(listNum + ": " + i.getName());
             listNum++;
    	}
    	System.out.println("<< Back");
    	return Shop(List);
    }
    public Item continueBuying(){
        System.out.println("Would you like to continue shopping?");
        String cont = scanner.nextLine();
        if (cont.toLowerCase().equals("yes") || cont.toLowerCase().equals("y")){
            return ShoppingSpree();
        } else if (cont.toLowerCase().equals("no") || cont.toLowerCase().equals("n")){
            shopping = false;
            System.out.println("Alright! Leaving shop.... \n");
            return null;
        }
        return null;
    }
    //CONSUMABLE
    public Item consumables(){
        if (shopping == true){
            System.out.println("Which category of consuables?" +
                "\n 1. Food" + "\n 2. Stat Boosts" + "\n << Back");
            String con = scanner.nextLine();
            if (con.toLowerCase().equals("food") 
            || con.toLowerCase().equals("1")){
                System.out.println("Foods:");
                int num = 1;
                for (Item i : foodList){
                    System.out.println(num + ": " + i.getName());
                    num++;
                }
                System.out.println("<< Back");
                return Shop(foodList);
            } else if (con.toLowerCase().equals("stat boosts") 
            || con.toLowerCase().equals("2")){
                System.out.println("Stat Boosts:");
                int num = 1;
                for (Item i : statList){
                    System.out.println(num + ": " + i.getName());
                    num++;
                }
                System.out.println("<< Back");
                return Shop(statList);
            } else if (con.toLowerCase().equals("back") || con.toLowerCase().equals("<<")){
                return ShoppingSpree();
            }
        }
        System.out.println("Seems like you made a typo...Taking you back to the main menu!");
        return ShoppingSpree();
    }

    //DEFENSE
    public Item defenses(){
        if (shopping == true){
            System.out.println("Which category of defenses?" + 
                "\n 1. Armor" + "\n 2. Shields" + "\n << Back");
            String def = scanner.nextLine();
            if (def.toLowerCase().equals("armor") || def.toLowerCase().equals("1")){
                System.out.println("Armor:");
                int num = 1;
                for (Item i : armorList){
                    System.out.println(num + ": " + i.getName());
                    num++;
                }
                System.out.println("<< Back");
                return Shop(armorList);
            } else if (def.toLowerCase().equals("shields") || def.toLowerCase().equals("2")){
                System.out.println("Shields:");
                int num = 1;
                for (Item i : shieldList){
                    System.out.println(num + ": " + i.getName());
                    num++;
                }
                System.out.println("<< Back");
                return Shop(shieldList); 
            } else if (def.toLowerCase().equals("back") || def.toLowerCase().equals("<<")){
                return ShoppingSpree();
            }
        }
        System.out.println("Seems like you made a typo...Taking you back to the main menu!");
        return ShoppingSpree();
    }

    //WEAPON
    public Item weapons(){
        if (shopping == true){
            System.out.println("Which category of weapons?" + 
                "\n 1. Swords" + "\n 2. Staffs" + "\n 3. Guns" + "\n << Back");
            String wep = scanner.nextLine();
            if (wep.toLowerCase().equals("swords") || wep.toLowerCase().equals("1")){
                System.out.println("Swords:");
                int num = 1;
                for (Item i : swordList){
                    System.out.println(num + ": " + i.getName());
                    num++;
                }
                System.out.println("<< Back");
                return Shop(swordList);
            } else if (wep.toLowerCase().equals("staffs") || wep.toLowerCase().equals("2")){
                System.out.println("Staffs:");
                int num = 1;
                for (Item i : staffList){
                    System.out.println(num + ": " + i.getName());
                    num++;
                }
                System.out.println("<< Back");
                return Shop(staffList); 
            }  else if (wep.toLowerCase().equals("guns") || wep.toLowerCase().equals("3")){
                System.out.println("Guns:");
                int num = 1;
                for (Item i : gunList){
                    System.out.println(num + ": " + i.getName());
                    num++;
                }
                System.out.println("<< Back");
                return Shop(gunList); 
            }else if (wep.toLowerCase().equals("back") || wep.toLowerCase().equals("<<")){
                return ShoppingSpree();
            }
        }
        System.out.println("Seems like you made a typo...Taking you back to the main menu!");
        return ShoppingSpree();
    }

    //Lists 

    public ArrayList<Item> ArmorList(){
        Leggings leggin = new Leggings();
        WorkBoots boot = new WorkBoots();
        KingLeg kLeg = new KingLeg();
        FanShirt shirt = new FanShirt();
        MasterPlate mPlate = new MasterPlate();
        WoodChest wChest = new WoodChest();
        armorList.add(leggin);
        armorList.add(boot);
        armorList.add(kLeg);
        armorList.add(shirt);
        armorList.add(mPlate);
        armorList.add(wChest);
        return armorList;
    }

    public ArrayList<Item> ShieldList(){
        Rusty rusty = new Rusty();
        StrongHeart strong = new StrongHeart();
        TortiseShell shell = new TortiseShell();
        GoldShield gold = new GoldShield();
        shieldList.add(rusty);
        shieldList.add(strong);
        shieldList.add(shell);
        shieldList.add(gold);
        return shieldList;
    }

    public ArrayList<Item> FoodList(){
        GordonRamsay gordon = new GordonRamsay();
        QuestionableStew stew = new QuestionableStew();
        Donut donut = new Donut();
        FriedRice friedRice = new FriedRice();
        Sandwich sandwich = new Sandwich();
        Ambrosia ambrosia = new Ambrosia();
        foodList.add(gordon);
        foodList.add(stew);
        foodList.add(donut);
        foodList.add(friedRice);
        foodList.add(sandwich);
        foodList.add(ambrosia);
        return foodList;
    }

    public ArrayList<Item> StatBoost(){
        LowDef lowD = new LowDef();
        MedDef medD = new MedDef();
        HighDef highD = new HighDef();
        LowAttack lowA = new LowAttack();
        MedAttack medA = new MedAttack();
        HighAttack highA = new HighAttack();
        Amo amo = new Amo();
        Mana mana = new Mana();
        statList.add(lowD);
        statList.add(medD);
        statList.add(highD);
        statList.add(lowA);
        statList.add(medA);
        statList.add(highA);
        statList.add(amo);
        statList.add(mana);
        return statList;
    }

    public ArrayList<Item> SwordList(){
        YeOldePractice old = new YeOldePractice();
        Shiv sh = new Shiv();
        PaintBrush paint = new PaintBrush();
        TotallyMetal metal = new TotallyMetal();
        DragonKiller killer = new DragonKiller();
        COSMOS cosmos = new COSMOS();
        swordList.add(old);
        swordList.add(sh);
        swordList.add(paint);
        swordList.add(metal);
        swordList.add(killer);
        swordList.add(cosmos);
        return swordList;
    }

    public ArrayList<Item> StaffList(){
        Stick stick = new Stick();
        Slime slime = new Slime();
        Gandolf gand = new Gandolf();
        Short shorts = new Short();
        staffList.add(stick);
        staffList.add(shorts);
        staffList.add(slime);
        staffList.add(gand);
        return staffList;
    }

    public ArrayList<Item> GunList(){
        Nerf nerf = new Nerf();
        Pistol pist = new Pistol();
        OldWest west = new OldWest();
        Machine mach = new Machine();
        gunList.add(nerf);
        gunList.add(pist);
        gunList.add(west);
        gunList.add(mach);
        return gunList;
    }
}
