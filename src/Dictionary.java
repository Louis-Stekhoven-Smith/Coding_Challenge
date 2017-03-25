import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
/**
 * Created by louie on 25/03/2017.
 */
public class Dictionary {

    private static String defaultFilePath = "Dictionary.txt";
    private static String[] theDictionary;

    /** Loads file into array */
    public static Boolean load(String filePath){

        /**load default;*/
        if(filePath == null) {
            filePath = defaultFilePath;
        }
        if(readInFile(filePath)){
            return true;

        }
        return false;
    }

    /** Attempts to read in a file from the given fil path*/
    private static Boolean readInFile(String filePath) {
        Scanner scanner;
        ArrayList<String> buildingDictionary = new ArrayList<>();

        try {
          scanner = new Scanner(new File(filePath));

            while(scanner.hasNext()){
                String sanitizedInput = scanner.nextLine().replaceAll("[^a-zA-Z]","").toUpperCase();
                buildingDictionary.add(sanitizedInput);
            }
            scanner.close();

            if(buildingDictionary.isEmpty()){
                System.out.println("File provided does not contain any words: "+ filePath);
                return false;
            }
            theDictionary = buildingDictionary.toArray(new String[buildingDictionary.size()]);
            return true;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /** Getters */
    public static String[] getDictionary(){
        return theDictionary;
    }


}
