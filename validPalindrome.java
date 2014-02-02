public class Solution {
    //preprocess
    String preProcess(String s) {
        StringBuffer result = new StringBuffer(s);
        int start = 0;
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9')) {
                if (Character.isUpperCase(ch)) {
                    result.setCharAt(start++, Character.toLowerCase(ch));
                } else {
                    result.setCharAt(start++, ch);
                }
            }
        }
        //System.out.println(result.substring(0, result));
        return result.toString().substring(0, start);
    }
    
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==1) {
            return true;
        }
        String temp = preProcess(s);
        //check s is a palindrome or not
        for(int i=0;i<temp.length()/2;i++) {
            if(temp.charAt(i)==temp.charAt(temp.length()-1-i)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
