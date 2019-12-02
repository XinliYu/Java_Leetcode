package Recursion;

import java.util.ArrayList;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//For example, given n = 3, a solution set is:
//
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
public class GenerateParenthesis22 {
    public List<String> generateParenthesis(int numPairs){
        List<String> result = new ArrayList<String>();
        generateProcess(numPairs, numPairs, "",result);
        return result;
    }

    private static void generateProcess(int leftParenthesisNeeded, int rightParenthesisNeeded, String ParenthesisInProgress, List<String> result){
        if(leftParenthesisNeeded == 0 && rightParenthesisNeeded == 0){
            result.add(ParenthesisInProgress);
            return;
        }

        if(leftParenthesisNeeded > 0){
            generateProcess(leftParenthesisNeeded-1,rightParenthesisNeeded,ParenthesisInProgress + "(", result);
        }

        if(rightParenthesisNeeded > 0){
            generateProcess(leftParenthesisNeeded, rightParenthesisNeeded-1,ParenthesisInProgress + ")", result);
        }
    }
}


//( ( ( ) ) )
//( ( ) ( ) )
//( ( ) ) ( )
//( ) ( ( ) )
//( ) ( ) ( )