import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by louie on 18/03/2017.
 */
public class Search {

    private String[] dictionary;

    public Search(String[] dictionary){

        this.dictionary = new String[dictionary.length];
        System.arraycopy(dictionary, 0, this.dictionary, 0, dictionary.length );
    }

    /** checks string for complete match with a word*/
    public Boolean forWord(String word) {

        for (int i = 0; i < dictionary.length; i++) {
            if (word.equals(dictionary[i])) {
                return true;
            }
        }
        return false;
    }

    public String[] getWordsThatStartWith(char input){
        ArrayList<String> matchedWords = new ArrayList<String>();

        for(int i  = 0; i < dictionary.length; i++){
            if(dictionary[i].charAt(0) == input){
                matchedWords.add(dictionary[i]);
            }
        }
        /*TODO*/
        /** need to write rest of code to pass test */
        return null;

    }

}
