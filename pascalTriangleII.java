//O(N) Space Complexity
//O(N) Time Complexity
public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        if(rowIndex<0) {
            return null;
        }
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++) {
            array.add(1);
            for(int j=i-1;j>0;j--) {
                int tmp = array.get(j) + array.get(j-1);
                array.set(j,tmp);
            }
        }
        return array;
    }
}
