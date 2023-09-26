package gametime;
public abstract class Item implements ItemInterface{
    //Implemented in your own way
    //universal variables
    //"null" and 999 shall not be used anywhere else to distinguish
    //errors in code (because some items are free)
    String name = "null";
    int val = 999;
    String description = "null";
    public String getName(){
        return name;
    }
    public int getVal(){
        return val;
    }
    public String getDescript(){
        return description;
    }
    public Item(String name, int Val, String Description){
        this.name = name;
        description = Description;
        val = Val;
    }
    public String toString() { return name;}
}
