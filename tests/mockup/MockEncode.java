package mockup;

/**
 * Created by louie on 19/03/2017.
 */
public class MockEncode {
    private String[] possibleKeysForOne = new String[3];
    private String[] possibleKeysForTwo = new String[3];
    private String[] possibleKeysForThree = new String[3];

    public MockEncode(){
        possibleKeysForOne[0] = "A";
        possibleKeysForOne[0] = "B";
        possibleKeysForOne[0] = "C";

        possibleKeysForTwo[0] = "D";
        possibleKeysForTwo[0] = "E";
        possibleKeysForTwo[0] = "F";

        possibleKeysForThree[0] = "G";
        possibleKeysForThree[0] = "H";
        possibleKeysForThree[0] = "I";
    }

    /** getters */
    public String[] getPossibleKeysForOne() {
        return possibleKeysForOne;
    }
    public String[] getPossibleKeysForTwo() {
        return possibleKeysForTwo;
    }
    public String[] getPossibleKeysForThree() {
        return possibleKeysForThree;
    }
}
