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
    
    @Test void searchForAllWordsThatBeginWithInputChar(){
        String[] dictionarySubset, testDictionary;
        char input = 'a';
        testDictionary = new String[3];
        testDictionary[0] = "aaa";
        testDictionary[1] = "abc";
        testDictionary[2] = "a";
        
        dictionarySubset = search.getWordsThatStartWith(input);
        assertArrayEquals(testDictionary,dictionarySubset);
        
    }

}