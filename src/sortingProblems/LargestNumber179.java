package sortingProblems;

import java.util.Arrays;
import java.util.Comparator;
/*
We need to build a new comparator with a comparison mechanism
to sort the array to 9,5,34,3,30. The mechanism is to realize
the largest number so if we have two numbers, for example, 30 and 34,
there are two ways to form a number, 3034 and 3430, clearly 34 30 will be larger,
 similarly, using this mechanism, we can sort the array, 30<<3<<34<<5<<9, after we sort the array this way, we can easily find the largest number.
 */

public class LargestNumber179 {
    public String largestNumber(int[] num) {
        if(num==null || num.length==0) return "";
        String[] temp=new String[num.length];  //convert integer type to string type to avoid overflow
        for(int i=0;i<num.length;i++){
            temp[i]=String.valueOf(num[i]);
        }
        Comparator<String> myComparator=new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                String sa=a+b;
                String sb=b+a;
                return sb.compareTo(sa);
            }
        };

        Arrays.sort(temp,myComparator);
        if(temp[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<temp.length;i++){
            sb.append(temp[i]);
        }
        return sb.toString();
    }
}
