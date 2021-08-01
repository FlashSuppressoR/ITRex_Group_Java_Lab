package Task1;

// Input example: cacao and coffee success me oop ppo per pere peere peerree the an the

public class Runner {
    public static void main(String[] args){
        Reader reader = new Reader();
        String words = reader.readFromConsole();
        Handler handler = new Handler(words);

        handler.removeCFromText();
        handler.removeDoubleLetter();
        handler.removeEAtTheEnd();
        handler.removeArticles();

        System.out.println("Result: " + handler.getResult());
    }
}
