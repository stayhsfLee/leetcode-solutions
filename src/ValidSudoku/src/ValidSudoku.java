package ValidSudoku.src;

import java.util.HashSet;

/**
 * Created by Moopa on 31/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        //开始对数独进行验证
        //主要就是对三种情况进行验证,横,竖,cube内


        for(int i =0;i<9;i++){
            //行
            HashSet<Character> hashSet = new HashSet<>();
            //列
            HashSet<Character> hashSet1 = new HashSet<>();
            //cube
            HashSet<Character> hashSet2 = new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j] != '.' && !hashSet.add(board[i][j])){
                    return false;
                }
                if(board[j][i] != '.' && !hashSet1.add(board[j][i])){
                    return false;
                }

                //i就相当于是cube对应的序号
                int row = i/3*3+j/3;
                int col = j%3+i%3*3;
                if(board[row][col] != '.' && !hashSet2.add(board[row][col])){
                    return false;
                }

            }
        }


        return true;
    }
}
