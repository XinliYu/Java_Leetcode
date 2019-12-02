package Recursion;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation266 {
    public static boolean hasPalindromes(String s){
        Map<Character, Integer> map = new HashMap<>();

        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        boolean flag = false;
        for(Integer value:map.values()){
            if(value %2 == 1){
                if(flag) return false;
                flag = true;
            }
        }

        return true;
    }

    public void main(String[] args){
        boolean a = hasPalindromes("code");
        System.out.print(a);
    }
}
