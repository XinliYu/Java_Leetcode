package sortingProblems;

import java.util.Arrays;

public class WiggleSortII324 {
    public void wiggleSort(int[] nums){
        Arrays.sort(nums);

        int[] temp = new int[nums.length];

        int mid = (nums.length-1)/2;

        int index = 0;

        for(int i=0; i<nums.length;i++){  //fill the elements into the wiggled array
            if(i%2==0){
                temp[i] = nums[mid-index];
            }else{
                temp[i] = nums[nums.length-1-index];
                index += 1;
            }
        }
    }
}

//012 345
//134 589   1234 567

//0 1 2 3 4 5
//4 9 3 8 1 5
