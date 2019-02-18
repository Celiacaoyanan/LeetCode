class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board==null || board.length==0 || board[0].length==0) return true;
        //boolean[] visited=new boolean[9];
        
        //row
        for (int i=0;i<9;i++) {
            boolean[] visited=new boolean[9];
            for (int j=0;j<9;j++) {
                if (!helper(visited,board[i][j])) return false;
            }
        }
        
        //column
        for (int i=0;i<9;i++) {
            boolean[] visited=new boolean[9];
            for (int j=0;j<9;j++) {
                if (!helper(visited,board[j][i])) return false;
            }
        }
        
        //3x3 box
        for (int i=0;i<9;i+=3) {
            for (int j=0;j<9;j+=3) {
                boolean[] visited=new boolean[9];
                for (int k=0;k<9;k++) {
                    if (!helper(visited,board[i+k/3][j+k%3])) return false; // way to traverse 3x3 box
                }
            }
        }
        return true;
    }
    
    public boolean helper(boolean[] v, char c) {
        if (c=='.') return true;
        int num=c-'0';
        if (v[num-1]==true) return false;
        v[num-1]=true;
        return true;
    }
}
