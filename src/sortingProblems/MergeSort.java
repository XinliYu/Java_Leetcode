package sortingProblems;

import java.util.Arrays;

public class MergeSort {


    public void sort(int low, int high, int[] arr){
        int mid = (low + high)/2;
        if (low < high) {
            sort(low, mid, arr);   //sort left half
            sort(mid + 1, high, arr);   //sort right half
            merge(low, mid, high, arr);    //merge left half and right half
        }
    }

    public static void merge(int low, int mid, int high, int[] arr){
        int[] helper = new int[arr.length];   //a helper array
        int i = low;     // i start at low
        int j = mid + 1;  //j start at mid+1

        for(int k=low; k<=high; k++){   // only update values indexed from low to high
            if(i>mid) helper[k] = arr[j++];         //if the left half is done, append right half to helper array
            else if(j>high) helper[k] = arr[i++];    //if the right half is done,append left half to helper array
            else if(arr[i]<arr[j]) helper[k] = arr[i++];    // compare arr[i] and arr[j], append the smaller one, and increment its index
            else helper[k] = arr[j++];
        }
        for(int h = low; h <= high; h++){             //copy the sorted elements from helper array to array
            arr[h] = helper[h];
        }
    }

    public static void main(String[] args){
        int[] a = new int[] {1,3,0,9,6,5};
        MergeSort mytest = new MergeSort();
        mytest.sort(0, a.length-1, a);
        System.out.println(Arrays.toString(a));
    }
}
