//bfs 
class Pair {
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    public void solve(char[][] board) {
        if(board==null||board.length==0) {
            return;
        }
        Queue queue = new LinkedList<Pair>();

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(i==0||i==(board.length-1)||j==0||j==(board[0].length-1)) {
                    if(board[i][j]=='O') {
                        //bfs(board,i,j,change);
                        //bfs(board,i,j);
                        Pair position = new Pair(i,j);
                        queue.add(position);
                    }
                }
            }
        }
        int x1,y1;
        
        while(!queue.isEmpty()) {
            Pair position = (Pair)queue.poll();
            x1 = position.x;
            y1 = position.y;
            //change[x1][y1] = false;
            //left
            if(board[x1][y1]=='Y') {
                continue;
            }
            board[x1][y1] = 'Y';
            int index = x1 - 1;
            if(index>=0&&board[index][y1]=='O') {
                queue.add(new Pair(index,y1));
            }
            //right
            index = x1 + 1;
            if(index<board.length&&board[index][y1]=='O') {
                queue.add(new Pair(index,y1));
            }
            //up
            index = y1 + 1 ;
            if(index<board[0].length&&board[x1][index]=='O') {
                queue.add(new Pair(x1,index));
            }
            //down
            index = y1 - 1;
            if(index>=0&&board[x1][index]=='O') {
                queue.add(new Pair(x1,index));
            }
        }
        
        
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='Y') {
                    board[i][j] = 'O';
                } else {
                    if(board[i][j]=='O') {
                        board[i][j] = 'X';
                    }
                }
            }
        }
        return;
    }
}
