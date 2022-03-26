package Blind75;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pacific-atlantic-water-flow/submissions/

// This solves the problem in an overcomplicated way. Creating a new file to redo

public class PacificAtlanticOC {

    public static void main(String[] args) {
        int input[][] = 
        // {
        //     {1,2,3},
        //     {8,9,4},
        //     {7,6,5}
        // };
        {
                { 1, 2, 2, 3, 5 },
                { 3, 2, 3, 4, 4 },
                { 2, 4, 5, 3, 1 },
                { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 }
        };
        System.out.println(pacificAtlantic(input));
        // List<List<Integer>> out = pacificAtlantic(input);
        // for (List<Integer> list : out) {
        // for (Integer list2 : list) {
        // System.out.print(list2+ ",");
        // }
        // System.out.println("\b");
        // }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < atlantic.length; i++) {
            atlantic[i][atlantic[0].length - 1] = true;
            pacific[i][0] = true;
        }
        for (int i = 0; i < atlantic[0].length; i++) {
            atlantic[atlantic.length - 1][i] = true;
            pacific[0][i] = true;
        }
        checkAltantic(heights, 0, 0, atlantic);
        checkPacific(heights, heights.length - 1, heights[0].length - 1, pacific);

        // for (int i = 0; i < atlantic.length; i++) {
        //     for (int j = 0; j < atlantic[0].length; j++) {
        //         System.out.print(atlantic[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println("P=");
        // for (int i = 0; i < pacific.length; i++) {
        //     for (int j = 0; j < pacific[0].length; j++) {
        //         System.out.print(pacific[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if ((atlantic[i][j] && pacific[i][j]) 
                    // || (atlantic[i][j] && j<heights[0].length-1 && (pacific[i][j+1] && heights[i][j]>=heights[i][j+1])) ||
                    // (pacific[i][j] && i>0 && (pacific[i-1][j] && heights[i][j]>=heights[i-1][j]))
                    ) 
                    {
                    ArrayList<Integer> o = new ArrayList<Integer>();
                    o.add(i);
                    o.add(j);
                    out.add(o);
                }
            }
        }

        return out;
    }

    public static void checkAltantic(int[][] heights, int x, int y, boolean[][] possible) {
        if (x != heights.length - 1) {
            checkAltantic(heights, x + 1, y, possible);
            if (heights[x][y] >= heights[x + 1][y] && possible[x + 1][y]) {
                possible[x][y] = true;
                // return;
            }
        }
        if ( y != heights[0].length - 1) {
            checkAltantic(heights, x, y + 1, possible);
            if (heights[x][y] >= heights[x][y + 1] && possible[x][y + 1]) {
                possible[x][y] = true;
                // return;
            }
        }
    }

    public static void checkPacific(int[][] heights, int x, int y, boolean[][] possible) {
        if (x > 0) {
           checkPacific(heights, x - 1, y, possible);
           if (heights[x][y] >= heights[x - 1][y] && possible[x - 1][y]) {
               possible[x][y] = true;
               // return;
           }
       }
       if (y > 0) {
            checkPacific(heights, x, y - 1, possible);
            if (heights[x][y] >= heights[x][y - 1] && possible[x][y - 1]) {
                possible[x][y] = true;
            }
        }
    }
}
