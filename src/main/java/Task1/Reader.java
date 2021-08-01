package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public String readFromConsole(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your text:");
        String currentText = scanner.nextLine();
        scanner.close();

        return CheckTextForCharsOrNumbs(currentText);
    }

    public static String CheckTextForCharsOrNumbs(String currentLine){
        String checking = currentLine.replaceAll("[^a-zA-Z\\s]","");
        return checking;
    }
}
