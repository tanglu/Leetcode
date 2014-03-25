//回文字符串划分
//动态规划生成回文字符串数组
//根据数组用深度搜索生成回文字符串的划分

public class Solution {
    //生成标志回文字符串的数组，partitioning_map[i][j]=1的话，表明：string[i..j]是一个回文字符串
    void dp(String s, char [][] palindrome_map) {
        for(int i=s.length()-1;i>=0;i--) {
            for(int j=i;j<s.length();j++) {
                if(i==j) {
                    palindrome_map[i][j] = 1;
                } else {
                    if(s.charAt(i)==s.charAt(j)) {
                        if(j==i+1||palindrome_map[i+1][j-1]==1) {
                            palindrome_map[i][j] = 1;
                        }
                    }
                }
            }
        }
    }
    
    //根据生成好的标记回文字符串的数组进行划分
    void dfs(String s, int begin, char [][] palindrome_map, ArrayList<String> array, ArrayList<ArrayList<String>> result) {
        if(begin==s.length()) {
            result.add(array);
            return;
        }
        
        for(int i=begin;i<s.length();i++) {
            if(palindrome_map[begin][i]==1) {
                ArrayList<String> tmp = new ArrayList<String>(array);
                tmp.add(s.substring(begin,i+1));
                dfs(s,i+1,palindrome_map,tmp, result);
            }
        }
    }
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> array = new ArrayList<String>();

        if(s==null||s.length()==0) {
            result.add(array);
            return result;
        }
        char [][] palindrome_map = new char[s.length()][s.length()];
        
        dp(s, palindrome_map);
        dfs(s,0,palindrome_map,array,result);
        return result;
    }
}
