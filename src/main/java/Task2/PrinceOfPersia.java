package Task2;

import java.io.File;
import java.util.List;

public class PrinceOfPersia {
    public static final int ACTION_TIME = 5;
    public static void main(String[] args) {
        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);
        PrinceReader reader = new PrinceReader();
        List<String[][]> tower = reader.readFromFile();
        PrinceRunner runner = new PrinceRunner(tower, ACTION_TIME);

        System.out.println(runner.findPrincess());
    }
}
