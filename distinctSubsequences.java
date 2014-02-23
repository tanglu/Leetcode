//dynamic program
public class Solution {
    public int numDistinct(String S, String T) {
        if(S==null||T==null) {
            return 0;
        }
        
        if(S.length()<T.length()) {
            return 0;
        }
        
        int [][] dp = new int[S.length()+1][T.length()+1];
        dp[0][0] = 1;
        //It is only one way to change a i length string to "".
        for(int i=0;i<S.length();i++) {
            dp[i][0] = 1;    
        }
        //dp
        for(int i=1;i<=S.length();i++) {
            for(int j=1;j<=T.length();j++) {
                dp[i][j] = dp[i-1][j];
                if(S.charAt(i-1)==T.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[S.length()][T.length()];
    }
}
