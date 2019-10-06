package AIOWoodcutter.strategies;

import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.*;
import org.rev317.min.api.wrappers.Npc;
import org.rev317.min.api.wrappers.TilePath;
import AIOWoodcutter.data.Variables;

public class Bank implements Strategy {

    @Override
    public boolean activate() {
        return Game.isLoggedIn() &&
                Inventory.isFull();
    }

    @Override
    public void execute() {
        TilePath path = new TilePath(Variables.getTree().getPathToBank());
        while (path != null && !path.hasReached()) {
            path.traverse();
            Time.sleep(1000, 2000);
        }
        depositLogs();
    }
    public void depositLogs() {
        Npc banker[] = Npcs.getNearest(494);

        if (banker != null) {
            banker[0].interact(Npcs.Option.BANK);
            Time.sleep(3000);
            if (Game.getOpenInterfaceId() == 5292) {
                org.rev317.min.api.methods.Bank.depositAllExcept(1350, 1352, 1354, 1356, 1358, 1360, 6740);
            }
        }
    }
}