import org.junit.Test;

public class LeetCode_36 {

    /**
     * 有效的数独
     */
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] boxs = new int[9][9];//子数独

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]!='.'){
                    int num = board[i][j] - '1';
                    if(rows[i][num]==1){
                        return false;
                    }else {
                        rows[i][num]=1;
                    }
                    if(cols[j][num]==1){
                        return false;
                    }else{
                        cols[j][num]=1;
                    }
                    int n = (i/3)*3 + j/3;
                    if(boxs[n][num]==1){
                        return false;
                    }else{
                        boxs[n][num]=1;
                    }
                }
            }
        }
        return true;
    }

    @Test
    public void test(){

    }
}
