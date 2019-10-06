package AIOWoodcutter.strategies;

import AIOWoodcutter.Methods;
import AIOWoodcutter.data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import java.awt.*;
import java.awt.event.KeyEvent;

public class HandleLogin implements Strategy {

    private Point point = new Point(516, 134);

    @Override
    public boolean activate() {
        return !Game.isLoggedIn() || Game.getOpenBackDialogId() == 4900;
    }

    public void execute() {
//        if (Game.isLoggedIn() && Game.getOpenBackDialogId() == 4900) {
//            Time.sleep(1000);
//            org.rev317.min.api.methods.Menu.sendAction(679, 17825792, 113, 4907, 1088, 1);
//            Time.sleep(500);
//        }
//        do {
//            if (Variables.getAccountPassword() == null) {
//                Variables.setAccountPassword(Methods.getPassword());
//            } else if (!Methods.getPassword().equalsIgnoreCase(Variables.getAccountPassword())) {
//                Methods.setPassword(Variables.getAccountPassword());
//            }
//            if (!Methods.isMessageShowing()) {
//                Keyboard.getInstance().clickKey(KeyEvent.VK_ENTER);
//                Time.sleep(5000);
//            } else {
//                Mouse.getInstance().click(point);
//                Time.sleep(1000);
//            }
//        } while (!Game.isLoggedIn());
    }
}
