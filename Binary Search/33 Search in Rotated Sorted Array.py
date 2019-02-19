class Solution(object):
    def search(self, nums, target):                              
        """                                                            
        :type nums: List[int]                                           
        :type target: int                                          
        :rtype: bool
        """                                                       
        if len(nums)==0 or nums==None:            
            return -1                            
        start=0
        end=len(nums)-1
        while (start+1<end):
            mid=start+(end-start)/2
            if (nums[mid]==target):
                return mid
            if (nums[mid]>nums[start]): # case1
                if (target>=nums[start] and target<=nums[mid]):
                    end=mid
                else:
                    start=mid
            else: # case2
                if (target>=nums[mid] and target<=nums[end]):
                    start=mid
                else:
                    end=mid

        if (nums[start]==target):
            return start
        if (nums[end]==target):
            return end
        return -1
