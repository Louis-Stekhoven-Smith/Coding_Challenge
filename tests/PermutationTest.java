import mockup.MockDictionary;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by louie on 22/03/2017.
 */
class PermutationTest {

    private Permutation permutation;
    private static String[] dictionary = new String[6];
    private String remainingInput = "2231";
    private int currentPosition = 0;

    @BeforeAll
    public static void setUp() {

        dictionary[0] = "AAA";
        dictionary[1] = "BBB";
        dictionary[2] = "CCC";
        dictionary[3] = "ABC";
        dictionary[4] = "B";
        dictionary[5] = "A";


    }

    @Test
    void permutationStillHasWordsThatPartialMatch() {
        permutation = new Permutation("A", 0, remainingInput, dictionary);
        assertEquals(true, permutation.hasWordsMatching());
    }

    @Test
    void initiliseClass() {
        permutation = new Permutation("A", currentPosition, remainingInput, dictionary);
        assertEquals(permutation.getPermutation(), "A");

    }

    @Test
    void passInProcedingChars() {
        remainingInput = "1";
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

    /*TODO add a check if current permutation matches a word*/
    @Test
    void wordMatchesCurrentPermutation() {

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

