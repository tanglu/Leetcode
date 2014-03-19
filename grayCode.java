//一道模拟题，以3位格雷码为例。
//0 0 0
//0 0 1
//0 1 1
//0 1 0
//1 1 0
//1 1 1
//1 0 1
//1 0 0
//可以看到第n位的格雷码，等于n-1位格雷码 加上 1<<(n-1)和n-1位格雷码的逆序。


public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        if(n==0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        
        ArrayList<Integer> tmp = grayCode(n-1);
        int addNumber = 1 << (n-1);
        ArrayList<Integer> result = new ArrayList<Integer>(tmp);
        for(int i=tmp.size()-1;i>=0;i--) {
            result.add(addNumber + tmp.get(i));
        }
        return result;
    }
}

