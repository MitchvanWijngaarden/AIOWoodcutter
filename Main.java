package AIOWoodcutter;

import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import AIOWoodcutter.data.Constants;
import AIOWoodcutter.data.Variables;
import AIOWoodcutter.strategies.Bank;
import AIOWoodcutter.strategies.Walk;
import AIOWoodcutter.strategies.ChopTree;
import AIOWoodcutter.ui.UI;

import java.awt.*;
import java.util.ArrayList;

/**
 * User: Mitch
 */
@ScriptManifest(
        author = "Mitch",
        name = "AIOWoodcutter",
        category = Category.WOODCUTTING,
        version = 0.1,
        description = "Chops trees.",
        servers = {"2006rebotted"})

public class Main extends Script implements Paintable {
    private ArrayList<Strategy> strategies;

    @Override
    public boolean onExecute() {

        UI ui = new UI();
        ui.setVisible(true);
        while (ui.isVisible()) {
            Time.sleep(300);
        }

        System.out.println(Variables.getLocation());
        System.out.println(Variables.getTree());

        strategies = new ArrayList<>();
        strategies.add(new Walk());
        strategies.add(new Bank());
        strategies.add(new ChopTree());

        provide(strategies);
        return true;
    }

    @Override
    public void onFinish() {
        System.out.println("Script Stopped");
    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.drawString("AIOWoodcutter", 554, 223);
        g.drawString("Runtime: " + Constants.SCRIPT_TIMER.toString(), 553, 241);
    }
}