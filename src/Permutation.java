import java.util.ArrayList;

/**
 * Created by louie on 22/03/2017.
 */
public class Permutation {

    private String currentPermutation, remainingInput;
    private String[] subDictionary,fulldic;
    private int currentPositionInInput, numberOfCharsProceeding;
    private Search search;
    private Boolean isAWord = false;
    private Encode encode = new Encode();
    private ArrayList<String> foundWords = new ArrayList<>();
    private static final int nextInputNumber = 0;

    Permutation(String currentPermutation, int currentPositionInInput, int numberOfCharsProceeding, String remainingInput,
                String[] dictionary) {

        if(currentPermutation == null){
            System.out.print("Null entered as current Permutation - Stopped Search");
        }else{

            this.currentPermutation = currentPermutation;
            this.currentPositionInInput = currentPositionInInput;
            this.remainingInput = remainingInput;
            this.search = new Search(dictionary);
            this.subDictionary = dictionary;
            this.numberOfCharsProceeding = numberOfCharsProceeding;
            /** temp for test make dic object */
            this.fulldic = dictionary;
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

            /** Ignore Match and keep searching for larger word matches */
            recursivePermutations();


            /**Search for multi word match */
            currentPermutation += "-";
            numberOfCharsProceeding = -1;
            subDictionary = fulldic;

            recursivePermutations();
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

    /** Creates a new permutation object and checks if it is a word*/

    /*TODO I need too have this create clean permutations or ones with a dash */
    private void generateNewPermutation(char key, String newRemainingInput) {
        String newPermutation;

        newPermutation = currentPermutation + key;
        Permutation nextPermutation = new Permutation(newPermutation, currentPositionInInput, numberOfCharsProceeding, newRemainingInput,
                subDictionary);

        /*TODO - I need to store the output in an arrayList so I can keep all variations avaliable */
        /** Feeding the word back out of the recursive stack*/
        if (nextPermutation.isAWord) {
                foundWords.addAll(nextPermutation.getFoundWords());
                System.out.println("Assing to ArrayList "+foundWords);
                isAWord = true;
        }
    }

    /** Check if permutation is a word
     * if this is a multi word search e.g 'CALL-ME' then only
     * searchs if 'ME' is a word*/
    private Boolean permutationIsWord(){
        String[] subString;
        String lastToken;

        if(currentPermutation == null){
            return false;
        }

        subString = currentPermutation.split("-");
        lastToken = subString[subString.length -1];
        System.out.println(lastToken);

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
