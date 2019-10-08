package AIOWoodcutter.strategies;

import AIOWoodcutter.data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.methods.GroundItems;
import org.rev317.min.api.methods.Inventory;
import org.rev317.min.api.methods.Players;
import org.rev317.min.api.wrappers.GroundItem;

public class PickupBirdNest implements Strategy {
    @Override
    public boolean activate() {
        return  Game.isLoggedIn() &&
                Players.getMyPlayer().getAnimation() == -1 &&
                !Inventory.isFull() &&
                Variables.getTree().getChopZone().inTheZone() &&
                GroundItems.getNearest(5070,5071, 5072, 5073, 5074, 5075, 7413, 13653).length > 0;
    }

    @Override
    public void execute() {
        GroundItem[] birdNests = GroundItems.getNearest(5070, 5071, 5072, 5073, 5074, 5075, 7413, 13653);
        Variables.setBotStatus("picking up nest");
        for (GroundItem birdNest : birdNests) {
            birdNest.take();
            Time.sleep(3000);
        }
    }
}
