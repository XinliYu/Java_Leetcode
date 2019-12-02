package Recursion;

import java.util.*;

public class LetterCombinationsPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>() {{
            put('2', Arrays.asList('a','b','c'));
            put('3', Arrays.asList('d','e','f'));
            put('4', Arrays.asList('g','h','i'));
            put('5', Arrays.asList('j','k','l'));
            put('6', Arrays.asList('m','n','o'));
            put('7', Arrays.asList('p','q','r','s'));
            put('8', Arrays.asList('t','u','v'));
            put('9', Arrays.asList('w','x','y','z'));
        }};
        if (digits.length() == 0) return result;   //digits == "" does not work
        generateProcess(result, "", 0, digits, map);
        return result;
    }

    public void generateProcess(List<String> result, String curr, int digitNum, String digits, Map<Character, List<Character>> mymap){

        if (curr.length() == digits.length()){
            result.add(curr);
            return;
        }
        char mydigit = digits.charAt(digitNum);
        List<Character> mylist = mymap.get(mydigit);

        for(Character letter:mylist){
            generateProcess(result, curr+letter, digitNum+1, digits, mymap);//need to use "curr + letter"
            // curr += letter then pass curr does not work
        }

    }
}
