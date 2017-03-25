import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by louie on 18/03/2017.
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static String dictionaryFilePath = null;

    public static void main(String[] args) {

        char menuInput;
        int selection;
        boolean quit = false;

        /** Load default dictionary */
        Dictionary.load(dictionaryFilePath);

        while (true) {
            System.out.println("*****************1800-Coding-Challenge ****************** ");
            System.out.println("Author: Louis Stekhoven-Smith");
            System.out.println("                           ");
            System.out.println("------------------------Menu----------------------------- ");
            System.out.println("1: Select file for matching ");
            System.out.println("2: Enter string for matching ");
            System.out.println("3: Select dictionary to use in matching");
            System.out.println("4: Add word to dictionary");
            System.out.println("5: Quit");
            System.out.print("Option: ");

            menuInput = scanner.nextLine().charAt(0);
            /* bug if user hits enter */
            selection = Character.getNumericValue(menuInput);

            switch (selection) {
                case 1: selectFileForMatching();
                    break;

                case 2: enterStringForMatching();
                    break;

                case 3: selectDictionary();
                    break;

                case 4: addWordToDictionary();
                    break;

                case 5: quit = true;
                    break;

                default:
                    System.out.println("Invalid option " + selection);
            }
            if (quit) {
                scanner.close();
                break;
            }
        }
    }


    private static void addWordToDictionary() {
    }

    private static void selectDictionary() {
        System.out.print("Enter file path: ");
        dictionaryFilePath = scanner.nextLine();
        Dictionary.load(dictionaryFilePath);

    }

    private static void enterStringForMatching() {
        String []inputs = new String[1];
        inputs[0] = scanner.nextLine();
        searchForMatches(inputs);
    }

    private static void searchForMatches(String[] inputs) {
        String number;

        for(int i = 0; i < inputs.length; i++){
            System.out.println("adding");
            number = inputs[i];
            System.out.println(number);
            Permutation permutation = new Permutation("",-1,
                    -1,number,Dictionary.getDictionary());
            displayMatches(permutation);
        }
    }

    private static void displayMatches(Permutation permutation) {
        ArrayList<String> foundWords;
        foundWords = permutation.getFoundWords();
        for (int i = 0; i < foundWords.size(); i++){
            System.out.println("Possible combinations "+foundWords.get(i));
        }
    }

    /*TODO change the input to comandline arg */
    private static void selectFileForMatching() {
        String filePath;
        ArrayList<String> input = new ArrayList<>();
        int i = 0;

        System.out.println("Enter file path");
        filePath = scanner.nextLine();

            if(filePath == null) {
                /*do nothing*/
            }
            try {
                Scanner scanFile = new Scanner(new File(filePath));

                while (scanFile.hasNext()) {
                    i++;

                    input.add(scanFile.nextLine());
                }
                scanFile.close();

                if (input.isEmpty()) {
                    System.out.println("File did not contain any words");
                } else {
                    System.out.println("File loaded, searching for matches...");
                    searchForMatches(input.toArray(new String[input.size()]));
                }
            }
            catch (Exception e) {
                /*TODO*/
            }
        }
    }

