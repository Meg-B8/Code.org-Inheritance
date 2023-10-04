package important;


/**
 * This creates an Inventory for a character
 * 
 * @author Wiebe
 * @version 1.2
 */
import java.util.ArrayList;

import gametime.BackpackInterface;
import gametime.Item;
public class Backpack implements BackpackInterface {
    // instance variables - replace the example below with your own
    private ArrayList<Item> backpack;

    /**
     * Constructor for objects of class Backpack
     */
    public Backpack()
    {
        // initialise instance variables
        backpack = new ArrayList<Item>();
    }

    /**
     * Adds an item to the backpack
     * 
     * @param  item   The item of which to add
     * @return     true if added
     */
    public void storeItem(Item item){
            backpack.add(item);       
    }

    /**
     * Consumes an item in the backpack, removing it.
     * 
     * @param  item   The item of which to delete
     * @return     true if deleted
     */
    public Item useItem(Item item){
        for (int i = 0; i < backpack.size(); i++){
            if(backpack.get(i).equals(item)){
                backpack.remove(i);
                return item;
            }
        }
        return null;
    }
	/**
     * Consumes an item in the backpack, removing it.
     * 
     * @param  name   The name of the item of which to delete
     * @return     true if deleted
     */
	public boolean useItem(String item){
        for (int i = 0; i < backpack.size(); i++){
            if(backpack.get(i).getName().equals(item)){
                backpack.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the contents of the backpack
     * 
     * 
     * @return     An arraylist of Items in the backpack.
     */
    public ArrayList<Item> getInventory(){
        return backpack;
    }

    public int countItems(){
        int count = 0;
        for (Item i : backpack){
            count++;
        }
        return count;
    }
}
