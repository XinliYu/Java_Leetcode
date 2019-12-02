package sortingProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOf2Arrays350 {

    public int[] getIntersect(int n, Map<Integer,Integer> map1, Map<Integer,Integer> map2){
        int[] output = new int[n];
        int count = 0;
        for(Integer num:map1.keySet()){            //traverse elements in map1 keys
            if(map2.containsKey(num)){                             //if this key is also in map2
                int repeat = Math.min(map1.get(num), map2.get(num));              //add the min number of value as repeat
                for(int i = count; i < count + repeat; i++) output[i] =num;          //add the key to output repeat number of times
                count += repeat;                         //increment count by repeat number
            }
        }

        return Arrays.copyOf(output, count);         //copy the output as length count
    }


    public int[] intersect(int[] nums1, int[] nums2){
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();       //declare two maps
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for(Integer num:nums1){                   //for each num in nums1
            if(!map1.containsKey(num)) map1.put(num, 1);       //if the num is not in map, put it map as key with value 1
            else map1.put(num, map1.get(num)+1);      //if the num is already in map, increment its value
        }
        for(Integer num:nums2){                         //same for nums2
            if(!map2.containsKey(num)) map2.put(num, 1);
            else map2.put(num, map2.get(num) + 1);
        }

        int n = nums1.length;

        return getIntersect(n, map1, map2);     //find the intersection of map1, map2
    }

}
