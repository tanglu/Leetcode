public class Solution {
    double pow_recursion(double x, int n) {
        if (n==0) {
            return 1.0;
        } 
        
        double tmp = pow_recursion(x,n/2);
        if (n%2==0) {
            return tmp*tmp;
        } else {
            return tmp*tmp*x;
        }
    }
    
    public double pow(double x, int n) {
        if(n==0) {
            return 1;
        }
        if(n<0) {
            return 1.0/pow_recursion(x,-n);
        } else {
            return pow_recursion(x,n);
        }
    }
}
