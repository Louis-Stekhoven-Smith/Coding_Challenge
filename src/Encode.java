/**Encode class
 * This class reads in a numeric number and encodes it
 * Created by louie on 19/03/2017. */
public class Encode {

    /**Returns the characters that match the input */
    public static char[] getPossibleKeys(char charInput){

        int intInput;
        String code;

        if( charInput == '\u0000'){
            System.out.println("char input was null" );
            return null;
        }
        intInput = Character.getNumericValue(charInput);

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
                return null;
        }

    }

    /** Encodes a given number into its possible characters
     * returns array of said characters  */
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
