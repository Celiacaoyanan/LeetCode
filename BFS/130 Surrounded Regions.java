// for all the O on the border, find its adjacent O and set them to * (include the border O), so all * turn into O, all the others turn into X. The key point is that, we are not trying to find connected O,instead, we are finding O that connect with border O, and make sure they stay the same. 
class Solution {
    public void solve(char[][] board) {
        int n=board.length;//number of rows
        if (n==0) {
            return;
        }
        int m=board[0].length;//number of columns
        
        for (int i=0;i<n;i++) {
            bfs(board,i,0);
            bfs(board,i,m-1);
        }
        
        for (int j=0;j<m;j++) {
            bfs(board,0,j);
            bfs(board,n-1,j);
        }
        
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (board[i][j]=='*') {
                    board[i][j]='O';
                } else {
                    board[i][j]='X';
                }
            }
        }
        
    }
    
    
    public void bfs(char[][] board, int x, int y) {
        if (board[x][y]!='O') return;
        Queue<Integer> qx=new LinkedList<Integer>();        
        Queue<Integer> qy=new LinkedList<Integer>();        
        qx.offer(x);
        qy.offer(y);
        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};
        int n=board.length;
        int m=board[0].length;
        board[x][y]='*';
        
        while (!qx.isEmpty()) {
            int xx=qx.poll();
            int yy=qy.poll();
            for (int i=0;i<4;i++) {
                int xxx=xx+dx[i];
                int yyy=yy+dy[i];
                if (xxx>=0 && xxx<n && yyy>=0 && yyy<m && board[xxx][yyy]=='O') {
                    board[xxx][yyy]='*';
                    qx.offer(xxx);
                    qy.offer(yyy);
                }
            }
            
        }

        
    }
}
