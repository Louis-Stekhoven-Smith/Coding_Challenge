/**Permutation Class
 *This class generates each permutation the input number can
 * be encoded too. It recursively calls its self to add an extra
 * digit to the permutation at a time. If no words are found to be matching
 * the permutation the recursive call breaks out.
 * Created by louie on 22/03/2017.
 */
import java.util.ArrayList;
public class Permutation {

    private String currentPermutation, remainingInput;
    private String[] subDictionary;
    private int numberOfCharsProceeding;
    private Search search;
    private Boolean isAWord = false;
    private Encode encode = new Encode();
    private ArrayList<String> foundWords = new ArrayList<>();
    private static final int nextInputNumber = 0;
    private char currentDigit;


    Permutation(String currentPermutation, int numberOfCharsProceeding, String remainingInput,
                String[] dictionary) {

        if(currentPermutation == null){
            System.out.println("No input given - Stopped Search");
        }else{
            updateData(currentPermutation, numberOfCharsProceeding, remainingInput, dictionary);
            generateNewSubDictionary();

            if(!hasWordsMatching()){
            }
            else {
                continueSearch();
            }
        }
    }

    /** Update objects private vars */
    private void updateData(String currentPermutation, int numberOfCharsProceeding,
                            String remainingInput, String[] dictionary) {
        this.currentPermutation = currentPermutation;
        this.remainingInput = remainingInput;
        this.search = new Search(dictionary);
        this.subDictionary = dictionary;
        this.numberOfCharsProceeding = numberOfCharsProceeding;
    }

    /** Helpers
     /** Checks if current permutation is a one to one match with string e.g. 2255 = CALL
     * If it is a one to one match or there is no input left to parse then stop search
     * Otherwise continue recursive search*/
    private void continueSearch() {

        if ((permutationIsWord())&& remainingInput == null) {
            addPermutationToMatches();
        }else if (remainingInput == null){
        }
        else if (permutationIsWord()) {

            /** Ignore match and keep searching for larger words */
            recursivePermutations();

            /** Search for multi word match */
            resetSearchParameters();
            currentPermutation += "-";
            recursivePermutations();

            addDigitAfterWordSearchAgain();
        }
        /** Keep searching */
        else{
            recursivePermutations();
            addLeadingDigitAndSearchAgain();
        }
    }

    /** Spins up new permutation objects to start checking the next set of permutations */
    private void recursivePermutations() {
        char[] possibleKeys;
        String newRemainingInput;

        /**Get encodings for the next number, and update*/
        currentDigit = remainingInput.charAt(nextInputNumber);
        possibleKeys = Encode.getPossibleKeys(currentDigit);

        if(possibleKeys != null) {
            newRemainingInput = updateRemainingInput();
            numberOfCharsProceeding++;

            for (int i = 0; i < possibleKeys.length; i++) {
                generateNewPermutation(possibleKeys[i], newRemainingInput);
            }
        }
    }

    /** Creates a new permutation of length currentPermutation+1 and checks if it is a word*/
    private void generateNewPermutation(char key, String newRemainingInput) {
        String newPermutation;

        newPermutation = currentPermutation + key;
        Permutation nextPermutation = new Permutation(newPermutation, numberOfCharsProceeding, newRemainingInput,
                subDictionary);

        /** Feeding the word back out of the recursive stack*/
        if (nextPermutation.isAWord) {
            foundWords.addAll(nextPermutation.getFoundWords());
            isAWord = true;
        }
    }

    /** Allows for a digit at the start of the number */
    private void addLeadingDigitAndSearchAgain() {
        remainingInput = updateRemainingInput();
        if(remainingInput == null) {
            /* Do nothing only one digit was given */
        }else {
            if (currentPermutation.equals("")) {
                currentPermutation += currentDigit + "-";
                resetSearchParameters();
                recursivePermutations();
            }
        }
    }

    /** Allows for a digit to be between words */
    private void addDigitAfterWordSearchAgain() {
        remainingInput = updateRemainingInput();
        if(remainingInput == null){
            currentPermutation += currentDigit;
            isAWord = true;
            addPermutationToMatches();
        }else {

            resetSearchParameters();
            currentPermutation += currentDigit + "-";
            recursivePermutations();
        }
    }

    /** Adds the current permutation to the lists of matched words. */
    private void addPermutationToMatches() {
        isAWord = true;
        foundWords.add(currentPermutation);
    }

    /** Removes the leading char in the input string */
    private String updateRemainingInput() {
        String newRemainingInput;
        StringBuilder updatedInput;

        updatedInput = new StringBuilder((remainingInput));
        updatedInput.deleteCharAt(0);
        if (updatedInput.length() == 0) {
            newRemainingInput = null;
        } else {
            newRemainingInput = updatedInput.toString();
        }
        return newRemainingInput;
    }

    /** Check if permutation is a word
     * If this is a multi word search e.g 'CALL-ME' then only
     * searches checks if 'ME' is a word*/
    private Boolean permutationIsWord(){
        String[] subString;
        String lastToken;

        if(currentPermutation == null){
            return false;
        }
        subString = currentPermutation.split("-");
        lastToken = subString[subString.length -1];

        for (int i = 0; i < subDictionary.length; i++){
            if(lastToken.equals(subDictionary[i])){
                return true;
            }
        }
        return false;
    }

    /** Narrow down the dictionary so that it only contains words that can  potentially match */
    private void generateNewSubDictionary(){
        char currentChar;
        if(currentPermutation.equals("")){
            /** do nothing */
        }
        else{
            currentChar = currentPermutation.charAt(currentPermutation.length() -1);
            subDictionary = search.getWordsThatMatch(currentChar, numberOfCharsProceeding);
            search = new Search(subDictionary);
        }
    }

    /** Resets parameters to start searching for a new word */
    private void resetSearchParameters() {
        numberOfCharsProceeding = -1;

        /** Reset Dictionary to include all words */
        subDictionary = Dictionary.getDictionary();

        if(subDictionary == null){
            loadDefaultDictionary();
        }
    }

    /**In case a search is started before a dictionary has been loaded.*/
    private void loadDefaultDictionary() {
        System.out.println("Dictionary has not been loaded.");
        System.out.println("Attempting to load default.");
        if(!Dictionary.load("Dictionary.txt")){
            System.out.println("Failed to load default");
        }else{
            subDictionary = Dictionary.getDictionary();
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


}
