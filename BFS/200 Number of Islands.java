class Solution {
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;//note the order of 3 conditions, if grid.length==0, grid[0] index cant be reached
        
        int[][] visited=new int[grid.length][grid[0].length];
        int result=0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {               
                if (grid[i][j]=='1' && visited[i][j]==0) {
                    result++;
                    helper(grid,visited,i,j);
                }
            }
        }
        return result;
    }
    
    public void helper(char[][] grid, int[][] visited, int i, int j) {
        int[] dx={1,0,-1,0}; // method to check neighbor nodes
        int[] dy={0,1,0,-1};
        Queue<Integer> qx=new LinkedList<>();
        Queue<Integer> qy=new LinkedList<>();
        qx.offer(i);
        qy.offer(j);
        while (!qx.isEmpty()) {
            int x=qx.poll();
            int y=qy.poll();
            for (int k=0;k<4;k++) {
                int nx=x+dx[k];
                int ny=y+dy[k];
                if (nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && visited[nx][ny]==0 && grid[nx][ny]=='1') {
                    visited[nx][ny]=1;
                    qx.offer(nx);
                    qy.offer(ny);
                    
                }
            }
        }

    }       
}
