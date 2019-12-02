package UnclassifiedProblems;

public class ProductOfArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = nums[0];
        b[0] = nums[n-1];
        for(int i = 1; i < n; i++){
            a[i] = a[i-1] * nums[i];
            b[i] = b[i-1] * nums[n-1-i];
        }

        int[] rst = new int[n];
        for(int i = 1; i < n -1; i++){
            rst[i] = a[i-1]*b[n-i-2];
        }
        rst[0] = b[n-2];
        rst[n-1] = a[n-2];
        return rst;
    }
}
// a1 = 1 1*2 1*2*3 1*2*3*4 // 从左往右的数的乘积
// a2 = 4 4*3 4*3*2 4*3*2*1 //

//  n = len(nums)
//  i = 1 // 第二个数
//  a[i-1] * a2[n-i - 1] //左边的所有数字的乘积 * 右边所有数的乘积
//  if i == 0:
//      return a2[n-1]