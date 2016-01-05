import org.sikuli.script.*;
import java.io.IOException;
import java.util.List;

public class Main {
    static Screen screen = new Screen();

    public static void enterKey(String key, int count) {
        for (int i = 0; i < count; i++)
            screen.type(key);
    }

    public static void main(String[] args) throws FindFailed, IOException {
        List<Sequence> list = Sequence.readAll();
        for (Sequence se:list) {
            execute(se);
        }
    }

    private static void execute(Sequence sequence) throws IOException {
        for (int i = 0; i < sequence.getTimes(); i++) {
            try {
                screen.doubleClick("imgs/rcmeetingstart.png");
                screen.doubleClick("imgs/signin.png");
                screen.doubleClick("imgs/signin.png");
                screen.click("imgs/selectregion.png");
                enterKey(Key.UP, sequence.getCountry());
                enterKey(Key.ENTER, 1);
                screen.click("imgs/phonenumber.png");
                screen.type(sequence.getUsername());
                screen.click("imgs/password.png");
                screen.type(sequence.getPassword());
                enterKey(Key.ENTER,1);
                Pattern p = new Pattern("imgs/logoutdropdown.png").targetOffset(62, 0);
                screen.doubleClick(p);
                screen.click(p);
                enterKey(Key.DOWN, 3);
                enterKey(Key.ENTER, 1);
            } catch (FindFailed e) {
                e.printStackTrace();
                takescreenshot("country_"+sequence.getCountry()+"run_"+i+"_times_get_error.png");
            } finally {
                killmeeting();
            }
        }
    }

    private static void takescreenshot(String name) throws IOException {
        Runtime.getRuntime().exec(new String[]{"screencapture",
                String.format("/Users/bob.zhu/project/SikuliTests/screens/%s", name)});
    }

    private static void killmeeting() throws IOException {
        Runtime.getRuntime().exec(new String[]{"sh",
                "/Users/bob.zhu/project/SikuliTests/kill.sh"});
    }
}