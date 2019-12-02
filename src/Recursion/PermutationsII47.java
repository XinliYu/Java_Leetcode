package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return lists;
        List<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);                     //sort the array
        helper(nums, lists, list, visited);
        return lists;
    }

    public void helper(int[] nums, List<List<Integer>> lists, List<Integer> list, boolean[] visited){

        if(list.size() == nums.length){
            lists.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;         //if already added to the current list, continue to the next element
            visited[i] = true;        //added to the current list and mark as visited
            list.add(nums[i]);
            helper(nums, lists, list, visited);
            visited[i] = false;
            list.remove(list.size()-1);

            while(i<nums.length-1 && nums[i] == nums[i+1])          //To avoid duplicate elements, if duplicated move to the last
                i++;                                                 //element of the block of duplication, since it is already sorted
        }                                                          //NOTE: The i th one is the one just added and then popped
                                                                            //We need to avoid add it again, so need to skip the block of duplicates
    }
}
