public class Solution {
    void permuteArray(int [] num, int begin,ArrayList<ArrayList<Integer>> result) {
        if(begin==num.length-1) {
            ArrayList<Integer> tempResult = new ArrayList<Integer>();
            for(int i=0;i<num.length;i++) {
                tempResult.add(num[i]);
            }
            result.add(tempResult);
            return;
        }
        int temp;
        for(int i=begin;i<num.length;i++) {
            temp = num[begin];
            num[begin] = num[i];
            num[i] = temp;
            permuteArray(num, begin+1,result);
            temp = num[begin];
            num[begin] = num[i];
            num[i] = temp;
        }
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) { 
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permuteArray(num,0,result);
        return result;
    }
    
}
