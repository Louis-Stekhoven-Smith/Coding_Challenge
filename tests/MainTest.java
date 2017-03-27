/**
 * Created by louie on 27/03/2017.
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class MainTest {


    private int input;
    private String[] inputArray, testArray = new String[1];

    @BeforeEach
    void setup(){
        testArray[0] = "0423457368";
    }

    @Test
    void getMenuInput(){
        input = Main.getMenuInput("5");
        assertEquals(5,input);
    }

    @Test
    void getMenuInputNullEntered(){
        input = Main.getMenuInput(null);
        assertEquals(33, input);
    }

    @Test
    void enterStringForMatching(){
        inputArray = Main.enterStringForMatching("0423457368");
        assertArrayEquals(testArray, inputArray);
    }

    @Test
    void enterStringForMatchingNullGiven(){
        assertNull(Main.enterStringForMatching(null));
    }

    @Test
    void  selectFileForMatching(){
        inputArray = Main.selectFileForMatching("testInput.txt");
        assertArrayEquals(testArray,inputArray);
    }

    @Test
    void  selectFileForMatching_FileDoesNotExist(){
        inputArray = Main.selectFileForMatching("badInput.txt");
        assertNull(inputArray);
    }

}
