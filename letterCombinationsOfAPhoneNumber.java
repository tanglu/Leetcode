public class Solution {
    String[] array = {" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    void dfs(String digits, String str, ArrayList<String> ret) {
        if(digits.length()==0) {
            ret.add(str);
            return; 
        }
        
        String changed = array[Character.getNumericValue(digits.charAt(0))];
        for(int i=0;i<changed.length();i++) {
            //str += new String(changed.charAt(i));
            dfs(digits.substring(1),str + Character.toString(changed.charAt(i)), ret);
        }
    }
    
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> ret = new ArrayList<String>();
        
        if(digits==null) {
            return ret;
        }
        if(digits.length()==0) {
            ret.add("");
            return ret;
        }
        String str = "";
        dfs(digits, str, ret);
        
        return ret;
    }
}
