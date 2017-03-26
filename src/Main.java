/**1800-Coding-Chalange
 * Auther: louie on 18/03/2017
 * Date: 27/03/2017
 * Purpose: This program reads in numbers and finds a combination of words
 * that can be used to encode that number e.g 225563 = CALLME
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static String dictionaryFilePath =  "Dictionary.txt";
    final static String operatingSystem = System.getProperty("os.name");

    public static void main(String[] args) {
        int selection;
        boolean quit = false;

        if (args.length > 0 && args[0].equals("-d")){
            dictionaryFilePath = args[1];
        }

        /** Load default dictionary */
        if(!Dictionary.load(dictionaryFilePath)){
            System.out.println("Check your file path and try again.");
        }
        else {
            while (true) {
                printMenu();
                selection = getMenuInput();

                switch (selection) {
                    case 1:
                        selectFileForMatching();
                        break;

                    case 2:
                        enterStringForMatching();
                        break;

                    case 3:
                        quit = true;
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
                if (quit) {
                    scanner.close();
                    break;
                }
            }
        }

    }
    /** Prints menu */
    private static void printMenu() {
        System.out.println();
        System.out.println("*****************1800-Coding-Challenge ****************** ");
        System.out.println("Author: Louis Stekhoven-Smith");
        System.out.println();
        System.out.println();
        System.out.println("------------------------ Menu --------------------------- ");
        System.out.println("1: Select file for matching ");
        System.out.println("2: Enter string for matching ");
        System.out.println("3 : Quit");
        System.out.println();
        System.out.print("Option: ");
    }

    /** gets selection from user */
    private static int getMenuInput() {
        String rawInput;
        char menuInput;

        rawInput = scanner.nextLine();
        if(rawInput.isEmpty()){
            menuInput = 'x';
        }else{
            menuInput = rawInput.charAt(0);
        }
        return Character.getNumericValue(menuInput);
    }

    /** Gets number to search from user */
    private static void enterStringForMatching() {
        String []inputs = new String[1];
        String rawInput;

        System.out.print("Enter number: ");
        rawInput = scanner.nextLine();
        rawInput = rawInput.replaceAll("[^0-9]","");
        if(!rawInput.isEmpty()){
            inputs[0] = rawInput;
            searchForMatches(inputs);
        }
    }

    /** Finds all matches */
    private static void searchForMatches(String[] inputs) {
        String number;

        for(int i = 0; i < inputs.length; i++){
            number = inputs[i];
            Permutation permutation = new Permutation("",
                    -1,number,Dictionary.getDictionary());
            displayMatches(permutation,number);
        }
    }

    /**Displays matches */
    private static void displayMatches(Permutation permutation,String number) {
        ArrayList<String> foundWords;

        foundWords = permutation.getFoundWords();
        if(!foundWords.isEmpty()){
            System.out.println("Matching words for input "+number+".");
            System.out.println(foundWords);
            System.out.println();
        }
    }

    /** Gets file path from users to load file for use in matching */
    private static void selectFileForMatching() {
        String filePath;
        ArrayList<String> input = new ArrayList<>();

        System.out.println("Enter file path");
        filePath = scanner.nextLine();

        if(filePath == null) {
                /*do nothing*/
        }
        try {
            Scanner scanFile = new Scanner(new File(filePath));

            while (scanFile.hasNext()) {
                input.add(scanFile.nextLine().replaceAll("[^0-9]",""));
            }
            scanFile.close();

            if (input.isEmpty()) {
                System.out.println("File did not contain any words");
            } else {
                System.out.println("File loaded, searching for matches...");
                searchForMatches(input.toArray(new String[input.size()]));
            }
            System.out.println("Hit any key to return to menu.");
            scanner.nextLine();
        }
        catch (Exception e) {
            System.out.println("File does not exist: "+filePath);
        }
    }
}

