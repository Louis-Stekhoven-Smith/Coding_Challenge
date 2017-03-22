import java.util.ArrayList;

/**
 * Created by louie on 18/03/2017.
 */
public class Search {

    private String[] dictionary;

    public Search(String[] dictionary) {
        this.dictionary = dictionary;
    }

    /** checks string for complete match with a word */
    public Boolean forWord(String word) {
        word = word.toUpperCase();
        for (int i = 0; i < dictionary.length; i++) {
            if (word.equals(dictionary[i])) {
                return true;
            }
        }
        return false;
    }

    /** Returns a subset of words that have a matching char in the given postion of the string */
    public String[] getWordsThatMatch(char input, int position) {
        ArrayList<String> matchedWords = new ArrayList<>();
        input = Character.toUpperCase(input);

        for (int i = 0; i < dictionary.length; i++) {
            try {
                if (dictionary[i].charAt(position) == input) {
                    matchedWords.add(dictionary[i]);
                }
            }
            catch(Exception e){
                    System.out.println("getWordsThatMatch " + e.getMessage());
                }
        }
        if (noWordsFound(matchedWords)) {
            return null;
        } else {
            return matchedWords.toArray(new String[matchedWords.size()]);
        }
    }

    /**helpers */
    private Boolean noWordsFound(ArrayList<String> matchedWords) {
        if (matchedWords.size() < 1) {
            System.out.println();
            return true;
        }
        return false;
    }
}
