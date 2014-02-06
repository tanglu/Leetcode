
//============================================================================
// dfs  TLE
// dynamic programming O(n2) time
// state[i] = 1 means s[0..i] can be break by the words in dict
// state[i] = 1 if state[j]==1&&string[j,i-1] contained in dict 0<=j<i
// please rem: there is one difference between state and string
//============================================================================

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(dict.isEmpty()) {
            return false;
        }
        if(s.length()==0) {
            return true;
        }
        
        int[] state = new int[s.length() + 1];
        state[0] = 1;
        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(state[j]==1&&(dict.contains(s.substring(j,i))==true)) {
                    state[i] = 1;
                    break;
                }
            }
        }
        if(state[s.length()]==1) {
            return true;
        } else {
            return false;
        }
    }
}
