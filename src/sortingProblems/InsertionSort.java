package sortingProblems;

import java.util.Arrays;

public class InsertionSort {



    public int[] insertionsort(int[] a){   //going backward to swap new element in the current right place, may change in the future
        for(int i = 1; i < a.length; i++){
            int key = a[i];          //start from the second one as keys
            int j = i-1;             //comparing each key with its previous ones, starting from previous one
            while((j >= 0) && (a[j] > key)){   //moving elements to the next position until having encounter an element smaller than key
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
        return a;
    }

    public static void main(String[] args){
        int[] myarray = new int[] {1,9,0,5,3,10,7};
        InsertionSort mytest = new InsertionSort();
        int[] rst = mytest.insertionsort(myarray);
        System.out.println(Arrays.toString(rst));
    }

}
