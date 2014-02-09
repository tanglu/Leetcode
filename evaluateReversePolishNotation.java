public class Solution {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Stack stack = new Stack();
        for(int i=0;i<tokens.length;i++) {
            //operator
            if(tokens[i].equals("+")==true||tokens[i].equals("-")==true||tokens[i].equals("*")==true||tokens[i].equals("/")==true) {
                int tmp  = (int)stack.pop();
                int tmp1 = (int)stack.pop();
                switch(tokens[i].charAt(0)) {
                    case '+' : 
                        stack.push(tmp1+tmp);
                        break;
                    case '-' : 
                        stack.push(tmp1-tmp);
                        break;
                    case '*' : 
                        stack.push(tmp1*tmp);
                        break;
                    case '/' : 
                        stack.push(tmp1/tmp);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        result = (int)stack.pop();
        return result;
    }
}
