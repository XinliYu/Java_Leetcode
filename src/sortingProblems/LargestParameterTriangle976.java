package sortingProblems;

import java.util.Arrays;

public class LargestParameterTriangle976 {
    public int largestPerimeter(int[] A){
        Arrays.sort(A);          //sort the numbers
        for(int i = A.length-3; i>= 0; --i){    //starting from the third last element, decrease one each time
            if(A[i]+A[i+1]>A[i+2]) return A[i]+A[i+1]+A[i+2];    //check if it satisfies triangular inequality
        }
        return 0;
    }
}
