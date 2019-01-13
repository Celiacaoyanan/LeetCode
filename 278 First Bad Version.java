public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start=1;
        int end=n;
        int mid;
        while (start+1<end)
        {
            mid=start+(end-start)/2;
            if (isBadVersion(mid)==true) //始终记住是把mid的值和target比较
            {
                end=mid;
            }else
            {
                start=mid;
            }
        } //结束while循环时有两个值
        if (isBadVersion(start)==true)
        {
            return start;
        }
        return end;
    }
}
