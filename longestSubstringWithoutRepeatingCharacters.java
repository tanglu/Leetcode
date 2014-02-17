//时间复杂度O(n)，空间复杂度是常数

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null) {
            return 0;
        }
        if(s.length()==1) {
            return 1;
        }
        int length = 0;
        int max = 0;
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        int start = 0;
        int end   = 0;
        while(end<s.length()) {
            if(hash.get(s.charAt(end))!=null){
                start = hash.get(s.charAt(end)) + 1;
                end   = start;
                hash.clear();
                continue;
            }
            else {
                hash.put(s.charAt(end),end);
                if((end - start + 1)>max) {
                    max = end - start + 1;
                }
                end++;
            }
        }
        return max;
    }
}
