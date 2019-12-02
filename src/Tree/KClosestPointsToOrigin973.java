package Tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin973 {

    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        int[] dists = new int[n];
        for(int i = 0; i < n; i++){
            dists[i] = findDist(points, i);
        }

        Arrays.sort(dists);

        int pivot = dists[K-1];
        int[][] outputs = new int[K][2];
        int count = 0;
        for(int i = 0; i<n;i++){
            if(findDist(points, i) <= pivot)
                outputs[count++] = points[i];

        }
        return outputs;
    }

    public int findDist(int[][] points, int i){
        return points[i][0]*points[i][0] +points[i][1]*points[i][1];
    }


    public int[][] kClosest2(int[][] points, int K) {
        int[][] res = new int[K][2];
        int count = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(10, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]);
            }
        });

        for (int[] each : points) {
            pq.offer(each);
            if (pq.size() > K) pq.poll();
        }

        while (!pq.isEmpty()) {
            res[count++]=pq.poll();
        }
        return res;
    }


}
