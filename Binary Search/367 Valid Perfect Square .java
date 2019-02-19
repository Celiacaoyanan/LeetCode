class Solution {
    public boolean isPerfectSquare(int num) {
        if (num==1)
        {
            return true;
        }
        
        long start=1; // 有相乘的情况注意int是否会溢出，要令成long
        long end=num;
        long mid;
        while (start+1<end)
        {
            mid=start+(end-start)/2;            
            if (mid*mid==num)
            {
                return true;
            } else if (mid*mid<num)
            {
                start=mid;
            } else if (mid*mid>num)
            {
                end=mid;
            }
        }
        
        if (start*start==num)
        {
            return true;
        }
        
        if (end*end==num)
        {
            return true;
        }
        
        return false;
    }
}
