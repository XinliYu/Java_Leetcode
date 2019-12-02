package sortingProblems;

import java.util.HashSet;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums){

        HashSet<Integer> myset = new HashSet<>();

        for(int x:nums){
            if(myset.contains(x)) return true;
            myset.add(x);
        }

        return false;
    }
}
