
public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }
        if(x<10) {
        	return true;
        }
        int tmp = x/10;
        int div = 1;
        int top;
        int end;
        //find the num of ten
        while(tmp!=0) {
            div = div * 10;
            tmp = tmp/10;
        }
        
        while(x>=10) {
        	top = x/div;
        	end = x%10;
        	if(top!=end) {
        		return false;
        	}
        	x = (x%div)/10;
        	div = div/100;
        }
        return true;
    }
}
