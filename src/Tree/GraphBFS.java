package Tree;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFS {
    private int V;        //number of vertices
    private LinkedList<Integer> adj[];   //array of LinkedList as adjacency matrix

    GraphBFS(int v){
        V = v;
        adj = new LinkedList[v];           //array of length v of LinkedList
        for(int i = 0; i<v; ++i)
            adj[i] = new LinkedList<>();
    }


    void addEdge(int v, int w){         //directed graph
        adj[v].add(w);
    }

    void BFS(int s){
        LinkedList<Integer> queue = new LinkedList<>();   //declare a queue
        boolean visited[] = new boolean[V];     //declare a visited flag

        visited[s] = true;

        queue.add(s);       //add starting node to queue
        while(queue.size()!=0){   //while the queue is not empty
            s = queue.poll();     //poll queue as node s
            System.out.print(s);

            Iterator<Integer> i = adj[s].listIterator();   //add the adjacency list of s which re not visited to queue, and mark as visited
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args){
        GraphBFS g = new GraphBFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);



    }

}
