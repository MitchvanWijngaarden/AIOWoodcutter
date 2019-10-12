package AIOWoodcutter.strategies;

import AIOWoodcutter.data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import org.rev317.min.api.wrappers.TilePath;

public class HandleDisconnect implements Strategy {
    @Override
    public boolean activate() {
        return Game.isLoggedIn() &&
                !Variables.getLocation().getBankZone().inTheZone() &&
                !Variables.getTree().getChopZone().inTheZone() &&
                !Variables.pathToWalk.hasReached();
    }

    @Override
    public void execute() {
        Variables.setBotStatus("handling dc");
        Variables.pathToWalk = new TilePath(Variables.getTree().getPathToBank());

        while (Variables.pathToWalk != null && !Variables.pathToWalk.hasReached()) {
            Variables.pathToWalk.traverse();
            Time.sleep(1000, 2000);
        }
    }
}
