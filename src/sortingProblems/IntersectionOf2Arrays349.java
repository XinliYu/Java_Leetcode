package sortingProblems;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOf2Arrays349 {
    private int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();   //declare two sets to store elements in each array
        for(Integer element:nums1) set1.add(element);
        for(Integer element:nums2) set2.add(element);       //add elements to the two sets

        if(set1.size()<set2.size()) return setIntersection(set1,set2);
        else return setIntersection(set2,set1);
    }

    private int[] setIntersection(HashSet<Integer> set1, HashSet<Integer> set2){
        int[] output = new int[set1.size()];
        int idx = 0;
        for(Integer s:set1){                          //traverse the smaller set
            if(set2.contains(s)) output[idx] = s;          //if the element is also in set2, add to the array output
            idx++;                                    //increment its size
        }
        return Arrays.copyOf(output, idx);                     //copy into the array of size idx
    }



}
