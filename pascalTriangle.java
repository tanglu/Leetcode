public class Solution {
    public static ArrayList<ArrayList<Integer>> generate(int numRows) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(numRows);;
        if(numRows==0) {
            return result;
        }

        for(int i=0;i<numRows;i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(i+1);
            tmp.add(1);
            for (int j=1;j<i;j++) {
                tmp.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            if(i>=1) {
                tmp.add(1);
            }
            result.add(tmp);
        }
        return result;
    }
}
