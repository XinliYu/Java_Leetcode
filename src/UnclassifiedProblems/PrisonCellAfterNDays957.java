package UnclassifiedProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PrisonCellAfterNDays957 {

    public int[] prisonAfterNDays(int[] cells,int N){

        Set<String> set = new HashSet<>();
        boolean hasCycle = false;
        int count = 0;

        for(int i =0; i< N; i++){
            int[] next = nextDay(cells);
            String s = Arrays.toString(next);
            if(!set.contains(s)){
                set.add(s);
                count++;
            }else{
                hasCycle = true;
                break;
            }
            cells = next;
        }

        if(hasCycle){
            N = N % count;
            for(int i = 0; i < N; i++){
                cells = nextDay(cells);
            }
        }

        return cells;
    }


    public int[] nextDay(int[] cells){
        int[] rst = new int[cells.length];
        for(int j = 1; j<cells.length-1; j++){
            rst[j]=cells[j-1] == cells[j+1]?1:0;
        }
        return rst;
    }

}
