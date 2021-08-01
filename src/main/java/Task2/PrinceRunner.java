package Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrinceRunner {
    private int actionTime;
    private List<String[][]> tower;
    private List<String> visitedRooms = new ArrayList<>();
    private List<String> queueRoomsToVisit = new LinkedList<>();
    private int roomLength;
    private int roomWidth;

    public PrinceRunner(List<String[][]> tower, int actionTime) {
        this.tower = tower;
        this.actionTime = actionTime;
        roomLength = tower.get(0).length;
        roomWidth = tower.get(0)[0].length;
    }

    public String findPrincess(){
        String[] startPosition = findRoomInLevel(tower.get(0), "1");
        String startRoom = "0 " + String.join(" ", Arrays.asList(startPosition)) +" 0";
        queueRoomsToVisit.add(startRoom);
        int minCountSteps = 0;

        while (!queueRoomsToVisit.isEmpty()) {
            String currentRoom = queueRoomsToVisit.get(0);
            String[] roomCoordinates = currentRoom.split(" ");
            int currentLevel = Integer.parseInt(roomCoordinates[0]);
            int currentLength = Integer.parseInt(roomCoordinates[1]);
            int currentWidth = Integer.parseInt(roomCoordinates[2]);
            int howFarFromStart = Integer.parseInt(roomCoordinates[3]);
            // Начинаем искать соседей
            String neighbourRoomContent;
            String neighbourCoordinates;
            // Пробуем пробить пол
            boolean princeAtLastLevel = currentLevel == tower.size() - 1;
            if (!princeAtLastLevel) {
                neighbourRoomContent = tower.get(currentLevel + 1)[currentLength][currentWidth];
                neighbourCoordinates = (currentLevel + 1) + " " + currentLength + " " + currentWidth;
                if (checkRoom(neighbourRoomContent) && !roomVisited(neighbourCoordinates)) {
                    if (neighbourRoomContent.equals("2")) {
                        minCountSteps = howFarFromStart + 1;
                        break;
                    } else {
                        String neighbourRoomCoordinates = neighbourCoordinates + " " + (howFarFromStart + 1);
                        queueRoomsToVisit.add(neighbourRoomCoordinates);
                    }
                }
            }
            // Проверка слева
            if (currentWidth > 0) {
                neighbourRoomContent = tower.get(currentLevel)[currentLength][currentWidth - 1] ;
                neighbourCoordinates = currentLevel + " " + currentLength + " " + (currentWidth - 1);
                if (checkRoom(neighbourRoomContent) && !roomVisited(neighbourCoordinates)) {
                    if (neighbourRoomContent.equals("2")) {
                        minCountSteps = howFarFromStart + 1;
                        break;
                    } else {
                        String neighbourRoomCoordinates = neighbourCoordinates + " " + (howFarFromStart + 1);
                        queueRoomsToVisit.add(neighbourRoomCoordinates);
                    }
                }
            }
            // Проверка справа
            if (currentWidth < roomWidth - 1) {
                neighbourRoomContent = tower.get(currentLevel)[currentLength][currentWidth + 1];
                neighbourCoordinates = currentLevel + " " + currentLength + " " + (currentWidth + 1);
                if (checkRoom(neighbourRoomContent) && !roomVisited(neighbourCoordinates)) {
                    if (neighbourRoomContent.equals("2")) {
                        minCountSteps = howFarFromStart + 1;
                        break;
                    } else {
                        String neighbourRoomCoordinates = neighbourCoordinates + " " + (howFarFromStart + 1);
                        queueRoomsToVisit.add(neighbourRoomCoordinates);
                    }
                }
            }
            // Проверка сверху
            if (currentLength > 0) {
                neighbourRoomContent = tower.get(currentLevel)[currentLength - 1][currentWidth];
                neighbourCoordinates = currentLevel + " " + (currentLength - 1) + " " + currentWidth;
                if (checkRoom(neighbourRoomContent) && !roomVisited(neighbourCoordinates)) {
                    if (neighbourRoomContent.equals("2")) {
                        minCountSteps = howFarFromStart + 1;
                        break;
                    } else {
                        String neighbourRoomCoordinates = neighbourCoordinates + " " + (howFarFromStart + 1);
                        queueRoomsToVisit.add(neighbourRoomCoordinates);
                    }
                }
            }
            // Проверка снизу
            if (currentLength < roomLength - 1) {
                neighbourRoomContent = tower.get(currentLevel)[currentLength + 1][currentWidth];
                neighbourCoordinates = currentLevel + " " + (currentLength + 1) + " " + currentWidth;
                if (checkRoom(neighbourRoomContent) && !roomVisited(neighbourCoordinates)) {
                    if (neighbourRoomContent.equals("2")) {
                        minCountSteps = howFarFromStart + 1;
                        break;
                    } else {
                        String neighbourRoomCoordinates = neighbourCoordinates + " " + (howFarFromStart + 1);
                        queueRoomsToVisit.add(neighbourRoomCoordinates);
                    }
                }
            }
            visitedRooms.add(currentLevel + " " +  currentLength + " " + currentWidth);
            queueRoomsToVisit.remove(0);
        }
        String answer;
        if (minCountSteps * actionTime == 0){
            answer = "The prince got lost and couldn't find the princess...";
        }
        else answer = "Congratulations! The Prince has found the princess! It took " + (minCountSteps * actionTime) + " seconds";
        return answer;
    }

    private boolean roomVisited(String roomCoordinates){
        return visitedRooms.contains(roomCoordinates);
    }

    private boolean checkRoom(String roomContent) {
        return roomContent.equals(".") || roomContent.equals("" +
                "2");
    }

    private String[] findRoomInLevel(String[][] level, String roomContent){
        for(int i = 0; i < level.length; i++){
            for(int j = 0; j < level[i].length; j++){
                if(level[i][j].equals(roomContent)){
                    String[] coordinates = new String[2];
                    coordinates[0] = String.valueOf(i);
                    coordinates[1] = String.valueOf(j);
                    return coordinates;
                }
            }
        }
        return new String[0];
    }
}
