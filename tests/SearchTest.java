import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by louie on 18/03/2017.
 */
class SearchTest {

    private String word = "abc";
    private String notAWord = "bbc";
    private Search search = new Search(createDtionary());


    private String[] createDtionary(){
        String[] dictionary = new String[6];
        dictionary[0] = "aaa";
        dictionary[1] = "bbb";
        dictionary[2] = "ccc";
        dictionary[3] = "abc";
        dictionary[4] = "b";
        dictionary[5] = "a";

        return dictionary;
    }



    @Test
    void searchForAWord(){
        assertEquals(true,search.forWord(word));
    }

    @Test
    void searchForNonWord(){
        assertEquals(false,search.forWord(notAWord));
    }

}