package UnclassifiedProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis20 {
        public boolean isValid(String s) {

            Map<Character,Character> mymapping = new HashMap<Character, Character>();
            mymapping.put(')','(');
            mymapping.put('}','{');
            mymapping.put(']','[');

            Stack<Character> mystack = new Stack<Character>();

            for(int i = 0; i< s.length(); i++){
                char c = s.charAt(i);
                if(!mymapping.containsKey(c)) mystack.push(c);
                else{
                    if (mystack.isEmpty()) return false;
                    else{
                        char t = mystack.pop();
                        if(t != mymapping.get(c)) return false;
                    }
                }
            }

            if (!mystack.isEmpty()) return false;
            return true;

    }
}
