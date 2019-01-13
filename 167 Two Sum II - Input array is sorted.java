class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        
        if (numbers.length<2 || numbers==null)
        {
            return result;
        }
        
        int start=0;
        int end=numbers.length-1;
        while(start+1<end)
        {
            if(numbers[start]+numbers[end]==target)
            {
                result[0]=start+1; // +1 because not start from 0
                result[1]=end+1;
                return result;
            }else if(numbers[start]+numbers[end]<target)
            {
                start++;
            }else if(numbers[start]+numbers[end]>target)
            {
                end--;
            }
        } //when while finished, there are only 2 integers
        result[0]=start+1;
        result[1]=end+1;
        return result;
    }
}
