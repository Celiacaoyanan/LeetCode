// using i <= x / i for comparison, instead of i * i <= x, to avoid exceeding integer upper limit. 用i*i时提交失败
class Solution {
    public int mySqrt(int x) {
        if (x==1 || x==0)
        {
            return x;
        }
        
        int start=1;
        int end=x;
        int mid;
        while (start+1<end)
        {
            mid=start+(end-start)/2;
            if (mid==x/mid)
            {
                return mid;
            } else if (mid>x/mid)
            {
                end=mid;
            } else if (mid<x/mid)
            {
                start=mid;
            }
        }
        
        if (end<=x/end)
        {
            return end;
        }
        return start;          
    }
}

//如果要比较相乘，就要把start、end、mid令成long
class Solution {
    public int mySqrt(int x) {
        if (x==1 || x==0)
        {
            return x;
        }
        
        long start=1;
        long end=x;
        long mid;
        while (start+1<end)
        {
            mid=start+(end-start)/2;
            if (mid*mid==x)
            {
                return (int)mid; //注意强制转换类型的写法 (int)x
            } else if (mid*mid>x)
            {
                end=mid;
            } else if (mid*mid<x)
            {
                start=mid;
            }
        }
        
        if (end*end<=x)
        {
            return (int)end;
        }
        return (int)start;          
    }
}
