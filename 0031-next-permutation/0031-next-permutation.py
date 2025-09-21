class Solution(object):
    def swap(self,n,a,b):
        temp=n[a]
        n[a]=n[b]
        n[b]=temp
    def reverse(self,n,s):
        start=s
        end=len(n)-1
        while(start<end):
            self.swap(n,start,end)
            start+=1
            end-=1

    def nextPermutation(self, nums):
        i = len(nums)-2
        while(i>=0 and nums[i]>=nums[i+1]):
            i-=1
        if i >= 0:
            j=len(nums)-1
            while(j>=0 and nums[j]<=nums[i]):
                 j-=1
            self.swap(nums,i,j)
        self.reverse(nums,i+1)
        return nums

        