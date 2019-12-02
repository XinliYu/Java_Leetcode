package sortingProblems;

import java.util.ArrayList;
import java.util.List;

public class SortByParityII922 {
    public int[] sortArrayByParityII(int[] A){

        int n = A.length;                                             //Array is a fixed size, ArrayList is not
        List<Integer> arr1 = new ArrayList<Integer>();
        List<Integer> arr2 = new ArrayList<Integer>();

        for(int i=0; i<n; i++){                                      //add even numbers to arr1; odd numbers to arr2
            if(A[i]%2==0) arr1.add(A[i]);
            else arr2.add(A[i]);
        }

        int[] output = new int[n];

        for(int i =0; i<n; i++){                                      //if even, get the element in arr1, else arr2.
            int m = i/2;
            if(i%2 == 0){
                output[i] = arr1.get(m);
            }
            else{
                output[i] = arr2.get(m);
            }
        }
    return output;

    }

    public int[] anothersortArrayByParityII(int[] A){
        int n = A.length;                                             //Array is a fixed size, ArrayList is not
        int[] output = new int[n];
        int even = 0;
        int odd = 1;

        for(int i=0; i<n; i++){                                      //add even numbers to arr1; odd numbers to arr2
            if(A[i]%2==0){
                output[even] = A[i];
                even += 2;
            }
            else{
                output[odd] = A[i];
                odd += 2;
            }
        }


        return output;

    }
}
