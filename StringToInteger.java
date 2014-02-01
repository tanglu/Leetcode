public class Solution {
    public int atoi(String str) {
         int     result = 0;
        short   sign = 1;
        int     i = 0;
        boolean begin_num = false;
        
        while(i<str.length()&&str.charAt(i)==' ') {
            i++;
        }
        if(i<str.length()&&str.charAt(i)=='+'){
            i++;
        }
        if(i<str.length()&&str.charAt(i)=='-'){
            sign = -1;
            i++;
        }
        while(i<str.length()) {    
            if(str.charAt(i)>'9'||str.charAt(i)<'0') {
                break;
            }
            if(result> Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && Integer.MAX_VALUE%10 < (str.charAt(i) - '0'))) {
                if (sign==1)
                    return Integer.MAX_VALUE;
                else 
                    return Integer.MIN_VALUE;
            }
            result = result*10 + str.charAt(i) - '0';
            i++;
        }
        
        result = result * sign;
        return result;
    }
}
