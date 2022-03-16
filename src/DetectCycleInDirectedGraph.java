import java.util.ArrayList;
import java.util.HashSet;
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1/
public class DetectCycleInDirectedGraph {
    // Function to detect cycle in a directed graph.
    // int[] status;
    // int notVisited = 0; int beingProcessed = 1; int visited = 2;
    // public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // code here
    //     status = new int[V];
    //     for(int v = 0; v < V; v++){
    //         if(status[v] == visited) continue;
    //         if(dfs(v, adj)) return true;
    //     }
    //     return false;
    // }
    // public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj){
    //     status[v] = beingProcessed;
    //     for(int adjNode: adj.get(v)){
    //         if(status[adjNode] == visited) continue;
    //         if(status[adjNode] == beingProcessed) return true;
    //         if(dfs(adjNode, adj)) return true;;
    //     }
    //     status[v] = visited;
    //     return false;
    // }
    // Function to detect cycle in a directed graph.
    HashSet<Integer> visited;
    boolean[] isOnStack;
    boolean isCyclic;
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        visited = new HashSet<>();
        isOnStack = new boolean[V];
        for(int v = 0; v < V; v++){
            if(isCyclic) return true;
            if(!visited.contains(v)) dfs(v, adj);
        }
        return false;
    }
    public void dfs(int v, ArrayList<ArrayList<Integer>> adj){
        visited.add(v);
        isOnStack[v] = true;
        for(int adjNode: adj.get(v)){
            if(isOnStack[adjNode]){
                isCyclic = true;
                return;
            }
            if(!visited.contains(adjNode)) dfs(adjNode, adj);
        }
        isOnStack[v] = false;
    }
}