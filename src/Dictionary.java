import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
/**
 * Created by louie on 25/03/2017.
 */
public class Dictionary {

    private String defaultFilePath = "Dictionary.txt";
    private String[] theDictionary;

    public Boolean load(String pathFile){
        Scanner scanner;

        /**load default;*/
        if(pathFile == null) {
            ArrayList<String> buildingDictionary = new ArrayList<>();
            try {
              scanner = new Scanner(new File(defaultFilePath));

                while(scanner.hasNext()){
                    String sanitizedInput = scanner.nextLine().replaceAll("[^a-zA-Z]","").toUpperCase();
                    buildingDictionary.add(sanitizedInput);
                }
                scanner.close();

                if(buildingDictionary.isEmpty()){
                    System.out.println("File provided does not contain any words: "+ defaultFilePath);
                    return false;
                }
                theDictionary = buildingDictionary.toArray(new String[buildingDictionary.size()]);
                return true;

            }catch(Exception e){
                System.out.println(e.getMessage());
                return false;
            }

        }else{
            /**load give*/
            return false;
        }
    }

    public String[] getDictionary(){
        return theDictionary;
    }


}
