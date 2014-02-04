public class Solution {
    
    public int singleNumber(int[] A) {
        int result = 0;
        int[] array = new int[32];
        
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<32;j++) {
                int rotated = A[i] >> j;
                if(rotated==0)
                    break;
                array[j]+=rotated&1;
            }
        }
        
        for(int i=0;i<32;i++) {
            if(array[i]%3!=0) {
                result += 1<<i;
            }
        }
        return result;
    }
}
