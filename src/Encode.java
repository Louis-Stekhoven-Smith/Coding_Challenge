/**
 * Created by louie on 19/03/2017.
 */
public class Encode {

    private String[] possibleKeys3 = new String[3];
    private String[] possibleKeys4 = new String[4];

    public Encode(){

    }

    public String[] getPossibleKeys(String charInput){


        if (charInput.equals("2")){

            possibleKeys3[0] = "A";
            possibleKeys3[1] = "B";
            possibleKeys3[2] = "C";

            return possibleKeys3;

        }
        else if (charInput.equals("3")){

            possibleKeys3[0] = "D";
            possibleKeys3[1] = "E";
            possibleKeys3[2] = "F";

            return possibleKeys3;

        }
        else if (charInput.equals("4")){

            possibleKeys3[0] = "G";
            possibleKeys3[1] = "H";
            possibleKeys3[2] = "I";

            return possibleKeys3;

        }
        else if (charInput.equals("5")){

            possibleKeys3[0] = "J";
            possibleKeys3[1] = "K";
            possibleKeys3[2] = "L";

            return possibleKeys3;

        }
        else if (charInput.equals("6")){

            possibleKeys3[0] = "M";
            possibleKeys3[1] = "N";
            possibleKeys3[2] = "O";

            return possibleKeys3;

        }
        else if (charInput.equals("7")){

            possibleKeys4[0] = "P";
            possibleKeys4[1] = "Q";
            possibleKeys4[2] = "R";
            possibleKeys4[3] = "S";

            return possibleKeys4;

        }
        else if (charInput.equals("8")){

            possibleKeys3[0] = "T";
            possibleKeys3[1] = "U";
            possibleKeys3[2] = "V";

            return possibleKeys3;

        }
        else if (charInput.equals("9")){

            possibleKeys4[0] = "W";
            possibleKeys4[1] = "X";
            possibleKeys4[2] = "Y";
            possibleKeys4[3] = "Z";

            return possibleKeys4;

        }
        else {
            System.out.println("no encoding found for input char " + charInput);
            return null;
        }

    }


}
