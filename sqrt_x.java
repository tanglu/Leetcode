public class Solution {
    public int sqrt(int x) {
        if(x<=1) {
            return x;
        }
        
        int begin = 1;
        int end   = x;
        int middle = 0;
        while(begin<=end) {
            middle = begin + (end - begin)/2;
            if(middle==x/middle) {
                return middle;
            } else {
                if (middle<x/middle) {
                    begin = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
            
        } 
        return end;
    }
}
