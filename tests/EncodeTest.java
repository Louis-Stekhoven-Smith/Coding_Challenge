import mockup.MockEncode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by louie on 19/03/2017.
 */
class EncodeTest {
    
    private Encode encode = new Encode();

    @Test
    void correctlyEncodeNumber(){
        String[] possibleKeys;
        possibleKeys = encode.getPossibleKeys("9");
        assertEquals("X", possibleKeys[1]);

        possibleKeys = encode.getPossibleKeys("2");
        assertEquals("C", possibleKeys[2]);
    }


    @Test
    void correctlyReturnsNullForUnknownNumber() {
        String[] possibleKeys;
        possibleKeys = encode.getPossibleKeys("10");
        assertEquals(null,possibleKeys);

        possibleKeys = encode.getPossibleKeys("A");
        assertEquals(null,possibleKeys);

    }

    @Test
    void correctlyReturnsNullForNoInput(){
        String[] possibleKeys;
        possibleKeys = encode.getPossibleKeys("");
        assertEquals(null,possibleKeys);

    }

}