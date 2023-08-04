package selenium.ui.helper;

public class WaitManager {
    public static void pause(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
