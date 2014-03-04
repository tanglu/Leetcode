//动态规划，类似于爬楼梯问题

public class Solution {
    public int numDecodings(String s) {
        if(s==null) {
            return 0;
        }
        if(s.length()==0) {
            return s.length();
        }

        if(s.length()==1) {
            if(s.equals("0")) {
                return 0;
            }
            return s.length();
        }
        
        int [] number = new int[s.length() + 1];
        number[0] = 1;
        number[1] = 1;
        int tmp;
        for(int i=2;i<=s.length();i++) {
            if((i+1)<=s.length()) {
                tmp = Integer.parseInt(s.substring(i-1,i+1));
            } else {
                tmp = Integer.parseInt(s.substring(i-2,s.length()));
            }
            if(tmp==0) {
                return 0;
            }
            if(tmp==10) {
                number[i] += number[i-2];
                continue;
            } else {
                number[i] = number[i-1];   
                if(tmp>0&&tmp<=26) {
                    number[i] += number[i-2];
                }
            }
        }
        return number[s.length()];
    }
}
