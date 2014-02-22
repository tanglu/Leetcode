//the lowest acceptance rates of Leetcode
//first use bfs the create a two dimensional array
// use bfs the find all such possible sentences constructed by words in dictionary


public class Solution {
    int [] state; 
    HashMap<Integer, ArrayList<Integer>> wordsMap = new  HashMap<Integer, ArrayList<Integer>>();
    
    public  void dp(String s, Set<String> dict) {
        int i = 0;
        for(i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(state[j]==1&&dict.contains(s.substring(j,i))) {
                    state[i] = 1;
                    ArrayList<Integer> array = wordsMap.get(i);
                    if(array==null) {
                        array = new ArrayList<Integer>();
                        array.add(j);
                        wordsMap.put(i, array);
                    } else {
                        array.add(j);
                    }                
                }
            }
        }
    }
    
    
    public  ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        if (s==null || s.length()==0 ||dict.size()==0 ) {
            return ret;
        }
        state = new int [s.length() + 1];
        state[0] = 1;
        
        StringBuilder cur = new StringBuilder();
        dp(s,dict);
        if(state[s.length()]!=1) {
            return ret;
        }
        dfs(s, s.length(), cur, ret, dict);
        return ret;
    }

    public  void dfs(String s, int start, StringBuilder cur, ArrayList<String> ret, Set<String> dict)  {
        StringBuilder tmp = new StringBuilder(cur);
        if(start==0) {
            ret.add(new String(cur));
            return;
        }
        ArrayList<Integer> array = wordsMap.get(start);
        for(int i=0;i<array.size();i++) {
                StringBuilder tt = new StringBuilder(cur);
                if(tt.length()!=0) {
                    tt = tt.insert(0," ");
                }
                tt.insert(0,s.substring(array.get(i),start));
                dfs(s, array.get(i),tt,ret,dict);
        } 
    }
}
