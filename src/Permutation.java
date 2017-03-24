import java.util.ArrayList;
import java.util.List;

/**
 * Created by louie on 22/03/2017.
 */
public class Permutation {

    private String currentPermutation, remainingInput;
    private String[] subDictionary;
    private int currentPositionInString;
    private Search search;
    private Boolean isAWord = false;
    private Encode encode = new Encode();
    private ArrayList<String> foundWords = new ArrayList<>();
    private static final int nextInputNumber = 0;

    Permutation(String currentPermutation, int currentPositionInString, String remainingInput,
                String[] dictionary) {

        if(currentPermutation == null){
            System.out.print("Null entered as current Permutation - Stopped Search");
        }else{

            this.currentPermutation = currentPermutation;
            this.currentPositionInString = currentPositionInString;
            this.remainingInput = remainingInput;
            this.search = new Search(dictionary);
            this.subDictionary = dictionary;
            generateNewSubDictionary();

            System.out.println(currentPermutation);

            /** No words match permutation stop  */
            if(!hasWordsMatching()){
                /** Do nothing */
            }
            else {
                continueSearch();
            }
        }
    }

    /** Helpers */
    /** Checks if current permutation is a one to one match with string e.g. 2255 = CALL
     * If it is a one to one match or there is no input left to parse then stop search
     * Otherwise continue recursive search*/
    private void continueSearch() {
        if (permutationIsWord() && remainingInput == null) {
            /*System.out.println("This is a test " +currentPermutation);*/
            isAWord = true;
            foundWords.add(currentPermutation);
            System.out.println("Is a word "+currentPermutation);
        }else if (remainingInput == null){
            /** Do nothing */
        }
        /**  Word matches and has more numbers to process in the string*/
        else if (permutationIsWord()) {

            this.currentPermutation += "-";
            /*TODO /**I need to spin up new permutaitons here */
        }
        /** keep searching */
        else{
            recursivePermutations();
        }
    }

    /** Spins up new permutation objects to start checking the next set of permutations */
    private void recursivePermutations() {
        char[] possibleKeys;
        String newRemainingInput;

        /**Get encodings for the next number, and update*/
        possibleKeys = encode.getPossibleKeys(remainingInput.charAt(nextInputNumber));
        newRemainingInput = setRemainingInput();
        currentPositionInString++;

        for(int i = 0; i < possibleKeys.length; i++){
            generateNewPermutation(possibleKeys[i], newRemainingInput);
        }
    }

    /** Removes the leading char in the input string */
    private String setRemainingInput() {
        String newRemainingInput;
        StringBuilder sb;

        sb = new StringBuilder((remainingInput));
        sb.deleteCharAt(0);
        /** No more char left to encode  */
        if (sb.length() == 0) {
            newRemainingInput = null;
        } else {
            newRemainingInput = sb.toString();
        }
        return newRemainingInput;
    }

    /** Creates a new permutation object and checks if it is a word*/
    private void generateNewPermutation(char key, String newRemainingInput) {
        String newPermutation;

        newPermutation = currentPermutation + key;
        Permutation nextPermutation = new Permutation(newPermutation, currentPositionInString, newRemainingInput,
                subDictionary);

        /*TODO - I need to store the output in an arrayList so I can keep all variations avaliable */
        /** Feeding the word back out of the recursive stack*/
        if (nextPermutation.isAWord) {

            foundWords.addAll(nextPermutation.getFoundWords());
            System.out.println("Assing to ArrayList "+foundWords);
            isAWord = true;
        }
    }

    /** Check if permutation is a word */
    private Boolean permutationIsWord(){
        if(currentPermutation == null){
            return false;
        }
        for (int i = 0; i < subDictionary.length; i++){
            if(currentPermutation.equals(subDictionary[i])){
                return true;
            }
        }
        return false;
    }

    /** Narrow down the dictionary so that it only contains words that can  potentially match */
    private void generateNewSubDictionary(){
        char currentChar;
        if(currentPermutation == ""){
            /** do nothing */
        }
        else{
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
    public ArrayList<String> getFoundWords(){
        return foundWords;
    }
    public Boolean isAWord(){
        return isAWord;
    }
    public String getPermutation(){
        return currentPermutation;
    }
    /** redudent */


}
