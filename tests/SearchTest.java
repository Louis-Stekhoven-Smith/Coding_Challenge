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
    private static String[] testSubsetDictionary = new String[3];


    @BeforeAll
    public static void setUp(){
        testSubsetDictionary[0] = "aaa";
        testSubsetDictionary[1] = "abc";
        testSubsetDictionary[2] = "a";
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
        assertArrayEquals(testSubsetDictionary,dictionarySubset);
    }

    @Test void searchForWordThatStartsWithCharThatDoesNotExist(){
        String[] dictionarySubset;
        char input = 'k';

        dictionarySubset = search.getWordsThatStartWith(input);
        assertEquals(null,dictionarySubset);
    }



}