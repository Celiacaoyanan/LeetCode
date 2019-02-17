class Solution {
    public int minPathSum(int[][] grid) {
        if (grid==null || grid.length==0 || grid[0].length==0) return 0;
        int[][] f=new int[grid.length][grid[0].length];
        
        f[0][0]=grid[0][0];
        for (int i=1;i<grid.length;i++) {
            f[i][0]=f[i-1][0]+grid[i][0];
        }
        for (int i=1;i<grid[0].length;i++) {
            
            f[0][i]=f[0][i-1]+grid[0][i];
        }
        
        for (int i=1;i<grid.length;i++) {
            for (int j=1;j<grid[0].length;j++) {
                f[i][j]=Math.min(f[i-1][j],f[i][j-1])+grid[i][j];
            }
        }
        return f[grid.length-1][grid[0].length-1];
    }
}
