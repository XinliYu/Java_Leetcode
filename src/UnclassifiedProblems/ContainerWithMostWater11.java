package UnclassifiedProblems;

public class ContainerWithMostWater11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;
        int width = n-1;
        int max = Math.min(height[i],height[j])*width;

        while(i<j){
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
            width--;
            int tmp = Math.min(height[i],height[j])*width;
            if(tmp>max) max = tmp;
        }
        return max;
    }
}
