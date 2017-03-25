import java.util.ArrayList;

/**
 * Created by louie on 22/03/2017.
 */
public class Permutation {

    private String currentPermutation, remainingInput;
    private String[] subDictionary;
    private int currentPositionInInput, numberOfCharsProceeding;
    private Search search;
    private Boolean isAWord = false;
    private Encode encode = new Encode();
    private ArrayList<String> foundWords = new ArrayList<>();
    private static final int nextInputNumber = 0;

    Permutation(String currentPermutation, int currentPositionInInput, int numberOfCharsProceeding, String remainingInput,
                String[] dictionary) {

        if(currentPermutation == null){
            System.out.print("No input given - Stopped Search");
        }else{
            updateData(currentPermutation, currentPositionInInput, numberOfCharsProceeding, remainingInput, dictionary);
            generateNewSubDictionary();
           /* System.out.println(currentPermutation);*/
            if(!hasWordsMatching()){
                /** Do nothing */
            }
            else {
                continueSearch();
            }
        }
    }

    private void updateData(String currentPermutation, int currentPositionInInput, int numberOfCharsProceeding, String remainingInput, String[] dictionary) {
        this.currentPermutation = currentPermutation;
        this.currentPositionInInput = currentPositionInInput;
        this.remainingInput = remainingInput;
        this.search = new Search(dictionary);
        this.subDictionary = dictionary;
        this.numberOfCharsProceeding = numberOfCharsProceeding;
    }

    /** Helpers */

    /** Checks if current permutation is a one to one match with string e.g. 2255 = CALL
     * If it is a one to one match or there is no input left to parse then stop search
     * Otherwise continue recursive search*/
    private void continueSearch() {

        if (permutationIsWord() && remainingInput == null) {
            addPermutationToMatches();
        }else if (remainingInput == null){
            /** Do nothing */
        }
        else if (permutationIsWord()) {
            /** First ignore match and keep searching for larger words */
            recursivePermutations();

            /**Now search for multi word match */
            resetSearchParameters();
            recursivePermutations();
        }
        /** keep searching */
        else{
            recursivePermutations();
        }
    }

    private void addPermutationToMatches() {
        isAWord = true;
        foundWords.add(currentPermutation);
        System.out.println("Is a word "+currentPermutation);
    }

    /** Spins up new permutation objects to start checking the next set of permutations */
    private void recursivePermutations() {
        char[] possibleKeys;
        String newRemainingInput;

        /**Get encodings for the next number, and update*/
        possibleKeys = encode.getPossibleKeys(remainingInput.charAt(nextInputNumber));
        newRemainingInput = updateRemainingInput();
        currentPositionInInput++;
        numberOfCharsProceeding++;

        for(int i = 0; i < possibleKeys.length; i++){
            generateNewPermutation(possibleKeys[i], newRemainingInput);
        }
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

    /** Creates a new permutation of length currentPermutation+1 and checks if it is a word*/
    private void generateNewPermutation(char key, String newRemainingInput) {
        String newPermutation;

        newPermutation = currentPermutation + key;
        Permutation nextPermutation = new Permutation(newPermutation, currentPositionInInput, numberOfCharsProceeding, newRemainingInput,
                subDictionary);

        /** Feeding the word back out of the recursive stack*/
        if (nextPermutation.isAWord) {
                foundWords.addAll(nextPermutation.getFoundWords());
                System.out.println("Adding to found words "+foundWords);
                isAWord = true;
        }
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
        if(currentPermutation == ""){
            /** do nothing */
        }
        else{
            currentChar = currentPermutation.charAt(currentPositionInInput);
            subDictionary = search.getWordsThatMatch(currentChar, numberOfCharsProceeding);
            search = new Search(subDictionary);
        }
    }

    /** resets parameters to start searching for a new word */
    private void resetSearchParameters() {
        currentPermutation += "-";
        numberOfCharsProceeding = -1;

        /** Reset Dictionary to include all words */
        subDictionary = Dictionary.getDictionary();

        if(subDictionary == null){
            loadDefaultDictionary();
        }
    }
    private void loadDefaultDictionary() {
        System.out.println("Dictionary has not been loaded.");
        System.out.println("Attempting to load default.");
        if(!Dictionary.load(null)){
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
