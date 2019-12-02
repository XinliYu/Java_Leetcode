package sortingProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals56 {


    public int[][] merge(int[][] intervals){

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {     //sort the intervals by the starting time of each interval
                return Integer.compare(o1[0], o2[0]);
            }
        });

        LinkedList<int[]> merged = new LinkedList<>();       //create the LinkedList 'merged' to store the new intervals after merging
                                                             // using LinkedList since we don't need to specify its size in the beginning

        for(int i = 0; i < intervals.length; i++){
            if(merged.isEmpty()||merged.getLast()[1]< intervals[i][0]){   //if 'merged' last element ending time is earlier than the the next interval starting time
                merged.add(intervals[i]);                                 // add the next interval into 'merged'
            }
            else {
                merged.getLast()[1] = Math.max(intervals[i][1], merged.getLast()[1]);   //else change the 'merged' last element ending time to the minimum of the two
            }
        }

        return merged.toArray(new int[merged.size()][]);    //convert the LinkedList 'merged' to the 2d array

    }



    public static void main(String[] args){

        int[][] intervals = new int[][] {{1,3},{2,6},{8,10},{15,18}};

        MergeIntervals56 myintervals = new MergeIntervals56();

        int[][] a = myintervals.merge(intervals);

        System.out.println(Arrays.deepToString(a));

    }

}
