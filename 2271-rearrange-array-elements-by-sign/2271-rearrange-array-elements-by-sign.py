class Solution(object):
    def rearrangeArray(self, nums):
        pos=[]
        neg=[]
        ans=[]
        p=0
        q=0
        for i in range(0,len(nums)):
            if(nums[i]>0):
                pos.append(nums[i])
            if(nums[i]<0):
                neg.append(nums[i])
        for j in range(0,len(nums)):
            if(j%2==0 or j==0):
                ans.append(pos[p])
                p+=1
            else:
                ans.append(neg[q])
                q+=1
        return ans
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        