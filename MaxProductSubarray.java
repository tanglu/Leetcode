public class Soluction {
  public int maxProduct(int A[]) {
    if(A==null||A.length==0) {
      return 0;
    }
  
    int max_temp = A[0];
    int min_temp = A[0];
    int result   = A[0];
    
    for(int i=1;i<A.length;i++) {
      int a = A[i]*max_temp;
      int b = A[i]*min_temp;
      
      max_temp = Math.max(Math.max(a,b), A[i]);
      min_temp = Math.min(Math.min(a,b), A[i]);
      result   = Math.max(result,max_temp);
    }
    
    return result;
  }
}
