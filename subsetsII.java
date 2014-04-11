public class Solution {
    void dfs(int[] number_array, int start, int number, ArrayList<Integer> array, ArrayList<ArrayList<Integer>> result) {
        if(array.size()==number) {
            result.add(new ArrayList<Integer>(array));
            return;
        }
        int i = start;
        while(i<number_array.length) {
            array.add(number_array[i]);
            dfs(number_array,i+1,number,array,result);
            array.remove(array.size()-1);
            while(i<(number_array.length-1)&&number_array[i]==number_array[i+1]) {
                i++;
            }
            i++;
        }
    }
    
    
    public  ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>       array = new ArrayList<Integer>();
        result.add(array);
        if(num==null) {
            return result;
        }
        Arrays.sort(num);
        for(int i=1;i<=num.length;i++) {
            array.clear();
            dfs(num,0,i,array,result);
        }
        return result;
    }
}
