package AIOWoodcutter.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.methods.SceneObjects;
import org.rev317.min.api.wrappers.SceneObject;
import AIOWoodcutter.data.Variables;

public class ChopTree implements Strategy {

    SceneObject tree; // local variable to store the tree.

    @Override
    public boolean activate() {
        tree = tree(); // set the local Variable

        return  Game.isLoggedIn() &&
                Players.getMyPlayer().getAnimation() == -1 &&
                !Inventory.isFull() &&
                tree != null &&
                Variables.getTree().getChopZone().inTheZone();
    }

    @Override
    public void execute() {
        //Chop the tree
        tree.interact(SceneObjects.Option.CHOP_DOWN);
        Time.sleep(1000);
        //Wait for the Player to chop the Tree
        Time.sleep(new SleepCondition() {
            @Override
            public boolean isValid() {
                return Players.getMyPlayer().getAnimation() == -1;
            }
        }, 3000);
    }

    private SceneObject tree(){
        //Loop through all loaded Objects and return the once that match the TREE_IDS.
        for(SceneObject tree : SceneObjects.getNearest(Variables.getTree().getTreeIds())){
            //Check if the Object is around.
            if(tree != null){
                if(Variables.getTree().getChopZone().inTheZoneObject(tree)) {
                    return tree;
                }
            }
        }
        //Return null when no Object is Found.
        return null;
    }
}