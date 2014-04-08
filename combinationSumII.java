public class Solution {
    
    void dfs(ArrayList<Integer>num, int target, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> result) {
        if(target==0) {
            result.add(array);
            return;
        }
        
        if(num.size()==0||num.get(0)>target) {
            return;
        }
        
        for(int i=0;i<num.size();i++) {
            if(num.get(i)<=target) {
                ArrayList<Integer> newArray = new ArrayList<Integer>(array);
                newArray.add(num.get(i));
                ArrayList<Integer> newNum = new ArrayList<Integer>(num);
                newNum.remove(i);
                dfs(newNum, target - num.get(i), newArray, result);
            }
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
         //List<Integer> numList = Arrays.asList(num);  
         ArrayList<Integer> numList = new ArrayList<Integer>();
         for(int i=0;i<num.length;i++) {
             numList.add(num[i]);
         }
         dfs(numList,target,array,result); 
         return result;
    }
}
