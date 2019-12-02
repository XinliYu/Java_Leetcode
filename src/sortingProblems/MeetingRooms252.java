package sortingProblems;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms252 {
    public boolean isvalid(int[][] intervals){

        Arrays.sort(intervals, new Comparator<int[]>(){          //sort the room intervals according to starting time
            public int compare(int[] a, int[] b){
                return Integer.compare(a[0],b[0]);
            }
        });

        for(int i=0;i<intervals.length-1;i++){                //if the next room interval's starting time is earlier than the previous room's ending time, return false
            if(intervals[i][1]>intervals[i+1][0]) return false;
        }
        return  true;                                      //else return true
    }

    public static void main(String[] args){
        int[][] schedule = new int[][] {{0,30},{5,10},{6,20}};
        MeetingRooms252 myrooms = new MeetingRooms252();
        boolean a = myrooms.isvalid(schedule);
        System.out.println(a);
    }
}
