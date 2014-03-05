//计数排序需要扫描两遍
//类似于快排，只扫描一遍数组

public class Solution {
    void swap(int [] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public void sortColors(int[] A) {
        if(A==null||A.length==0) {
            return;
        }
        
        int begin = 0;
        int end   = A.length - 1;
        int iter = 0;
        
        while(iter<=end) {
            if(A[iter]==0) {
                swap(A,iter,begin);
                iter++;
                begin++;
                continue;
            }
            if(A[iter]==2) {
                swap(A,iter,end);
                end--;
                continue;
            }
            if(A[iter]==1) {
                iter++;
            }
        }
        
    }
}
