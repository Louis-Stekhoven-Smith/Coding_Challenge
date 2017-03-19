import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by louie on 19/03/2017.
 */
class EncodeTest {

    private Encode encode = new Encode();

    @Test
    void correctlyEncodeNumber(){
        char[] possibleKeys;
        possibleKeys = encode.getPossibleKeys('2');
        assertEquals('B', possibleKeys[1]);

        possibleKeys = encode.getPossibleKeys('9');
        assertEquals('Z', possibleKeys[3]);
    }


    @Test
    void correctlyReturnsNullForUnknownNumber() {
        char[] possibleKeys;
        possibleKeys = encode.getPossibleKeys('a');
        assertEquals(null,possibleKeys);

        possibleKeys = encode.getPossibleKeys('$');
        assertEquals(null,possibleKeys);
    }

    @Test
    void correctlyReturnsNullForNoInput(){
        char[] possibleKeys;
        Character nullChar = '\u0000';

        possibleKeys = encode.getPossibleKeys(nullChar);
        assertEquals(null,possibleKeys);

    }

}