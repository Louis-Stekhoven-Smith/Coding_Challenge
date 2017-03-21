/**
 * Created by louie on 22/03/2017.
 */
public class Permutation {

    private String currentPermutation;
    private int currentPositionInString;
    private String remainingInput;

    Permutation(String currentPermutation, int currentPositionInString, String remainingInput){
        this.currentPermutation = currentPermutation;
        this.currentPositionInString = currentPositionInString;
        this.remainingInput = remainingInput;
    }


    /** Getters */
    public String getPermutation(){
        return currentPermutation;
    }


}
