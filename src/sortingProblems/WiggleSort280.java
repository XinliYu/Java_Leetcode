package sortingProblems;

import java.util.Arrays;

public class WiggleSort280 {
    public void wiggleSort(int[] nums){
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i += 2){
            swap(nums, i, i+1);
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void wiggleSort2(int[] nums){
        boolean less = true;
        for (int i = 0; i < nums.length - 1; i++){
            if(less){
                if(nums[i]>nums[i+1]){
                    swap(nums, i ,i+1);
                }
            }else{
                if(nums[i] < nums[i+1]){
                    swap(nums, i,i+1);
                }
            }
            less = !less;
        }
    }

    public void wiggleSort3(int[] nums){
        for(int i = 0; i < nums.length-1; i++){   //fill into the wiggle array
            if(((i%2==0) &&nums[i]>nums[i+1])|| ((i%2==1) &&nums[i]<nums[i+1]) ){   //compares with the next element
                swap(nums,i, i+1);
            }
        }
    }
}
