import java.util.*;
class NumberOfIslandsBFS {
    //https://leetcode.com/problems/number-of-islands/
    int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] != '1') continue;
                // bfs
                count++;
                bfs(row, col, grid);
            }
        }
        return count;
    }
    public void bfs(int row, int col, char[][] grid){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = 'x';
        while(!queue.isEmpty()){
            int[] island = queue.removeFirst();
            int r = island[0];
            int c = island[1];
            if(c+1 < n && grid[r][c+1] == '1'){
                queue.add(new int[]{r, c+1});
                grid[r][c+1] = 'x';
            }
            if(c-1 >= 0 && grid[r][c-1] == '1'){
                queue.add(new int[]{r, c-1});
                grid[r][c-1] = 'x';
            }
            if(r+1 < m && grid[r+1][c] == '1'){
                queue.add(new int[]{r+1, c});
                grid[r+1][c] = 'x';
            }
            if(r-1 >= 0 && grid[r-1][c] == '1'){
                queue.add(new int[]{r-1, c});
                grid[r-1][c] = 'x';
            }
        }
    }
}
