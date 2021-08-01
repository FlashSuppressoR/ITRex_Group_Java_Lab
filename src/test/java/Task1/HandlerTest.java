package Task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HandlerTest {

    @Test
    void removeCFromText() {
        Handler handler = new Handler("success");
        handler.removeCFromText();
        String handlerResult = handler.getResult();
        String actualResult = "suksess";

        Assertions.assertTrue(handlerResult.equals(actualResult));
    }
    @org.junit.jupiter.api.Test
    void removeDoubleLetter() {
        Handler handler = new Handler("oor");
        handler.removeDoubleLetter();
        String handlerResult = handler.getResult();
        String actualResult = "ur";

        Assertions.assertTrue(handlerResult.equals(actualResult));
    }
    @Test
    void removeEAtTheEnd() {
        Handler handler = new Handler("there");
        handler.removeEAtTheEnd();
        String handlerResult = handler.getResult();
        String actualResult = "ther";

        Assertions.assertTrue(handlerResult.equals(actualResult));
    }
    @Test
    void removeArticles() {
        Handler handler = new Handler("The prince has found the princess");
        handler.removeArticles();
        String handlerResult = handler.getResult();
        String actualResult = "prince has found princess";
        Assertions.assertTrue(actualResult.equals(handlerResult));
    }
}