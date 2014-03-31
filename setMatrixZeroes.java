public class Solution {
    public void setZeroesColumn(int[][] matrix, int column) {
        for(int i=0;i<matrix.length;i++) {
            matrix[i][column] = 0;
        }
    }
    public void setZeroesRow(int[][] matrix, int row) {
        for(int i=0;i<matrix[0].length;i++) {
            matrix[row][i] = 0;
        }
    }
    
    public void setZeroes(int[][] matrix) {
        int i = 0;
        int j = 0;
        boolean row_zero    = false;
        boolean column_zero = false;
        while(i<matrix.length){
            j = 0;
            while(j<matrix[0].length) {
                if(matrix[i][j]==0) {
                    if(i!=0) {
                        matrix[i][0] = 0;
                    } else {
                        row_zero = true;
                    }
                    if(j!=0) {
                        matrix[0][j] = 0;
                    } else {
                        column_zero = true;
                    }
                }
                j++;
            }
            i++;
        }
        
        for(i=1;i<matrix[0].length;i++) {
            if(matrix[0][i]==0) {
                setZeroesColumn(matrix,i);
            }
        }
        if(row_zero==true) {
            setZeroesRow(matrix,0);
        }
        
        for(i=1;i<matrix.length;i++) {
            if(matrix[i][0]==0) {
                setZeroesRow(matrix,i);
            }
        }
        if(column_zero==true) {
            setZeroesColumn(matrix,0);
        }
    }
}
