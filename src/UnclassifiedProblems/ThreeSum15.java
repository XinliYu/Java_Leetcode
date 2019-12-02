package UnclassifiedProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length -2; i++){
            if(i==0 ||nums[i-1] != nums[i]){   //make sure the i-th element is not duplicate with the previous one
                int start = i + 1;
                int end = nums.length - 1;
                while(start < end){
                    if(nums[i] + nums[start] + nums[end] == 0){
                        lists.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[start], nums[end])));
                        int currstart = start;
                        while(nums[start] == nums[currstart]&& start <end)
                            start++;
                    }
                    if(nums[i] + nums[start] + nums[end] < 0){
                        int currstart = start;     //cache the start
                        while(nums[start] == nums[currstart]&& start <end)   //make sure the next start different from the
                            start++;                                         //previous start by incrementing start.
                    }
                    if(nums[i] + nums[start] + nums[end] > 0){
                        int currend = end;
                        while(nums[end] == nums[currend]&& start <end)
                            end--;
                    }
                }

            }

        }

        return lists;
    }
}
