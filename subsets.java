public class Solution {
    void dfs(int [] number_array, int start, int number, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> result) {
        if(number==array.size()) {
            result.add(new ArrayList<Integer>(array));
            return;
        }
        
        for(int i=start;i<number_array.length;i++) {
            array.add(number_array[i]);
            dfs(number_array,i+1,number,array,result);
            array.remove(array.size()-1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
          ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
          ArrayList<Integer> array = new ArrayList<Integer>();
          result.add(array);
          if(S==null) {
              return result;
          }
          Arrays.sort(S);
          for(int i=1;i<=S.length;i++) {
              array.clear();
              dfs(S,0,i,array,result);
          }
          return result;
    }
}
