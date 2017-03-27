import org.junit.jupiter.api.Test;
import mockup.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by louie on 25/03/2017.
 */
class DictionaryTest {

    private MockDictionary mockDictionary = new MockDictionary();
    private Dictionary dictionary = new Dictionary();

    @Test
    void getDictionaryDefault(){

        dictionary.load("dictionary.txt");
        assertTrue(dictionary.load("dictionary.txt"));
    }

    @Test
    void loadDictionarySuccess(){
        assertTrue(dictionary.load("Dictionary.txt"));
    }

    @Test
    void loadDictionarayFail(){
        assertFalse(dictionary.load("badURL.txt"));
    }

    @Test
    void sanitizedDictionary() {
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("ABC");
        dictionary.load("DirtyInput.txt");
        assertArrayEquals(mockDictionary.getDictionary(), dictionary.getDictionary());

        Permutation permutation = new Permutation("ABC", 2,
                null, dictionary.getDictionary());
        assertEquals(expectedResults, permutation.getFoundWords());
    }

    @Test
    void fileLoadedEmpty(){
        dictionary.load("Empty.txt");
        assertFalse(dictionary.load("Empty.txt"));
    }


}