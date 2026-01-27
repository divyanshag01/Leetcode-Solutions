class Solution {
    public boolean generate(char[][] board,int row,int col){
        if(row == 9){
            return true;
        }
        if(col==9){
            return generate(board,row+1,0);
        }
        if(board[row][col]!='.'){
            return generate(board,row,col+1);
        }
        for(int i = 1;i<=9;i++){
            if(!isSafe(board,row,col,i)) continue;
            board[row][col]=(char)(i+'0');
            if(generate(board,row,col+1)){
                return true;
            }
            board[row][col]='.';
        }
        return false;
    }
    public boolean isSafe(char[][] board,int row,int col,int value){
        // if(board[row][col]!='.'){
        //     return false;
        // }
        for(int i = 0;i<9;i++){
            if(board[row][i]==(char)(value+'0')){
                return false;
            }
        }
        for(int i = 0;i<9;i++){
            if(board[i][col]==(char)(value+'0')){
                return false;
            }
        }
        int startrow = (row/3) *3;
        int startcol = (col/3) *3;
        for(int i = startrow;i<startrow+3;i++){
            for(int j = startcol;j<startcol+3;j++){
                if(board[i][j]==(char)(value+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        generate(board,0,0);
    }
}