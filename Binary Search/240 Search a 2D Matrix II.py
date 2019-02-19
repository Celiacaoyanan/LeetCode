class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        # sepcial case []
        if (len(matrix)==0 or matrix==None):  
            return False
        
        # special case [[],[]]
        flag=0
        for m in matrix:
            if len(m)!=0:
                flag=1
                break
        if flag==0:
            return False
        
        m=len(matrix)
        n=len(matrix[0])       
        i=m-1
        j=0
        while (i>=0 and j<=n-1):
            if (target==matrix[i][j]):
                return True
            elif (target<matrix[i][j]):
                i-=1
            else:
                j+=1
        return False
