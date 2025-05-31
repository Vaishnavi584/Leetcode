class Solution {

    Map<String,Integer> map;
    public int findMaxForm(String[] strs, int m, int n) {
	
        if(strs.length == 0 || strs == null)return 0;
        map = new HashMap();
		
        return max(strs,m,n,0);
    }
    
    public int max(String[] strs, int m ,int n,int index){
	// If we are done with the our remaining zeros and ones return 0 as we cant get any furtherr strings.
        if(m == 0 && n == 0){
            return 0;
        }
        if(index >= strs.length)return 0;
		
        String key = m+"->"+n+"->"+index;
		
        if(map.containsKey(key)){
            return map.get(key);
        }
		
        int totalCount = 0;
		//For the current index count the required number of zeros and ones .
		
        String curr = strs[index];
        int ones = 0,zeros = 0;
		
        for(char c:curr.toCharArray()){
            if(c == '0')zeros++;
            else{
                ones++;
            }
          }
        int takenStringCount = 0;
		
		// if we have the  required number of zeros and ones  we take the current string and update the 
		// remaining zeros and ones and go to the next index;
		
        if(ones <= n && zeros <= m){
                takenStringCount = 1 + max(strs,m-zeros,n-ones,index+1);
        }
		// For every position we also the option to skip the current string ;
		
        int skippedStringNumber = max(strs,m,n,index+1);
		// We take the max of both the possible ways to get the maximum string which we can make .
		
        totalCount = Math.max(skippedStringNumber,takenStringCount);
		
        map.put(key,totalCount);
        return totalCount;
    }
}