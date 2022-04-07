package Blind75;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pacific-atlantic-water-flow/
public class PacificAtlantic {
    public static void main(String[] args) {
        int input[][] = 
        {
            {1,2,3},
            {8,9,4},
            {7,6,5}
        };
        // {
        //     { 1, 2, 2, 3, 5 },
        //     { 3, 2, 3, 4, 4 },
        //     { 2, 4, 5, 3, 1 },
        //     { 6, 7, 1, 4, 5 },
        //     { 5, 1, 1, 2, 4 }
        // };
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
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < atlantic[0].length; i++) {
            // if (!pacific[0][i])
                findPath(0, i, pacific, heights[0][i], heights);
            // if (!atlantic[heights.length-1][i])
                findPath(heights.length-1, i, atlantic, heights[heights.length-1][i], heights);
        }
        // for (int i = 0; i < atlantic.length; i++) {
        for (int i = atlantic.length-1; i>=0; i--) {
            // if (!pacific[i][0])
                findPath(i, 0, pacific, heights[i][0], heights);
            // if (!atlantic[i][heights[0].length-1])
                findPath(i, heights[0].length-1, atlantic, heights[i][heights[0].length-1], heights);
        }

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (atlantic[i][j] && pacific[i][j]) 
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

    public static void findPath(int r, int c, boolean[][] vis, int prev, int[][] heights) {
        if (r == vis.length || c == vis[0].length || r<0 || c<0 || vis[r][c] || heights[r][c]<prev) 
            return;
        vis[r][c] = true;
        findPath(r+1, c, vis, heights[r][c], heights);
        findPath(r, c+1, vis, heights[r][c], heights);
        findPath(r-1, c, vis, heights[r][c], heights);
        findPath(r, c-1, vis, heights[r][c], heights);
    }

    /* backup
    public static void findPath(int r, int c, boolean[][] vis, int prev, int[][] heights) {
        if (vis[r][c] || heights[r][c]<prev) 
            return;
        vis[r][c] = true;
        if (r< vis.length-1 && !vis[r+1][c]) findPath(r+1, c, vis, heights[r][c], heights);
        if (c< vis[0].length-1 && !vis[r][c+1]) findPath(r, c+1, vis, heights[r][c], heights);
        if (r>0 && !vis[r-1][c]) findPath(r-1, c, vis, heights[r][c], heights);
        if (c>0 && !vis[r][c-1]) findPath(r, c-1, vis, heights[r][c], heights);
    } */
}
