import org.junit.jupiter.api.Test;
import mockup.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by louie on 18/03/2017.
 */
class SearchTest {

    private String word = "abc";
    private String notAWord = "bbc";
    private MockDictionary dictionary = new MockDictionary();
    private Search search = new Search(dictionary.getDictionary());

    @Test
    void searchForAWord(){
        assertEquals(true,search.forWord(word));
    }

    @Test
    void searchForNonWord(){
        assertEquals(false,search.forWord(notAWord));
    }

}