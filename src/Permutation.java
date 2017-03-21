

/**
 * Created by louie on 22/03/2017.
 */

/*TODO - Need to refactor this class*/
public class Permutation {

    private String currentPermutation;
    private String[] subDictionary;
    private int currentPositionInString;
    private String remainingInput;
    private Search search;

    Permutation(String currentPermutation, int currentPositionInString, String remainingInput,
                String[] dictionary) {

        this.currentPermutation = currentPermutation;
        this.currentPositionInString = currentPositionInString;
        this.remainingInput = remainingInput;
        this.search = new Search(dictionary);

        generateNewSubDictionary();
    }

    /** Helpers */

    /** narrow down the dictionary so that it only contains words that can  potentially match */
    private void generateNewSubDictionary(){
        char currentChar;
        if(currentPermutation == null){
            /** do nothing */
        }
        else {
            currentChar = currentPermutation.charAt(currentPositionInString);
            subDictionary = search.getWordsThatMatch(currentChar, currentPositionInString);
            search = new Search(subDictionary);
        }
    }

    /** Getters */
    public Boolean hasWordsMatching(){
        if(subDictionary == null){
            return false;
        }
        else return true;
    }

    public String getPermutation(){
        return currentPermutation;
    }


}
