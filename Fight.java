package important;


/**
 * Write a description of class Fight here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fight
{
    //vars needed 
    private Adventurer play = null; 
    private EvilGuy enemy = null;
    private AdConf configure = new AdConf(play);
    //fight with target
    //give option of configuring person
    //give option of fighting target
    //continues to go until one is dead
    //if player dies then game over
    //if target dies then congrats!
    public Fight(Adventurer player, EvilGuy target){
        play = player;
        enemy = target;
    }
    
}
