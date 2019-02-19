//For every house, we calculate the heater that is closest to it and get this closest distance, so every house has one closest distance, and among all these distances, we find the largest one.  For a certain house, we use binary search on heaters[] to find the heater that is closest to that house.
//Note: Arrays.sort()    Integer.MIN_VALUE   Math.min(a,b)   Math.max(a,b)   Math.abs(a-b)
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters); //apply binary search on heater, so heater must be in order
        int radius=Integer.MIN_VALUE; //we need calculate max later, so here we use min
        if (houses.length==0)
        {
            return 0;
        }
        
        for (int i=0; i<houses.length; i++)
        {
            int distance=findDistance(houses[i], heaters);
            radius=Math.max(radius,distance);
        }
        
        return radius;
    }
    
    public int findDistance(int house, int[] heaters)
    {
        int start=0;
        int end=heaters.length-1;
        int mid;
        while (start+1<end)
        {
            mid=start+(end-start)/2;
            if (heaters[mid]==house)
            {
                return 0;
            } else if (house>heaters[mid])
            {
                start=mid;
            } else if (house<heaters[mid])
            {
                end=mid;
            }
        }
        return Math.min(Math.abs(house-heaters[start]), Math.abs(house-heaters[end]));
    }
}
