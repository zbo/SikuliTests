/**
 * Created by bob.zhu on 1/4/16.
 */
import org.sikuli.script.*;
import org.sikuli.basics.Debug;
public class Main {
    static int times =100;
    static Screen s = new Screen();
    public static void enterKey(Screen s, String key, int count){
        for(int i=0;i<count;i++)
            s.type(key);
    }

    public static void main(String[] args) throws FindFailed {

        try{
            s.doubleClick("imgs/rcmeetingstart.png");
            s.doubleClick("imgs/signin.png");
            s.doubleClick("imgs/signin.png");
            s.click("imgs/selectregion.png");
            enterKey(s,Key.UP,10);
            enterKey(s,Key.ENTER,1);
            s.click("imgs/phonenumber.png");
            s.type("33185642659");
            looplogin_once();
            loop(times);
        }
        catch(FindFailed e){
            e.printStackTrace();
        }
    }

    private static void loop(int times) throws FindFailed {
        for(int i=0;i<times;i++){
            try{
                looplogin_once();
            }
            catch(Exception e){
                //take screen shoot
                System.out.println("error once");
                enterKey(s,Key.ENTER,1);
                Pattern p = new Pattern("imgs/logoutdropdown.png").targetOffset(62,0);
                s.doubleClick(p);
                s.click(p);
                enterKey(s,Key.DOWN,3);
                enterKey(s,Key.ENTER,1);
            }
        }
    }

    private static void looplogin_once() throws FindFailed {
        s.click("imgs/password.png");
        s.type("Test!123");
        s.type(Key.ENTER);
        Pattern p = new Pattern("imgs/logoutdropdown.png").targetOffset(62,0);
        s.doubleClick(p);
        s.click(p);
        enterKey(s,Key.DOWN,3);
        enterKey(s,Key.ENTER,1);
    }
}
