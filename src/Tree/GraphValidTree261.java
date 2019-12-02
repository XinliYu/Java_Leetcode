package Tree;

import java.util.*;

//Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
//
//Example 1:
//
//Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
//Output: true
//Example 2:
//
//Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
//Output: false

public class GraphValidTree261 {
    public boolean validTree(int n, int[][] edges){
        if(edges.length == 0) return n == 1;

        Map<Integer, List<Integer>> graph = new HashMap<>();   //map the nodes to all its neighboring nodes

        for (int[] edge:edges){               //for each edge
            List<Integer> neighbor1 = graph.getOrDefault(edge[0], new ArrayList<Integer>());    //create a list of its neighbors or get the list of its neighbors for edge[0]
            List<Integer> neighbor2 = graph.getOrDefault(edge[1], new ArrayList<Integer>());    //create a list of its neighbors or get the list of its neighbors for edge[1]

            neighbor1.add(edge[1]);
            neighbor2.add(edge[0]);
        }

        Queue<Integer> myqueue = new LinkedList<Integer>();  //all the reachable children nodes
        Set<Integer> visited = new HashSet<Integer>();         //all the visited nodes
        myqueue.offer(edges[0][0]);
        visited.add(edges[0][0]);
        int nodes = 0;  //nodes popped

        while (!myqueue.isEmpty()){
            int node = myqueue.poll();
            nodes++;

            for(int neighbor:graph.get(node)){
                if(myqueue.contains(neighbor)) return false;
                if(!visited.contains(neighbor)){
                    myqueue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return nodes == n;

    }


    public boolean validTree2(int n, int[][] edges) {
        if (edges.length == 0) {
            return n == 1;
        }
        if (n != edges.length + 1) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if (hasCycle(0, -1, graph, visited)) {
            return false;
        }
        return visited.size() == n;
    }

    private boolean hasCycle(int node, int parent, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent && visited.contains(neighbor)) {
                return true;
            }
            if (!visited.contains(neighbor) && hasCycle(neighbor, node, graph, visited)) {
                return true;
            }
        }
        return false;
    }



}
