public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ret = "";
        if(strs==null||strs.length==0) {
            return ret;
        }
        
        if(strs.length==1) {
            return strs[0];
        }
        
        int i = 0;
        int j = 0;
        while(i<strs[0].length()) {
            for(j=0;j<strs.length;j++) {
                if(i<strs[j].length()&&strs[j].charAt(i)==strs[0].charAt(i)){
                    continue;
                }
                break;
            }
            if(j==strs.length) {
                i++;    
            }else 
                break;
        }
        return strs[0].substring(0,i);
    }
}
