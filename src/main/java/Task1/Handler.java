package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Handler {
    private List<String> initList;
    private List<String> tempList;

    public Handler(String words) {
        initList = new ArrayList<>(Arrays.asList(words.split(" ")));
        tempList = new ArrayList<>(Arrays.asList(words.split(" ")));
    }

    public void removeCFromText() {
        Boolean someWordChanged = false;
        for (int i = 0; i < tempList.size(); i++) {
            String word = tempList.get(i);
            if (word.matches("(\\w*)ci(\\w*)")) {
                tempList.set(i, word.replaceFirst("ci", "si"));
                someWordChanged = true;
            } else if (word.matches("(\\w*)ce(\\w*)")) {
                tempList.set(i, word.replaceFirst("ce", "se"));
                someWordChanged = true;
            } else if (word.matches("(\\w*)ck(\\w*)")) {
                tempList.set(i, word.replaceFirst("ck", "k"));
                someWordChanged = true;
            } else if (word.matches("(\\w*)c(\\w*)")) {
                tempList.set(i, word.replaceFirst("c", "k"));
                someWordChanged = true;
            }

            if (someWordChanged) {
                removeCFromText();
            }
        }
    }

    public void removeDoubleLetter() {
        Boolean someWordChanged = false;
        for (int i = 0; i < tempList.size(); i++) {
            String word = tempList.get(i);

            if (word.matches("(\\w*)ee(\\w*)")) {
                tempList.set(i, word.replaceFirst("ee", "i"));
                someWordChanged = true;
            } else if (word.matches("(\\w*)oo(\\w*)")) {
                tempList.set(i, word.replaceFirst("oo", "u"));
                someWordChanged = true;
            }

            Pattern pattern = Pattern.compile("([^o|e])\\1");
            Matcher matcher = pattern.matcher(word);
            while (matcher.find()) {
                String x = matcher.group().substring(1);
                tempList.set(i, word.replaceFirst("([^o|e])\\1", x));
                someWordChanged = true;
            }

            if (someWordChanged) {
                removeDoubleLetter();
            }
        }
    }

    public void removeEAtTheEnd() {
        Boolean someWordChanged = false;
        for (int i = 0; i < tempList.size(); i++) {
            String word = tempList.get(i);
            if (word.matches("(.*)e$")) {
                tempList.set(i, word.replaceFirst("e$", ""));
                someWordChanged = true;
            }
        }
        if (someWordChanged) {
            removeEAtTheEnd();
        }
    }

    public void removeArticles(){
        int listSize = initList.size();
        for (int i = 0; i < listSize; i++) {
            if (initList.get(i).equalsIgnoreCase("a") ||
                initList.get(i).equalsIgnoreCase("an") ||
                initList.get(i).equalsIgnoreCase("the"))
            {
                tempList.set(i, "");
            }
        }
    }

    public String getResult() {
        String result = "";
        for (int wordIndex = 0; wordIndex < tempList.size(); wordIndex++) {
            if (tempList.get(wordIndex).length() > 0) {
                result += tempList.get(wordIndex) + " ";
            }
        }

        return result.trim();
    }
}