import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by louie on 22/03/2017.
 */
class PermutationTest {

    private Permutation permutation;

    @Test
    void initiliseClass(){
        String remainingInput = "2231";
        int currentPosition = 1;
        permutation = new Permutation("A",currentPosition,remainingInput);
        assertEquals(permutation.getPermutation(),"A");


    }

    @Test
    void passInProcedingChars(){
        String remainingInput = "1";
        int currentPosition = 3;
        permutation = new Permutation("ABE",currentPosition,remainingInput);
        assertEquals("ABE",permutation.getPermutation());
    }

    @Test
    void finalNumberBeingRead(){

    }

    @Test
    void noWordsMatchCurrentPermutation(){

    }

    @Test
    void wordMatchesCurrentPermutation(){

    }

}