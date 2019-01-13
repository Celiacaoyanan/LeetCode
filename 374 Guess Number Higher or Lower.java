public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start=1;
        int end=n;
        int mid;
        while (start+1<end)
        {
            mid=start+(end-start)/2;
            if (guess(mid)==0)
            {
                return mid;
            } else if (guess(mid)==-1)
            {
                end=mid;
            } else if (guess(mid)==1)
            {
                start=mid;
            }
        }
        
        if (guess(start)==0)
        {
            return start;
        }
        return end;
    }
}
