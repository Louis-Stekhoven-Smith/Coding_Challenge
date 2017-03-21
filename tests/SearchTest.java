import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
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
    private static String[] testDictionary = new String[3];


    @BeforeAll
    public static void setUp(){
        testDictionary[0] = "aaa";
        testDictionary[1] = "abc";
        testDictionary[2] = "a";
    }

    @Test
    void searchForAWord(){
        assertEquals(true,search.forWord(word));
    }

    @Test
    void searchForNonWord(){
        assertEquals(false,search.forWord(notAWord));
    }
    
    @Test void searchForAllWordsThatBeginWithInputChar(){
        String[] dictionarySubset;
        char input = 'a';

        dictionarySubset = search.getWordsThatStartWith(input);
        assertArrayEquals(testDictionary,dictionarySubset);
    }

    @Test void searchForWordThatDoesNotExist(){
        String[] dictionarySubset;
        char input = 'k';
        
        dictionarySubset = search.getWordsThatStartWith(input);
        assertEquals(null,dictionarySubset);
    }

}