package important;

import java.util.Scanner;

import gametime.Item;
import important.Backpack;
import java.lang.Math;
import java.util.ArrayList;
/**
 * Write a description of class Adventure here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Game
{
    //Getting name 
    //Variables used all around the adventure
    private String name;
    private Adventurer player;
    private Backpack pack;
    private Scanner scanner = new Scanner(System.in).useDelimiter("~");
    private Scanner intScanner = new Scanner(System.in);
    private EvilGuy evil = new EvilGuy();

    public static void main(String[] args) {
        new Game();
    }
    
    public Game() {
    	//makes players
    	pack = new Backpack();
    	player = new Adventurer(name, 20, 10, 1, 200, pack);
    	
        System.out.println("Hi there adventurer! Welcome to our world.");
        System.out.println("Please enter your name.\n(Note: you cannot change it after)");
        name = scanner.nextLine();
        System.out.println("Hi there, " + name + "! Here is 200 coins.");
        System.out.println("Here adventurers like you often start at the shop" + 
            "\nand hunt or gather materials.");
        System.out.println("\n. . .However that won't get you much in the shop" + 
            ". . . \nWant to gamble with me to get the chance to get more? (y/n) ;)");
        String gamble = scanner.nextLine();
        if (gamble.toLowerCase().equals("yes") || 
        gamble.toLowerCase().equals("y") || gamble.toLowerCase().equals("1")){
            gamble();
            shopping();
            configure();
            //fight();
        }else if (gamble.toLowerCase().equals("no") ||
        gamble.toLowerCase().equals("n") || gamble.toLowerCase().equals("2")){
            System.out.println("Okay. Let's go to the shop!");
            shopping();
            configure();
            //fight();
        } else if(gamble.equals("ineedthemoneyhandsup")){
            System.out.println("Well okay, if you're that desperate..."
                + "\n1000 coins have been added to your account.");
            player.addMoney(1000);
            shopping();
            configure();
            //fight();
        }
        else {
            System.out.println("Well I have no idea what you want...Let's start over, shall we?");
            goAgain(); 
        }
        //Gamble money 
        //Go to shop to buy items
        //continue on your way to fight monsters or gather

    }
    public static void goAgain() {
    	//makes it so players can redo if they have an accident
    	System.out.println("Pretend like this never happened...\n");
    	new Game();
    }
    public void gamble(){
        System.out.println("^0^ ----System's Simple Gamble!---- ^0^");
        System.out.println("\n \nWelcome to my gambling game!" + 
            "\nPlease pick a number between 1-10, then the amount you want to" + 
            "\ngamble. If your number matches then it multiplies by the amount you" + 
            "\nput down! Otherwise you lose it all.");
        System.out.print("Number you're guessing: ");
        int gambleNum = intScanner.nextInt();
        System.out.print("Amount bet: ");
        int bet = intScanner.nextInt();
        int money = player.getMoney();
        if (bet > money){
            System.out.println("Oops! You bet more than you have!"
                + "\nSetting your bet to 200.");
            bet = money;
        } else if (bet < 0) {
            System.out.println("That's less than 0! Setting your bet to 1.");
            bet = 1;
        }
        int ranNum = (int)(Math.random() * 9) + 1;
        System.out.println("The fortune is..." + ranNum );
        if (gambleNum == ranNum){
            bet = bet * gambleNum;
            player.addMoney(bet);
            System.out.println("You won! Your balance is " + player.getMoney());
        } else {
            player.addMoney(-bet);
            System.out.println("You lost! Your balance is " + player.getMoney());
        }
    }

    public void shopping(){
        ShopList regShop = new ShopList(player);
        System.out.println("\n-------------------------------");
        System.out.println("Hello! ^0^ Welcome to the Shop!");
        regShop.ShoppingSpree();
        int temper = player.getMoney() - regShop.getShopMon();
        player.addMoney(-temper);
        ArrayList<Item> temp = regShop.getShoppedItems();
        for (Item i : temp ){
            pack.storeItem(i);
        }
    }
    
    public void configure(){
        new AdConf(player);
        
    }
}
