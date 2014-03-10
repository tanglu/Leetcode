//动态规划求解走的方法
//从[1,1,]开始
public class Solution {
    //dp
    //pathNum[i][j] = pathNum[i-1][j] + pathNum[i][j-1]
    public int uniquePaths(int m, int n) {
        
        int [][] pathNum = new int [m+1][n+1];

        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(i==1&&j==1) {
                    pathNum[1][1] = 1;
                    continue;
                }
                pathNum[i][j] = pathNum[i-1][j] + pathNum[i][j-1];
            }
        }
        return pathNum[m][n];
    }
}
