package AIOWoodcutter.strategies;

import AIOWoodcutter.Methods;
import AIOWoodcutter.data.Variables;
import org.parabot.environment.api.utils.Time;
import org.parabot.environment.input.Keyboard;
import org.parabot.environment.input.Mouse;
import org.parabot.environment.scripts.framework.SleepCondition;
import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.min.api.methods.Game;
import java.awt.*;
import java.awt.event.KeyEvent;

public class HandleLogin implements Strategy {

    private Point point = new Point(432, 282);
    private Point point2 = new Point(368, 265);
    private Boolean typed = false;

    @Override
    public boolean activate() {
        return !Game.isLoggedIn() || Game.getOpenBackDialogId() == 4900;
    }

    public void execute() {
        if (Game.isLoggedIn() && Game.getOpenBackDialogId() == 4900) {
            Time.sleep(1000);
            org.rev317.min.api.methods.Menu.sendAction(679, 17825792, 113, 4907, 1088, 1);
            Time.sleep(500);
        }
        if (!Game.isLoggedIn()) {
            if(Variables.getAccountPassword() != null && Variables.getAccountUsername() != null) {
                if(!typed) {
                    Mouse.getInstance().click(point);
                    Time.sleep(1000);
                    clearInput();
                    Keyboard.getInstance().sendKeys(Variables.getAccountUsername());
                    Time.sleep(2000);

                    clearInput();
                    // Checking again so people don't type their passwords ingame.
                    if(!Game.isLoggedIn()) {
                        Keyboard.getInstance().sendKeys(Variables.getAccountPassword());
                    }

                    typed = true;
                }
            }

            if(typed) {
                Time.sleep(new SleepCondition() {
                    @Override
                    public boolean isValid() {
                        return Game.isLoggedIn();
                    }
                }, 5000);
                Mouse.getInstance().click(point);
                Time.sleep(1000);
                Keyboard.getInstance().clickKey(KeyEvent.VK_ENTER);
                Time.sleep(1000);
                Keyboard.getInstance().clickKey(KeyEvent.VK_ENTER);
            }
        }
    }

    private void clearInput() {
        for(int i = 0; i < 30; i ++) {
            Keyboard.getInstance().clickKey(KeyEvent.VK_DELETE);
            Time.sleep(100);
        }
    }
}
