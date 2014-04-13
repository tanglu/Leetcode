public class Solution {
    
     boolean isValidSudoku(char[][] board, int a, int b) {  
        int i,j;  
        for(i = 0; i < 9; i++)  
            if(i != a && board[i][b] == board[a][b])  
                return false;  
  
        for(j = 0; j < 9; j++)  
            if(j != b && board[a][j] == board[a][b])  
                return false;  
  
        int x = a/3*3;  
        int y = b/3*3;  
        for(i = 0; i < 3; i++)  
            for(j = 0; j< 3; j++)  
                if(x+i != a && y+j != b && board[x+i][y+j] == board[a][b])  
                    return false;  
        return true;  
    }  
    
    boolean dfs(int M,int N, char [][] board) {
        if(M==9&&N==0) {
            return true;
        }

        if(board[M][N]=='.') {
            for(int j=1;j<=9;j++) {
                board[M][N] = (char) ('0' + j);
                if(isValidSudoku(board,M,N)) {
                    int tempM = M,tempN;
                    if(N==8) {
                        tempM = M + 1;
                        tempN = 0;
                    } else {
                        tempN = N + 1;
                    }
                    if(dfs(tempM,tempN,board)==true) {
                        return true;   
                    }
                }
                board[M][N] = '.';
            }
        } else {
            int tempM = M,tempN;
            if(N==8) {
                tempM = M + 1;
                tempN = 0;
            } else {
                tempN = N + 1;
            }
            return dfs(tempM,tempN,board);
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        if(board==null||board.length!=9||board[0].length!=9) {
            return;
        }
        dfs(0,0,board);    
    }
}
