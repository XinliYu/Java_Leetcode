package UnclassifiedProblems;

public class SingleElementSortedArray540 {

    public int singleNonDuplicate1(int[] nums) {
        int n = nums.length;
        return helper(nums, 0, n-1);
    }

    public int helper(int[] nums, int low, int high){
        if(low == high) return nums[low];
        int mid = (low + high)/2;
        if(mid % 2 ==0){
            if(nums[mid]==nums[mid+1]) return helper(nums, mid+2,high);
            else return helper(nums, low, mid);
        }
        if(mid % 2 == 1){
            if(nums[mid]==nums[mid-1]) return helper(nums, mid+1,high);
            else return helper(nums, low, mid-1);
        }
        return 0;

    }


        /**
         * @timeComplexity: O(logn)
         * @solution:       Binary Search
         * @runtime:        1ms
         */

        public int singleNonDuplicate2(int[] nums){
            int lo = 0;
            int hi = nums.length/2;
            int mid = 0;
            while (lo < hi) {
                mid = (hi+lo)/2; // to avoid overflow
                if (nums[2*mid] == nums[2*mid+1]) { // means the "not same pairs" are to its right
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            return nums[2*lo];

        }

    public int singleNonDuplicate3(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(low < high){
            mid = low +(high - low)/2;
            if (mid %2 == 0) mid += 1;  //make sure the numbers mid and mid+1 are in pair
            if(nums[mid] == nums[mid+1]) high = mid -1;
            else low = mid+1;

        }

        return nums[low];
    }

}
