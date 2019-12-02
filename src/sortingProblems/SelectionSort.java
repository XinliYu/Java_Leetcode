package sortingProblems;

import java.util.Arrays;

public class SelectionSort {  //going forward to find the smallest element and put it in the right place, will not change in the future.
    public int[] selectionsort(int[] a){
        for(int i = 0; i < a.length; i++){   //starting from i
            int min = i;                //find index of the min in the array a from i
            for(int j = i; j < a.length; j++) {
                if (a[j] < a[min]) min = j;
            }
            int tmp = a[i];         //put the i-th min in the right place
            a[i] = a[min];
            a[min] = tmp;
        }
        return a;
    }

    public static void main(String[] args){
        int[] myarray = new int[] {1,9,0,5,3};
        SelectionSort mytest = new SelectionSort();
        int[] rst = mytest.selectionsort(myarray);
        System.out.println(Arrays.toString(rst));

    }
}
