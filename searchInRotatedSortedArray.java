public class Solution {
    public int search(int[] A, int target) {
        if(A==null||A.length==0) {
            return -1;
        }
        int begin = 0;
        int end   = A.length - 1;
        while(begin<=end) {
            int middle = begin + (end - begin)/2;
            if(A[middle]==target) {
                return middle;
            } else {
                if(A[begin]<=A[middle]) {
                    if(target>=A[begin]&&target<=A[middle]) {
                        end = middle - 1;
                    } else {
                        begin = middle + 1;
                    }
                } else {
                    if(target>A[middle]&&target<=A[end]) {
                        begin = middle + 1;
                    } else {
                        end = middle -1;
                    }
                }
            }
        }
        return -1;
    }
}
