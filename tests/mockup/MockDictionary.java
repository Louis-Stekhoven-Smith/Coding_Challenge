package mockup;

/**
 * Created by louie on 19/03/2017.
 */
public class MockDictionary {

    private static String[] dictionary;


    public MockDictionary() {
        dictionary = new String[10];
        dictionary[0] = "AAA";
        dictionary[1] = "BBB";
        dictionary[2] = "CCC";
        dictionary[3] = "ABC";
        dictionary[4] = "BCC";
        dictionary[5] = "F";
        dictionary[6] = "DD";
        dictionary[7] = "G";
        dictionary[8] = "HH";
        dictionary[9] = "GGG";

    }
    public static String[] getDictionary(){
            return dictionary;
    }
}
