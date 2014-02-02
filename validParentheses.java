public class Solution {
    public boolean isValid(String s) {
                Stack<Character> stack = new Stack<Character>(); 
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='(') {
                stack.push(s.charAt(i));
            }
            if(s.charAt(i)==']'||s.charAt(i)=='}'||s.charAt(i)==')') {
                if(stack.empty()) {
                    return false;
                }
            }
            
            if(s.charAt(i)==']') {
                char tmp = stack.pop();
                if(tmp=='[') {
                    continue;
                } else{
                    return false;
                }
            }
            if(s.charAt(i)=='}') {
                char tmp = stack.pop();
                if(tmp=='{') {
                    continue;
                }else{
                    return false;
                }
            }
            if(s.charAt(i)==')') {
                char tmp = stack.pop();
                if(tmp=='(') {
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(stack.empty())
            return true;
        else
            return false;
    }
}
