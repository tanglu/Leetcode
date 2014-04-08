public class Solution {
    
    void dfs(int [] num, int start, int target, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> result) {
        if(target==0) {
            result.add(new ArrayList<Integer>(array));
            return;
        }
        
        if(start>=num.length||num[0]>target) {
            return;
        }
        int i = start;
        while(i<num.length) {
            if(num[i]<=target) {
                array.add(num[i]);
                dfs(num, i + 1, target - num[i], array, result);
                array.remove(array.size()-1);
                while(i<(num.length-1)&&num[i]==num[i+1]) {
                    i++;
                }
            }
            i++;
        }
    }
    
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
         ArrayList<Integer> array = new ArrayList<Integer>();
         if(num==null) {
             result.add(array);
             return result;
         }
         Arrays.sort(num);
         dfs(num,0, target,array,result); 
         return result;
    }
}
