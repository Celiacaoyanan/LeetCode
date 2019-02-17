class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle==null || triangle.size()==0 || triangle.get(0)==null || triangle.get(0).size()==0) return -1;
        int n=triangle.size();
        
        int[][] f=new int[n][n];
        f[0][0]=triangle.get(0).get(0);
        for (int i=1;i<n;i++) {
            f[i][0]=f[i-1][0]+triangle.get(i).get(0);
            f[i][i]=f[i-1][i-1]+triangle.get(i).get(i);//注意此处这个边界是f[i][i]
        }
        
        for (int i=1;i<n;i++) {
            for (int j=1;j<i;j++) {// for every row, the number of column is the index of row
                f[i][j]=Math.min(f[i-1][j],f[i-1][j-1])+triangle.get(i).get(j);
            }
        }
        
        int min=f[n-1][0];
        for (int k=0;k<n;k++) {//the # of columns in the last row is equal to the # of rows
            if (f[n-1][k]<min) {
                min=f[n-1][k];
            }
        }
        return min;
    }
}
