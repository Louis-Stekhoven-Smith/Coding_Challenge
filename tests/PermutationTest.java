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
    private static String[] dictionary = new String[10];
    private String remainingInput = "22";
    private ArrayList<String> emptyList = new ArrayList<>();
    private static MockDictionary mockDictionary = new MockDictionary();

    @BeforeAll
    public static void setUp() {
        ArrayList<String> emptyList = new ArrayList<>();
        dictionary = mockDictionary.getDictionary();
        Dictionary.load("Dictionary.txt");
    }

    @Test
    void permutationStillHasWordsThatPartialMatch() {
        permutation = new Permutation("A",
                0,remainingInput, dictionary);
        assertTrue(permutation.hasWordsMatching());
    }

    @Test
    void initialiseClass() {
        permutation = new Permutation("A", 0,
        null, dictionary);
        assertEquals( "A",permutation.getPermutation());
    }

    @Test
    void permutationDoesNotMatchWord() {
        remainingInput = null;
        int position = 2;
        permutation = new Permutation("ABE", 2,
                remainingInput, dictionary);
        assertFalse(permutation.isAWord());
    }

    @Test
    void passInEmptyString() {
        permutation = new Permutation(null,
                0,remainingInput, dictionary);
        assertNull( permutation.getPermutation());
    }

    @Test
    void permutationDoesNotHaveASubDictionary() {
        String[] emptyDic = new String[0];
        permutation = new Permutation("CC", 0,
                remainingInput, emptyDic);
        assertFalse(permutation.hasWordsMatching());
    }

    @Test
    void permutationMatchesWord(){
        remainingInput = null;
        permutation = new Permutation("ABC", 2,
                remainingInput, dictionary);
        assertTrue(permutation.isAWord());
    }

    @Test
    void AMultiWordMatchInput(){
        emptyList.add("GGG");
        emptyList.add("G-I-I");
        emptyList.add("G-I-4");
        emptyList.add("G-4-I");
        permutation = new Permutation("G", 0,
                "44",dictionary);
        assertEquals(emptyList,permutation.getFoundWords());
    }

    @Test
    void contiunesToProcessPermutationsUntilWordFound(){
        permutation = new Permutation("C", 0,
                "22",dictionary);
        assertEquals("CCC",permutation.getFoundWords().get(0));
    }

    @Test
    void InputStringWithLength1(){
        permutation = new Permutation("B", 1,
                null,dictionary);
        assertEquals(emptyList,permutation.getFoundWords());
    }

    @Test
    void ignoresWordsThatDoNotGiveFullEncoding(){
        permutation = new Permutation("D", 1,
                "32",dictionary);
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
        permutation = new Permutation("",
                -1,"222",dictionary);
        assertEquals(expectedResults,permutation.getFoundWords());
    }

}

