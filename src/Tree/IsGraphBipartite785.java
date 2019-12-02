package Tree;

// graph[i] is a list of indexes j for which the edge between nodes i and j exists.
//Each node is an integer between 0 and graph.length - 1

//Example 1:
//Input: [[1,3], [0,2], [1,3], [0,2]]
//Output: true
//Explanation:
//The graph looks like this:
//0----1
//|    |
//|    |
//3----2
//We can divide the vertices into two groups: {0, 2} and {1, 3}.


import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite785 {
    public boolean isBipartite(int[][] g){
        int[] colors = new int[g.length];    //mark if a node has been visited
        for(int i = 0; i < g.length; i++){   //traverse all the node
            if(colors[i] == 0) {            //if a node has not been colored, do BFS start from this node (i.e., it has not been reached by previous BFS)
                Queue<Integer> myqueue = new LinkedList<Integer>();
                myqueue.add(i);
                colors[i] = 1;    //do BFS start from i
                while (!myqueue.isEmpty()){
                    Integer node = myqueue.poll();   //poll a node from the queue
                    for(int adjacency:g[node]){    //traverse the polled node's neighbors
                        if(colors[adjacency] == colors[node]) return false;   //if the adjacent color is the same as the node, return false
                        else if(colors[adjacency] == 0){   //if the adjacency color has not been traversed
                            myqueue.add(adjacency);               //add it to the queue
                            colors[adjacency] = -colors[node];       //make the color the opposite of the node's color
                        }
                    }
                }
            }
        }
        return true;
    }
}
