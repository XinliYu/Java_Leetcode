package sortingProblems;

import java.util.Arrays;

public class QuickSort {

    public void quicksort(int[] a, int low, int high){
        if(low<high) {
            int end = pivot(a, low, high);
            quicksort(a, low, end - 1);
            quicksort(a, end + 1, high);
        }
    }

    public static int pivot(int[] a, int low, int high){   //pivot is the first element a[low]
        int i = low;               //all numbers on the left of low is smaller than or equal to pivot
        int j = high;              //al numbers on the right of high is larger than pivot

        while(i<j){                //stop when j and i pass each other, note they cannot be equal to each other since if it is greater decrement j, less or equal increment i
            while(a[i]<=a[low] && i < high) i++;  //except the case j don't move at all,i.e. all things are smaller or equal to the pivot chosen
            while(a[j]>a[low] && j> low) j--;

            if(i<j){
                int tmp = a[i];
                a[i] = a[j];          //switch a[i] and a[j]
                a[j] = tmp;
            }
        }

        int temp = a[low];  //switch j and the key, so the key is in the right place, since j don't move any more, so j must points to a number less or equal to pivot
        a[low] = a[j];     //this way pivot is in the right place of the array
        a[j] = temp;        //return pivot position
        return j;
    }

    public static void main(String[] args){
        int[] a = new int[] {1,999,3};
        QuickSort mytest = new QuickSort();
        mytest.quicksort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
