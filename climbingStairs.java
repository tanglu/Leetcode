public class Solution {
    public int climbStairs(int n) {
        /* //TLE 
        if(n<=2) {
            return n;
        }
        return climbStairs(n-1) + climbStairs(n - 2);*/
        if(n<=2) {
            return n;
        }
        int first = 1;
        int second = 2;
        int result;
        for(int i=3;i<=n;i++) {
            result = first + second;
            first  = second;
            second = result;
        }
        return result;
    }
}
