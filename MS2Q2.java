import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;


public class MS2Q2 {
    static HashSet<Position> set = new HashSet<>();
    public int solution(String[] R) {
        char [][] grid = new char[R.length][];
        for (int i = 0; i < R.length; i++) {
            grid[i]=R[i].toCharArray();
        }
        // boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        HashMap<String,Character> vis = new HashMap<>(); // Key = "x,y", value = direction
        findPaths(grid, 0, 0, 'R', vis);
        return set.size();

    }

    // directions =
    // 'R' = right
    // 'L' = left
    // 'U' = up
    // 'D' = down
    static void findPaths(char[][] grid, int x, int y, char dir, HashMap<String,Character> vis) {
        
        String coor = x+","+y+","+dir; 
        if (vis.containsKey(coor)) return;
        
        // if out of bounds - we are at invalid location - return to prev and cdirection
        if (x==grid.length) {
            findPaths(grid, x-1, y, 'D', vis); 
            return;
        }
        else if (y==grid[0].length) {
            findPaths(grid, x, y-1, 'L', vis);
            return;
        }
        else if (x<0) {
            findPaths(grid, x+1, y, 'U', vis);
            return;
        }
        else if (y<0) {
            findPaths(grid, x, y+1, 'R', vis);
            return;
        }
        
        vis.put(coor,dir);
        if (grid[x][y] == 'X') { // when we hit an X
            if (dir == 'R') {
                findPaths(grid, x-1, y, 'D', vis); 
            } else if (dir == 'L') {
                findPaths(grid, x+1, y, 'U', vis);
            } else if (dir == 'U') {
                findPaths(grid, x, y-1, 'R', vis);
            } else {
                findPaths(grid, x, y+1, 'L', vis);
            }
        }
        else {
            Position p = new Position(x, y);
            set.add(p);
            if (dir == 'R') {
                findPaths(grid, x, y+1, dir, vis); 
            } else if (dir == 'L') {
                findPaths(grid, x, y-1, dir, vis);
            } else if (dir == 'U') {
                findPaths(grid, x-1, y, dir, vis);
            } else {
                findPaths(grid, x+1, y, dir, vis);
            }
        }
    }
}

class Position {
    int x;
    int y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int hashCode() {
        return Objects.hashCode(this.x) * Objects.hashCode(this.y);
    }
    public boolean equals(Object o) {
        Position other = (Position) o;
        return other.x == this.x && other.y == this.y;
    }
}
