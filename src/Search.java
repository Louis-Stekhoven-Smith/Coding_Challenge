/**
 * Created by louie on 18/03/2017.
 */
public class Search {

    private String[] dictionary;

    public Search(String[] dictionary){

        this.dictionary = new String[dictionary.length];
        System.arraycopy(dictionary, 0, this.dictionary, 0, dictionary.length );
    }

    public Boolean forWord(String word) {

        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].equals(word)) {
                return true;
            }
        }
        return false;
    }

}
