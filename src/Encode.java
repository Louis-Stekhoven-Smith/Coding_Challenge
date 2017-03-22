
/**
 * Created by louie on 19/03/2017.
 */
public class Encode {

    private String[] possibleKeys3 = new String[3];
    private String[] possibleKeys4 = new String[4];

    public Encode(){

    }

    /** returns the charaters that match the input */
    public static char[] getPossibleKeys(char charInput){

        int intInput;
        String code;

        if( charInput == '\u0000'){
            System.out.println("char input was null" );
            return null;
        }
        intInput = Character.getNumericValue(charInput);

        System.out.println(intInput);
        switch(intInput){
            case 2: code = "ABC";
                return possibleKeys(code);

            case 3: code = "DEF";
                return possibleKeys(code);

            case 4: code = "GHI";
                return possibleKeys(code);

            case 5: code = "JKL";
                return possibleKeys(code);

            case 6: code = "MNO";
                return possibleKeys(code);

            case 7: code = "PQRS";
                return possibleKeys(code);

            case 8: code = "IUV";
                return possibleKeys(code);

            case 9: code = "WXYZ";
                return possibleKeys(code);

            default:
                System.out.println("no encoding found for input char " + charInput);
                return null;
        }

    }

    /** Helpers */
    private static char[] possibleKeys(String code){

        char[] keys;
        int size = code.length();
        keys = new char[size];

        for (int i=0; i<size; i++) {
            keys[i] = code.charAt(i);
        }
        return keys;
    }

}
