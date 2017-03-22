

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
    private Boolean isAWord = false;
    private Encode encode = new Encode();
    private String foundWord;

    Permutation(String currentPermutation, int currentPositionInString, String remainingInput,
                String[] dictionary) {


        System.out.println(currentPermutation);
        System.out.println(remainingInput);

        this.currentPermutation = currentPermutation;
        this.currentPositionInString = currentPositionInString;
        this.remainingInput = remainingInput;
        this.search = new Search(dictionary);

        generateNewSubDictionary();
        if(!hasWordsMatching()){
            /** no words match permutation stop */

        }
        else {
            /** Is final word */
            if (permutationIsWord() && remainingInput == null) {
                System.out.println("This is a test " +currentPermutation);

                isAWord = true;
                foundWord = this.currentPermutation;
            }
            /** Has more numbers to process in the string and word matches*/
            else if (permutationIsWord()) {
                isAWord = true;
                this.currentPermutation += "-";
                /*TODO*/ /**I need to spin up new permutaitons here */
            }
            /** only partial matches found */
            else{
                /** TODO Extract this to own method */
                char[] possibleKeys;
                String newPermutation,newRemainingInput;

                possibleKeys = encode.getPossibleKeys(remainingInput.charAt(0));
                StringBuilder sb = new StringBuilder((remainingInput));
                sb.deleteCharAt(0);

                if(sb.length() == 0){
                    newRemainingInput = null;
                    System.out.println("Set too null");
                }
                else {
                    newRemainingInput = sb.toString();
                }
                    System.out.println("Input " + remainingInput + " new string " + sb.toString());

                    currentPositionInString++;

                    System.out.println(currentPositionInString);

                    newPermutation = currentPermutation + possibleKeys[0];
                    Permutation nextPermutation1 = new Permutation(newPermutation, currentPositionInString, newRemainingInput,
                            subDictionary);

                    if (nextPermutation1.isAWord || foundWord != null) {
                        foundWord = nextPermutation1.getPermutation();
                    }

                    newPermutation = currentPermutation + possibleKeys[1];
                    Permutation nextPermutation2 = new Permutation(newPermutation, currentPositionInString, newRemainingInput,
                            subDictionary);

                    if (nextPermutation2.isAWord) {
                        foundWord = nextPermutation2.getPermutation();
                        System.out.println("copying word up "+nextPermutation2.getPermutation());
                    }

                    newPermutation = currentPermutation + possibleKeys[2];
                    Permutation nextPermutation3 = new Permutation(newPermutation, currentPositionInString, newRemainingInput,
                            subDictionary);

                    if (nextPermutation3.isAWord) {
                        foundWord = nextPermutation3.getFoundWord();
                        isAWord = true;
                        System.out.println(nextPermutation3.getPermutation());
                    }


            }



        }
    }

    /** check if permutation is a word */
    private Boolean permutationIsWord(){
        for (int i = 0; i < subDictionary.length; i++){
            if(currentPermutation.equals(subDictionary[i])){
                return true;
            }
        }
        return false;
    }
        /** check if match word
         * check if we have more numbers to encode
         *      then spin of new permutations
         *      get words
         *      then kill
         * else
         *      set subdic to null or set a var to show we need to be killed
         * /
    }

    /** Helpers */

    /** narrow down the dictionary so that it only contains words that can  potentially match */
    private void generateNewSubDictionary(){
        char currentChar;
        if(currentPermutation == null){
            /** do nothing */
        }
        else {
            /** need to also check precedding words */
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

    public Boolean isAWord(){
        return isAWord;
    }

    public String getPermutation(){
        return currentPermutation;
    }

    public String getFoundWord(){
        return foundWord;
    }
}
