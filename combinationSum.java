public class Solution {
    void dfs(int [] candidates, int target, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> ret) {
        if(target==0) {
            ret.add(array);
            return;
        }
        
        for(int i=0;i<candidates.length;i++) {
            
            if(array.size()>0) {
                int tmp =  array.get(array.size() - 1);
                if(candidates[i]<=target&&candidates[i]>=tmp) {
                    ArrayList<Integer> array_next = new ArrayList<Integer>(array);
                    array_next.add(candidates[i]);
                    dfs(candidates, target - candidates[i], array_next, ret);
                }
            
            } else {
                if(candidates[i]<=target) {
                    ArrayList<Integer> array_next = new ArrayList<Integer>(array);
                    array_next.add(candidates[i]);
                    dfs(candidates, target - candidates[i], array_next, ret);
                }
            }
        }
        
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        
        if(candidates==null||candidates.length==0) {
            return ret;    
        }
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        dfs(candidates, target, array, ret);
        
        return ret;
    }
}
