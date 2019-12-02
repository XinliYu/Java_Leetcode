package sortingProblems;

public class ToLowerCase709 {
    public String toLowerCase(String str){
        char[] mychar = str.toCharArray();
        for(int i = 0;i<mychar.length;i++){
            mychar[i] = Character.toLowerCase(mychar[i]);
        }
        return String.valueOf(mychar);
    }
}
