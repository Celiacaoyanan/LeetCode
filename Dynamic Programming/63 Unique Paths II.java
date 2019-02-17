//similar to 62. f[i][j] represent number of paths from (0,0) to (i,j), considering the last step, it can be down or right, so if its not obstacle, then f[i][j] = f[i-1][j] + f[i][j-1], otherwise f[i][j]=0;
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid==null || obstacleGrid.length==0 || obstacleGrid[0].length==0) return 0;
        int[][] f=new int[obstacleGrid.length][obstacleGrid[0].length];
        
        for (int i=0;i<obstacleGrid.length;i++) {
            if (obstacleGrid[i][0]!=1) {
                f[i][0]=1;
            } else {
                break;
            }
        }
    
        for (int i=0;i<obstacleGrid[0].length;i++) {
            if (obstacleGrid[0][i]!=1) {
                f[0][i]=1;
            } else {
                break;
            }
        } 
        
        for (int i=1;i<obstacleGrid.length;i++) {
            for (int j=1;j<obstacleGrid[0].length;j++) {
                if (obstacleGrid[i][j]!=1) {
                    f[i][j]=f[i-1][j]+f[i][j-1];
                } else {
                    f[i][j]=0;
                }
            }
        }
        return f[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
