package UnclassifiedProblems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> complement = new HashMap<Integer, Integer>();
        int[] rst = new int[2];
        for(int i = 0; i < n; i++){
            if(complement.containsKey(nums[i])){
                rst = new int[] {complement.get(nums[i]), i};
                break;
            }else{
                complement.put(target-nums[i],i);
            }
        }
        return rst;

    }
}
