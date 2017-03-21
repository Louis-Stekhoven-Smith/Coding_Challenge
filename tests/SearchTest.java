import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by louie on 18/03/2017.
 */
class SearchTest {

    private String word = "ABC";
    private String notAWord = "BBC";

    private static String[] dictionary = new String[6];
    private Search search = new Search(dictionary);

    private static String[] testSubsetDictionary = new String[3];


    @BeforeAll
    public static void setUp(){
        testSubsetDictionary[0] = "AAA";
        testSubsetDictionary[1] = "ABC";
        testSubsetDictionary[2] = "A";

        dictionary[0] = "AAA";
        dictionary[1] = "BBB";
        dictionary[2] = "CCC";
        dictionary[3] = "ABC";
        dictionary[4] = "B";
        dictionary[5] = "A";
    }

    @Test
    void searchForAWord(){
        assertEquals(true,search.forWord(word));
    }

    @Test
    void searchForNonWord(){
        assertEquals(false,search.forWord(notAWord));
    }
    
    @Test
    void OutOfBoundsPositiongetWordsThatMatch(){
        String[] dictionarySubset;
        char input = 'A';

        dictionarySubset = search.getWordsThatMatch(input,3);
        assertArrayEquals(null,dictionarySubset);
    }

    @Test
    void getWordsThatMatch(){
        String[] dictionarySubset;
        char input = 'A';

        dictionarySubset = search.getWordsThatMatch(input,0);
        assertArrayEquals(testSubsetDictionary,dictionarySubset);
    }
    @Test void checkSearchNotCaseSensitive(){
        String[] dictionarySubset;
        char input = 'a';

        dictionarySubset = search.getWordsThatMatch(input,0);
        assertArrayEquals(testSubsetDictionary,dictionarySubset);
    }

    @Test void searchForWordThatStartsWithCharThatDoesNotExist(){
        String[] dictionarySubset;
        char input = 'K';

        dictionarySubset = search.getWordsThatMatch(input,0);
        assertEquals(null,dictionarySubset);
    }



}