//动态规划
//matched[l1][l2] = s1[l1-1] == s3[l1+l2-1] && matched[l1-1][l2] || s2[l2 - 1] == s3[l1+l2-1] && matched[l1][l2-1]


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null||s2==null||s3==null) {
            return false;
        }
        if(s3.length()!=(s1.length()+s2.length())) {
            return false;
        }
        
        boolean[][] matched = new boolean[s1.length()+1][s2.length()+1];
        
        matched[0][0] = true;
        
        for(int i1 = 1; i1 <= s1.length(); i1++){
            if(s3.charAt(i1-1) == s1.charAt(i1-1)) {
                matched[i1][0] = true;
            }
            else 
                break;
        }
        
        for(int i2 = 1; i2 <= s2.length(); i2++){
            if(s3.charAt(i2 - 1) == s2.charAt(i2 - 1)) {
                matched[0][i2] = true;
            }
            else 
                break;
        }

        for(int i=1;i<=s1.length();i++) {
            for(int j=1;j<=s2.length();j++) {
                if(s1.charAt(i-1)==s3.charAt(i+j-1)) {
                    matched[i][j] |= matched[i-1][j];
                }
                if(s2.charAt(j-1)==s3.charAt(i+j-1)) {
                    matched[i][j] |= matched[i][j-1];
                }
            }
        }
        return matched[s1.length()][s2.length()];
    
    }
}
