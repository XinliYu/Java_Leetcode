package sortingProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII253 {
    public int minMeetingRooms(int[][] intervals){
        if(intervals.length == 0) return 0;

        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { //declare a priority queue 'allocator' to compare existing meeting room ending time
                return Integer.compare(o1, o2);
            }
        });

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {   //sort the room intervals to be allocated according to starting time
                return Integer.compare(o1[0], o2[0]);
            }
        });

        allocator.add(intervals[0][1]);  //add the first room interval's ending time in Priority queue 'allocator'

        for(int i=1; i<intervals.length;i++){   //for each room interval

            if(intervals[i][0]>=allocator.peek()){  //if the next room interval to be added started later than the current existing rooms ending time, so no conflict
                allocator.poll();        //pull the current ending time out from Priority queue 'allocator'
            }

            allocator.add(intervals[i][1]);  //add the room interval's ending time to Priority queue 'allocator'
        }
        return allocator.size();
    }
}
