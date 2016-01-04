/**
 * Created by bob.zhu on 1/4/16.
 */
import org.sikuli.script.*;
import org.sikuli.basics.Debug;

import java.io.IOException;

public class Main {
    static int times = 100;
    static Screen s = new Screen();

    public static void enterKey(String key, int count) {
        for (int i = 0; i < count; i++)
            s.type(key);
    }

    public static void main(String[] args) throws FindFailed, IOException {
        for (int i = 0; i < times; i++) {
            try {
                s.doubleClick("imgs/rcmeetingstart.png");
                s.doubleClick("imgs/signin.png");
                s.doubleClick("imgs/signin.png");
                s.click("imgs/selectregion.png");
                enterKey(Key.UP, 10);
                enterKey(Key.ENTER, 1);
                s.click("imgs/phonenumber.png");
                s.type("33185642659");
                s.click("imgs/password.png");
                s.type("Test!123");
                enterKey(Key.ENTER,1);
                Pattern p = new Pattern("imgs/logoutdropdown.png").targetOffset(62, 0);
                s.doubleClick(p);
                s.click(p);
                enterKey(Key.DOWN, 3);
                enterKey(Key.ENTER, 1);
            } catch (FindFailed e) {
                e.printStackTrace();
                takescreenshot("run_"+i+"_times_get_error.png");
            } finally {
                killmeeting();
            }
        }
    }

    private static void takescreenshot(String name) throws IOException {
        Runtime.getRuntime().exec(new String[]{"screencapture",
                String.format("/Users/bob.zhu/project/SikuliTests/screens/{0}", name)});
    }

    private static void killmeeting() throws IOException {
        Runtime.getRuntime().exec(new String[]{"sh",
                "/Users/bob.zhu/project/SikuliTests/kill.sh"});
    }
}