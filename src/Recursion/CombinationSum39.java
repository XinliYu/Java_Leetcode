package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        helper(candidates, target, rst, curr, 0,0);
        return rst;
    }

    public void helper(int[] candidates, int target, List<List<Integer>> rst, List<Integer> curr, int startIndex, int currSum){

        if(currSum == target){
            rst.add(new ArrayList<Integer>(curr));
        }else{
            for(int i = startIndex; i<candidates.length;i++){
                if(currSum>target) break;
                currSum += candidates[i];
                curr.add(candidates[i]);
                helper(candidates,target,rst,curr,i,currSum);
                currSum -= candidates[i];
                curr.remove(curr.size()-1);
            }
        }

    }

}
