class Solution {
    int[] result=null;
    public int climbStairs(int n) {
        if (n==0 || n==1) return 1;
        result=new int[n+1];
        for (int i=0;i<=n;i++) {
            result[i]=-1;
        }
        helper(n);
        return result[n];
    }
    
//function of helper is to calculate number of ways to reach to m and put the result in result[m]  
//result[m]=-1 means number of ways to reach mth stair hasn’t been calculated  
public void helper(int m) {
        if (result[m]!=-1) return;//the value has already been calculated and stored in result
        if (m==0 || m==1) {
            result[m]=1;
            return;
        }
        helper(m-2);
        helper(m-1);
        
        result[m]=result[m-2]+result[m-1];
    }
}
