// similar to 95, 96 ask the number
//f(i) stores number of unique BST that stores values 1...i, 
//f[3] = f[0]*f[2] (1 as root) + f[1]*f[1] (2 as root) + f[2]*f[0] (3 as root)
//f(i)=f(0)*(i-1)  左子树0个，右子树i-1个  + f(1)*f(i-2)  左子树1个，右子树i-2个 +....f(i-1)*f(0)
//比如有i个node，从左到右，依次当root
class Solution {
    public int numTrees(int n) {
        if (n==0 || n==1) return 1;
        int[] f=new int[n+1];
        f[0]=1;
        f[1]=1;
        for (int i=2;i<=n;i++) {
            for (int j=0;j<i;j++) {
                f[i]+=f[j]*f[i-1-j];
            }
        }
        return f[n];
    }
}
