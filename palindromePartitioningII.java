public class Solution {
    public int minCut(String s) {
        if(s==null||s.length()==0||s.length()==1) {
            return 0;
        }
        int[][] palindrome_map = new int[s.length()][s.length()];
        int[] cut_num_array = new int[s.length() + 1];
        
        for(int i=s.length()-1;i>=0;i--) {
            cut_num_array[i] = s.length() - i;
            for(int j=i;j<s.length();j++) {
                if(s.charAt(i)==s.charAt(j)) {
                    if(j-i<2||palindrome_map[i+1][j-1]==1) {
                        palindrome_map[i][j]=1;
                        cut_num_array[i] = Math.min(cut_num_array[i], cut_num_array[j+1]+1);
                    }
                }
            }
            
        }
    
        return cut_num_array[0] - 1;
    }
}
