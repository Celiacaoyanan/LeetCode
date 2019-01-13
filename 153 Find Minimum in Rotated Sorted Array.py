class Solution(object):            
    def findMin(self, nums):                         
        """                                              
        :type nums: List[int]
        :rtype: int
        """                                         
        if (len(nums)==0):                                                  
            return None 
        start=0
        end=len(nums)-1
       target=nums[end]
        while (start+1<end):
            mid=start+(end-start)/2
            if(target>nums[mid]):# no duplicate, so no need to consider about =
                end=mid
            else:
                start=mid
        if (nums[start]<=target):
            return nums[start]
        return nums[end]
