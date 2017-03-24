import mockup.MockDictionary;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by louie on 22/03/2017.
 */
class PermutationTest {

    private Permutation permutation;
    private static String[] dictionary = new String[9];
    private String remainingInput = "2231";
    private int currentPosition = 0;
    private ArrayList<String> emptyList = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        ArrayList<String> emptyList = new ArrayList<>();
        dictionary[0] = "AAA";
        dictionary[1] = "BBB";
        dictionary[2] = "CCC";
        dictionary[3] = "ABC";
        dictionary[4] = "BCC";
        dictionary[5] = "F";
        dictionary[6] = "DD";
        dictionary[7] = "G";
        dictionary[8] = "HH";


    }

    @Test
    void permutationStillHasWordsThatPartialMatch() {
        permutation = new Permutation("A", 0, remainingInput, dictionary);
        assertEquals(true, permutation.hasWordsMatching());
    }

    @Test
    void initialiseClass() {
        permutation = new Permutation("A", currentPosition, null, dictionary);
        assertEquals( "A",permutation.getPermutation());

    }

    @Test
    void permutationDoesNotMatchWord() {
        remainingInput = null;
        int position = 2;
        permutation = new Permutation("ABE", position, remainingInput, dictionary);
        assertEquals("ABE", permutation.getPermutation());
    }

    @Test
    void passInEmptyString() {
        permutation = new Permutation(null, currentPosition, remainingInput, dictionary);
        assertEquals(null, permutation.getPermutation());
    }

    @Test
    void permutationDoesNotHaveASubDictionary() {
        String[] emptyDic = new String[0];
        permutation = new Permutation("CC", currentPosition, remainingInput, emptyDic);
        assertEquals(false, permutation.hasWordsMatching());
    }

    @Test
    void permutationMatchesWord(){
        remainingInput = null;
        permutation = new Permutation("ABC", 2, remainingInput, dictionary);
        assertEquals(true, permutation.isAWord());
        assertEquals("ABC",permutation.getPermutation());
    }

    @Test
    void permutationAMultiWordMatchInput(){
        permutation = new Permutation("G",0,"44",dictionary);
        assertEquals("G-HH",permutation.getPermutation());
    }

    @Test
    void contiunesToProcessPermutationsUntilWordFound(){
        permutation = new Permutation("C",0,"22",dictionary);
        assertEquals("CCC",permutation.getFoundWords().get(0));
    }

    @Test
    void InputStringWithLength1(){
        permutation = new Permutation("B",0,null,dictionary);
        assertEquals(emptyList,permutation.getFoundWords());
    }

    @Test
    void ignoresWordsThatDoNotGiveFullEncoding(){
        permutation = new Permutation("D",0,"32",dictionary);
        assertEquals(emptyList,permutation.getFoundWords());
    }

    @Test
    void returnMultiWordMatches(){
        ArrayList<String> expectedResults = new ArrayList<>();
        expectedResults.add("AAA");
        expectedResults.add("ABC");
        expectedResults.add("BBB");
        expectedResults.add("BCC");
        expectedResults.add("CCC");
        permutation = new Permutation("",-1,"222",dictionary);
        assertEquals(expectedResults,permutation.getFoundWords());
    }

}

    /*TODO add a check if current permutation does not match a word*/


    /*TODO*/
    /** if permutation has a subdic then move to next postion in string and create new permutations
     * if has word match, move to next postion as create two sets of new permutations one to contiunie with leading chars
     * and new one starting from postioin 0 *
     *
     * If words match need to store them and keep track of what words proceed them if any
     */

