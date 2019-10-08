package AIOWoodcutter;

import AIOWoodcutter.data.Constants;
import AIOWoodcutter.data.Variables;
import AIOWoodcutter.strategies.*;
import AIOWoodcutter.ui.UI;
import org.parabot.environment.api.interfaces.Paintable;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.scripts.Category;
import org.parabot.environment.scripts.Script;
import org.parabot.environment.scripts.ScriptManifest;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.events.MessageEvent;
import org.rev317.min.api.events.listeners.MessageListener;
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

public class Main extends Script implements MessageListener, Paintable {
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
        if(Variables.getPickupBirdNests()) {
            strategies.add(new PickupBirdNest());
        }
        if(Variables.isBanking()) {
            strategies.add(new Bank());
        }
        if(Variables.isDrop()) {
            strategies.add(new Drop());
        }
        strategies.add(new ChopTree());
        strategies.add(new HandleLogin());
        strategies.add(new HandleDisconnect());

        // add birds nest 5072
        //5070
        //5074
        //5075
        // look for other ids


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
        Color c=new Color(0f,.5f,.5f,.5f );
        g.setColor(c);
        g.setBackground(c);
        g.fillRect(395, 252, 120, 88);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", 1, 14));
        g.drawString("AIOWoodcutter", 400, 270);
        g.setFont(new Font("Arial", 1, 11));
        g.drawString("Logs(P/H): " + Methods.formatNumber(Variables.getLogs()) + "(" + Methods.formatNumber(Constants.SCRIPT_TIMER.getPerHour(Variables.getLogs())) + ")", 400, 290);
        g.drawString("EXP(P/H): " + Methods.formatNumber(Variables.getExpGained()) + "(" + Methods.formatNumber(Constants.SCRIPT_TIMER.getPerHour(Variables.getExpGained())) + ")", 400, 310);
        g.drawString("Runtime: " + Constants.SCRIPT_TIMER.toString(), 400, 330);
    }

    @Override
    public void messageReceived(MessageEvent message) {
        switch (message.getType()) {
            case 0:
                if (message.getMessage().contains("You manage to get some")) {
                    Variables.setLogs(Variables.getLogs() + 1);
                    Variables.setExpGained((int) (Variables.getExpGained() + Variables.getTree().getExp()));
                }
                if (message.getMessage().contains("Congratulations, you advanced a woodcutting level.")) {
                    // add in level up to paint
                }
                break;
        }
    }
}