public class NumberOfIslandsDFS {
    //https://leetcode.com/problems/number-of-islands/
    int m,n;
     public int numIslands(char[][] grid) {
         int count = 0;
         m = grid.length;
         n = grid[0].length;
         for(int row = 0; row < m; row++){
             for(int col = 0; col < n; col++){
                 if(grid[row][col] != '1') continue;
                 dfs(row, col, grid);
                 count++;
             }
         }
         return count;
     }
     public void dfs(int row, int col, char[][] grid){
         if(row < 0 || row >= m || col < 0 || col >= n  || grid[row][col] != '1') return;
         // by marking island by x (int = 1), we do not need to visit again and dont need hashset -> constant space
         grid[row][col] = 'x';
         dfs(row, col+1, grid);
         dfs(row, col-1, grid);
         dfs(row+1, col, grid);
         dfs(row-1, col, grid);
     }
}
