package sortingProblems;

public class SortColors75 {
    public void sortColors(int[] nums){
        int low = 0;         // low-1 is the last 0 visited by mid, low is the place to put the next 0 traversed by mid.
        int high = nums.length-1;     //high+1 is the last 1 visited by mid, high is the place to put the next 1 traversed by mid.
        int mid = 0;         //numbers on the left of mid are all in the right place.

        while(mid <= high){       //do until mid is greater than high
            switch (nums[mid]){
                case 0:           //when mid value is 0
                    int tmp = nums[low];     //nums[low] can be 0(low = mid) or 1(mid>low)
                    nums[low++] = 0;         //switch mid and low then increment
                    nums[mid++] = tmp;
                    break;
                case 1:               //when mid value is 1
                    mid++;            //increment mid
                    break;

                case 2:           //when mid value is 2
                    int tmp2 = nums[high];
                    nums[high--] = nums[mid];   //switch mod and high
                    nums[mid] = tmp2;           //decrease high by 1; nums[high] can be any value, so mid cannot increment.
            }
        }
    }
}
