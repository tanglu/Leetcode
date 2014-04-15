public class Solution {
    void dfs(int left, int right, int n, String str, ArrayList<String> ret) {
        if(left==n&&right==n) {
            ret.add(str);
            return;
        }
        
        //left>=right
        if(left>right&&left<n) {
            dfs(left + 1, right, n, str + "(" , ret);
            dfs(left, right + 1, n, str + ")" , ret);
        } else {
            if(left==right) {
                dfs(left + 1, right, n, str + "(" , ret);
            } else {
                dfs(left, right + 1, n, str + ")" , ret);
            }
        }
    }
    
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> ret = new ArrayList<String>();
        if(n==0) {
            return ret;
        }
        dfs(0,0,n,"",ret);
        return ret;
    }
}
