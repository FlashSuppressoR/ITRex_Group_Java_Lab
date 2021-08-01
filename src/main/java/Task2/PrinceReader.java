package Task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrinceReader {
    private int amountOfLevel;
    private int levelWidth;
    private int levelLength;

    public List<String[][]> readFromFile() {
        List<String[][]>  matrixList = new ArrayList<>();
        try {
            String filePath = new File("src/main/resources/input.txt").getAbsolutePath();
            File inputFile = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            String[] setDigital = line.split(" ");
            amountOfLevel = Integer.parseInt(setDigital[0]);
            levelLength = Integer.parseInt(setDigital[1]);
            levelWidth = Integer.parseInt(setDigital[2]);
            char[] indexValue;

            for (int x = 0; x < amountOfLevel; x++) {
                String[][] matrix = new String[levelLength][levelWidth];
                reader.readLine(); // Skip empty line
                for (int i = 0; i < levelLength; i++) {
                    line = reader.readLine();
                    indexValue = line.toCharArray();
                    for (int j = 0; j < levelWidth; j++) {
                        matrix[i][j] = String.valueOf(indexValue[j]);
                    }
                }
                matrixList.add(matrix);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrixList;
    }
}
