//Note: there might be duplicates in letters[]. Char type can be compared directly
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (target>=letters[letters.length-1] || target<letters[0])
        {
            return letters[0];
        }
        
        int start=0;
        int end=letters.length-1;
        int mid;
        while(start+1<end)
        {
            mid=start+(end-start)/2;
            if (target>=letters[mid]) // Note: when target=letters[mid], the smallest letter grater than target must be in right range, ["e","e","e","e","e","e","n","n","n","n"], target=e, output=n
            {
                start=mid;
            } else if (target<letters[mid])
            {
                end=mid;
            }
        }
        
        if (letters[start]>target)
        {
            return letters[start];
        }
        return letters[end];

            
    }
}
