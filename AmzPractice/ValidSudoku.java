package AmzPractice;


import java.util.HashSet;

// https://leetcode.com/problems/valid-sudoku/
public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> hm = new HashSet<Character>();
        
        int XOff=0,YOff=0,count=0;
        char c;
        for (int box = 0; box < 9; box++) {
            for (int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    c=board[i+XOff][j+YOff];
                    if(c!='.') {
                        hm.add(board[i+XOff][j+YOff]);
                        count++;
                    }
                    if(count>hm.size()) return false;
                }
            }
            hm.clear();
            count=0;
            XOff+=3;
            if(XOff%9==0) {
                XOff%=9;
                YOff+=3;
            }
        } // Box check
        // hm.clear();

        for (int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                c=board[i][j];
                if(c!='.') {
                    hm.add(board[i][j]);
                    count++;
                }
                if(count>hm.size()) return false;
            }
            hm.clear();
            count=0;
        }

        for(int j=0;j<9;j++) {
            for (int i=0;i<9;i++) {
                c=board[i][j];
                if(c!='.') {
                    hm.add(board[i][j]);
                    count++;
                }
                if(count>hm.size()) return false;
            }
            hm.clear();
            count=0;
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'}
            ,{'6','.','.','1','9','5','.','.','.'}
            ,{'.','9','8','.','.','.','.','6','.'}
            ,{'8','.','.','.','6','.','.','.','3'}
            ,{'4','.','.','8','.','3','.','.','1'}
            ,{'7','.','.','.','2','.','.','.','6'}
            ,{'.','6','.','.','.','.','2','8','.'}
            ,{'.','.','.','4','1','9','.','.','5'}
            ,{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
