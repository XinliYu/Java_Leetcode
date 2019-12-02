package sortingProblems;

import java.util.Arrays;

public class ValidAnagram242 {
    public boolean validanagram1(String s, String t){
        if(s.length()!=t.length()){    //if String s and String t has different length
            return false;              //return false
        }
        char[] str1 = s.toCharArray();  //convert String s to array of chars str1
        char[] str2 = t.toCharArray();   //convert String t to array of chars str2

        Arrays.sort(str1);      //sort the array of chars str1
        Arrays.sort(str2);      //sort the array of chars str2

        return Arrays.equals(str1,str2);   //see if the sorted array of chars is equal to each other
    }

    public boolean validanagram2(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] counter = new int[26];             //create an array 'counter' of size 26 representing 26 letters

        for(int i=0; i<s.length(); i++){         //for the i th letter
            counter[s.charAt(i)-'a']++;         //consider the i-th letter of string s, increase its count by 1
            counter[t.charAt(i)-'a']--;         //consider the i-th letter of string t, decrease its count by 1
        }


        for(int count:counter){
            if(count!=0) return false;        // if a letter's is not 0 in 'counter', return false
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = "bacdefg";
        ValidAnagram242 com = new ValidAnagram242();
        boolean a1 = com.validanagram1(str1,str2);
        boolean a2 = com.validanagram2(str1,str2);
        System.out.println(a1);
        System.out.println(a2);
    }
}
