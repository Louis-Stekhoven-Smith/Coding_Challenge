import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by louie on 18/03/2017.
 */
public class Main {

    public static void main(String [] args){


        String input;

        String[] dictionary = new String[9];
        dictionary[0] = "AAA";
        dictionary[1] = "BBB";
        dictionary[2] = "CCC";
        dictionary[3] = "ABC";
        dictionary[4] = "B";
        dictionary[5] = "A";
        dictionary[7] ="CALL";
        dictionary[8] ="ME";
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
