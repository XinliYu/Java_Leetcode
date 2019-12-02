package UnclassifiedProblems;

import java.util.HashMap;

public class FindUniCharacterInString387 {
    public int firstUniChar(String s){

        HashMap<Character,Integer> mymap = new HashMap<Character, Integer>();
        char[] mychar = s.toCharArray();
        int n = mychar.length;

        for(int i = 0; i < n; i++){
            mymap.put(mychar[i], mymap.getOrDefault(mychar[i],0) + 1);
        }

        for(int i = 0; i < n; i++){
            if(mymap.get(mychar[i]) == 1) return i;
        }
        return -1;
    }
}
