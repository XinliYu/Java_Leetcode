package UnclassifiedProblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstrWithoutRepeatingChar3 {
    public int lengthOfLongestSubstring(String s){
        int ans;
        ans = 0;
        int n = s.length();
        for(int i = 0; i < n; i++)
            for(int j = i + 1; j <= n; j++)
                if(allUnique(s,i,j)) return Math.max(ans, j - i);
        return ans;
    }

    public boolean allUnique(String s, int start, int end){
        Set<Character> myset = new HashSet<>();

        for(int i = start; i < end; i++){
            if(myset.contains(s.charAt(i))) return false;
            myset.add(s.charAt(i));
        }
        return true;
    }


    //We use HashSet to store the characters in current window [i, j) (j = i initially)
    //slide j to the right, if it is not in the HashSet slide further
    //Doing until s[j] is already in the HashSet
    //At this point, we found the maximum size of substrings without duplicate characters start with index i
    //we do thif for all i, we found our answer

    public int lengthOfLongestSubstring2(String s){
        Set<Character> myset = new HashSet<>();
        int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n && j < n){
            if(!myset.contains(s.charAt(j))){
                myset.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else{
                myset.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        Map<Character, Integer> mymap = new HashMap<>();  //current index of character
        int ans = 0, i = 0, j = 0;
        while(i < n && j < n){
            //try to extend the range [i,j]
            if(!mymap.containsKey(s.charAt(j))){
                mymap.put(s.charAt(j++), j);
                ans = Math.max(ans, j - i);
            }
            else{
                i = Math.max(mymap.get(s.charAt(j)),i);
                mymap.put(s.charAt(j++), j);
                ans = Math.max(ans, j - i);
            }
        }
        return ans;
    }

}
