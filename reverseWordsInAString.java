

public class Solution {
    public String reverseWords(String s) {
        if(s==null) {
            return s;
        }
        
        int begin = 0;
        int end   = 0;
        while(begin<s.length()&&s.charAt(begin)==' ') {
            begin++;
        }
        if(begin==s.length()) {
            return "";
        }
        
        if(s.length()<=1) {
            return s;
        }
        StringBuilder result = new StringBuilder("");
        while(begin<s.length()&&end<s.length()) {
            while(begin<s.length()&&s.charAt(begin)==' ') {
                begin++;
            }
            if(begin==s.length()) {
                break;
            }
            end = begin + 1;
            while(end<s.length()&&s.charAt(end)!=' ') {
                end++;
            }
            if(result.length()!=0) {
                result.insert(0," ");
            }
            if(end<s.length()) {
                result.insert(0,s.substring(begin,end));
            } else {
                result.insert(0,s.substring(begin,s.length()));
                break;
            }
            begin = end + 1;
        }
        return result.toString();
    }
}
