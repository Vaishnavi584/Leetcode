class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set=new TreeSet<>();
        for(int i:nums)
        set.add(i);
        int n=set.size();
        List<Integer> list=new ArrayList<>(set);
        if(n>=3)
        return list.get(n-3);
        else
        return list.get(n-1);
    }
}