public class Solution {
    public int climbStairs(int n) {
        /* //TLE 
        if(n<=2) {
            return n;
        }
        return climbStairs(n-1) + climbStairs(n - 2);*/
        int pre = 1;
        int result = 2;
        if(n<=2) {
            return n;
        } 
        
        for(int i=3;i<=n;i++) {
            result = pre + result;
            pre = result - pre;
        }
        return result;
    }
}
