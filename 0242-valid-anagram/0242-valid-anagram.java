class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()==0 || t.length()==0){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        HashMap<Character,Integer> s1 = new HashMap<>();
        HashMap<Character,Integer> s2=new HashMap<>();
        getfreq(s1,s);
        getfreq(s2,t);
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!s1.get(ch).equals(s2.get(ch))){
                 return false;
            }
            
        }
        return true;
    }
    static void getfreq(HashMap<Character, Integer> s1, String s){
        for (int i =0 ; i<s.length();i++){
            if(s1.containsKey(s.charAt(i))){
                s1.put(s.charAt(i),s1.get(s.charAt(i))+1);
            }else{
                s1.put(s.charAt(i),1);
            }
        }

    }

}