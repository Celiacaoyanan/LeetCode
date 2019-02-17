//f[i][j] represent number of paths from (0,0) to (i,j), considering the last step, it can be down or right, //so f[i][j] = f[i-1][j] + f[i][j-1];
class Solution {
    public int uniquePaths(int m, int n) {
        if (m==0 || n==0) return 0;
        int[][] f=new int[n][m];
        
        //初始状态
        for (int i=0;i<m;i++) {
            f[i][0]=1;
        }
        for (int i=0;i<n;i++) {
            f[0][i]=1;
        }
        
        //f[][] top-down, i/j start from 1 not 0
        for (int i=1;i<n;i++) {//row
            for (int j=1;j<m;j++) {//column
                f[i][j]=f[i-1][j]+f[i][j-1];
            }
        }
        
        return f[n-1][m-1];
    }
}
