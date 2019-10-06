package AIOWoodcutter.strategies;

import AIOWoodcutter.data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.wrappers.Item;

public class Drop implements Strategy {
    @Override
    public boolean activate() {
        return Game.isLoggedIn() &&
                Inventory.isFull();
    }

    @Override
    public void execute() {
        for(Item log : Inventory.getItems(Variables.getTree().getLogId())){
            if(log != null){
                log.drop();
                Time.sleep(1000);
            }
        }
    }
}