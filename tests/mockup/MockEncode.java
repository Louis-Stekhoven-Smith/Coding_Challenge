package mockup;

/**
 * Created by louie on 19/03/2017.
 */
public class MockEncode {
    private String[] possibleKeysForOne = new String[3];
    private String[] possibleKeysForTwo = new String[3];
    private String[] possibleKeysForThree = new String[3];

    public MockEncode(){
        possibleKeysForOne[0] = "a";
        possibleKeysForOne[0] = "b";
        possibleKeysForOne[0] = "c";

        possibleKeysForTwo[0] = "d";
        possibleKeysForTwo[0] = "e";
        possibleKeysForTwo[0] = "f";

        possibleKeysForThree[0] = "g";
        possibleKeysForThree[0] = "h";
        possibleKeysForThree[0] = "i";
    }

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
