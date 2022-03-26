package Blind75;

import java.util.ArrayDeque;

public class NumIslands {
    public static int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int c = 0;
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[0].length; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    dfs(i, j, grid, vis);
                    c++;
                }
            }
        }
        return c;
    }

    private static void dfs(int i, int j, char[][] grid, int[][] vis) {
        ArrayDeque<Pair> Q = new ArrayDeque<>();
        Pair pair = new Pair(i, j);
        
        Q.add(pair);
        // vis[i][j]=1;
        while(!Q.isEmpty()) {
            pair = Q.poll();
            vis[pair.i][pair.j] = 1;
            if (pair.i>0 && 
                vis[pair.i-1][pair.j]!=1 && 
                grid[pair.i-1][pair.j]=='1') 
                {
                Q.add(new Pair(pair.i-1, pair.j));
                vis[pair.i-1][pair.j]=1;
            }
            if (pair.i<grid.length-1 && vis[pair.i+1][pair.j]!=1 && 
                grid[pair.i+1][pair.j]=='1') 
                {
                Q.add(new Pair(pair.i+1, pair.j));
                vis[pair.i+1][pair.j]=1;
            }
            if (pair.j>0 && vis[pair.i][pair.j-1]!=1 && grid[pair.i][pair.j-1]=='1') {
                Q.add(new Pair(pair.i, pair.j-1));
                vis[pair.i][pair.j-1]=1;
            }
            if (pair.j<grid[0].length-1 && vis[pair.i][pair.j+1]!=1 && grid[pair.i][pair.j+1]=='1') {
                Q.add(new Pair(pair.i, pair.j+1));
                vis[pair.i][pair.j+1]=1;
            }
        }
        
        // dfs(i, j, grid, vis, Q);
    }

    // private static void dfs(int i, int j, char[][] grid, int[][] vis, ArrayDeque<Integer[]> Q) {
    //     if (grid[i][j] == '0')
    //         return;
    //     vis[i][j]=1;
    //     if (i > 0)
    //         dfs(i - 1, j, grid, vis);
    //     if (i < vis.length - 1)
    //         dfs(i + 1, j, grid, vis);
    //     if (j > 0)
    //         dfs(i, j - 1, grid, vis);
    //     if (j < vis[0].length)
    //         dfs(i, j + 1, grid, vis);
        
    // }

    public static void main(String[] args) {
        char[][] ar = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println(numIslands(ar));
    }
}
class Pair {
    int i;
    int j;
    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
    
}