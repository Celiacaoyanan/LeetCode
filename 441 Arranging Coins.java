//1+2+3+......+x+y=n, for 1~x, the number of coins are same as stair index, so 1+2+3+......+x<=0, now we use binary search to find x.
//If (1+mid)*mid<=n, that means x >=mid, so we need to search the range [mid, end], so we move start to mid.

class Solution {
    public int arrangeCoins(int n) {
        if (n==1)
        {
            return 1;
        }
        
        long start=1;
        long end=n;
        long mid;
        while (start+1<end)
        {
            mid=start+(end-start)/2;
            if ((1+mid)*mid<=2*(long)n) //Note: same type to be compared, so n needs to be transferred to long
            {
                start=mid;
            } else 
            {
                end=mid;
            }
        }

        if ((1+end)*end<=2*n)
        {
            return (int)end; //Note: return type is int, remember to change back
        }
        
        return (int)start;
    }
}
