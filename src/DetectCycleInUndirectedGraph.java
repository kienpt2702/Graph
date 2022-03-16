import java.util.ArrayList;
import java.util.HashSet;
//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/#
class DetectCycleInUndirectedGraph {
    // Function to detect cycle in an undirected graph.
    // public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    //     // Code here
    //     // bfs
    //     LinkedList<Integer> queue = new LinkedList<>();
    //     int[] edgeTo = new int[V];
    //     HashSet<Integer> visited = new HashSet<>();
    //     for(int v = 0; v < V; v++){
    //         if(visited.contains(v)) continue;
    //         queue.add(v);
    //         visited.add(v);
    //         while(!queue.isEmpty()){
    //             int length = queue.size();
    //             for(int j = 0; j < length; j++){
    //                 int parent = queue.removeFirst();
    //                 for(int adjNode: adj.get(parent)){
    //                     if(!visited.contains(adjNode)){
    //                         edgeTo[adjNode] = parent; 
    //                         queue.add(adjNode);
    //                         visited.add(adjNode);
    //                     }// if visited, then the adjNode should be the node that parent comes from
    //                     // which should be adjNode == edgeTo(parent);
    //                     else if(adjNode != edgeTo(parent)) return true;
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }

    boolean isCycle = false;
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        HashSet<Integer> visited = new HashSet<>();
        int[] edgeTo = new int[V];
        for(int v = 0; v < V; v++){
            if(isCycle) return true;
            if(!visited.contains(v)){
                dfs(v, edgeTo, adj, visited);
            }
        }
        return isCycle;

    }
    public void dfs(int v, int[] edgeTo, ArrayList<ArrayList<Integer>> adj, HashSet<Integer> visited){

        visited.add(v);
        for(int i: adj.get(v)){
            // check whether adj node i is parent node of v. if it is, then not doing anything
            if(i == edgeTo[v]) continue;
            // may contains self cycle; if we have already visited a neibor node of v, then exist a path that not from v to i
            if(i == v || visited.contains(i)){
                isCycle = true;
                return;
            }
            edgeTo[i] = v;
            dfs(i, edgeTo, adj, visited);
        }
    }
}