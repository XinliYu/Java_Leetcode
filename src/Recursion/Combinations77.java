package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public List<List<Integer>> combine(int n, int k){
        List<List<Integer>> rst = new ArrayList<List<Integer>>();

        helper(n,k,rst, new ArrayList<Integer>(), 0);
        return rst;
    }

    public void helper(int n, int k, List<List<Integer>> rst, ArrayList<Integer> curr, int startIndex){
        if( k == 0){
            rst.add(curr);
            curr = new ArrayList<Integer>();
        }

        helper(n, k-1, rst, curr, startIndex+1);
    }
}
