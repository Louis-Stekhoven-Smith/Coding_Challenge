import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by louie on 18/03/2017.
 */
public class Main {

    public static void main(String [] args){


        String input;

        String[] dictionary = new String[12];
        dictionary[0] = "AAA";
        dictionary[1] = "BBB";
        dictionary[2] = "CCC";
        dictionary[3] = "ABC";
        dictionary[3] = "BCC";
        dictionary[4] = "F";
        dictionary[5] = "DD";
        dictionary[6] = "G";
        dictionary[7] = "HH";
        dictionary[8] = "GGG";
        dictionary[9] ="CALL";
        dictionary[10] ="ME";
        Search search = new Search(dictionary);


        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();

        Permutation permutation = new Permutation("",-1,-1,input,dictionary);
        scan.close();

        ArrayList<String> foundWords;
        foundWords = permutation.getFoundWords();

        for (int i = 0; i < foundWords.size(); i++){
            System.out.println("Possible compination "+foundWords.get(i));
        }

    }

}
