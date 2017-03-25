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
        dictionary.load(null);
        assertArrayEquals(mockDictionary.getDictionary(),dictionary.getDictionary());
    }

    @Test
    void loadDictionarySuccess(){
        assertEquals(true,dictionary.load(null));
    }

    @Test
    void loadDictionarayFail(){
        assertEquals(false,dictionary.load("badURL.txt"));
    }

    @Test
    void removesWhiteSpace(){

    }

    @Test
    void removesPuntioation(){

    }

    @Test
    void fileLoadedEmpty(){

    }


}