import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.io.IOException;
import java.util.List;

public class Main {
    static Screen screen = new Screen();
    static AppConfig config;
    public static void enterKey(String key, int count) {
        for (int i = 0; i < count; i++)
            screen.type(key);
    }

    public static void main(String[] args) throws FindFailed, IOException {
        List<Sequence> list = Sequence.readAll();
        config= AppConfig.readAll();
        for (Sequence se:list) {
            execute(se);
        }
    }

    private static void execute(Sequence sequence) throws IOException {
        for (int i = 0; i < sequence.getTimes(); i++) {
            try {
                String imgs_folder=config.getImgs_folder();
                screen.doubleClick(imgs_folder+"/rcmeetingstart.png");
                screen.doubleClick(imgs_folder+"/signin.png");
                screen.click(imgs_folder+"/selectregion.png");
                enterKey(Key.UP, sequence.getCountry());
                enterKey(Key.ENTER, 1);
                screen.click(imgs_folder+"/phonenumber.png");
                screen.type(sequence.getUsername());
                screen.click(imgs_folder+"/password.png");
                screen.type(sequence.getPassword());
                enterKey(Key.ENTER,1);
                Pattern p = new Pattern(imgs_folder+"/logoutdropdown.png").targetOffset(62, 0);
                screen.doubleClick(p);
                screen.click(p);
                enterKey(Key.DOWN, 4);
                enterKey(Key.ENTER, 1);
            } catch (FindFailed e) {
                e.printStackTrace();
                takescreenshot("country_"+sequence.getCountry()+"run_"+i+"_times_get_error.png");
            } finally {
                //killmeeting();
            }
        }
    }

    private static void takescreenshot(String name) throws IOException {
        Runtime.getRuntime().exec(new String[]{"screencapture",
                String.format(config.getScreens_folder()+"/%s", name)});
    }

    private static void killmeeting() throws IOException {
        Runtime.getRuntime().exec(new String[]{"sh",
                config.getKiller_path()});
    }
}