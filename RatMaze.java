import java.util.ArrayList;
import java.util.List;

public class RatMaze {

    public static void main(String[] args) {
        int maze[][] = {
                { 1, 1, 1, 1, 0 },
                { 1, 0, 1, 1, 1 },
                { 1, 0, 1, 0, 1 },
                { 1, 1, 1, 1, 1 }
        };
        //System.out.println(findPath(maze, 0, 0));
        List<int[][]> out = new ArrayList<int[][]>();
        //out.add(new int[maze.length][maze[0].length]);
        System.out.println(findAllPaths(maze, 0, 0, out));
        for (int[][] is : out) {
            for (int[] is2 : is) {
                for (int is3 : is2) {
                    System.out.print(is3+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static boolean findPath(int[][] maze, int posX, int posY) {
        if (posX == maze.length - 1 && posY == maze[0].length - 1)
            return true;
        // if ( || ) return false;
        if (posX != maze.length - 1 && maze[posX + 1][posY] == 1 && findPath(maze, posX + 1, posY)) {
            return true;
        }
        if (posY != maze[0].length - 1 && maze[posX][posY + 1] == 1 && findPath(maze, posX, posY + 1))
            return true;

        return false;
    }

    public static boolean findAllPaths(int[][] maze, int posX, int posY, List<int[][]> out) {
        if (posX == maze.length - 1 && posY == maze[0].length - 1) {
            out.add(new int[maze.length][maze[0].length]);
            int ar[][] = out.get(out.size()-1);
            ar[posX][posY] = 1;
            ar[0][0]=1;
            out.set(out.size()-1, ar);
            
            return true;
        }
        boolean flag = false;
        if (posX != maze.length - 1 && maze[posX + 1][posY] == 1 && findAllPaths(maze, posX + 1, posY, out)) {
            int ar[][] = out.get(out.size()-1);
            ar[posX + 1][posY] = 1;
            out.set(out.size()-1, ar);
            flag = true;
        }
        if (posY != maze[0].length - 1 && 
          maze[posX][posY + 1] == 1 && 
          findAllPaths(maze, posX, posY + 1, out)) 
          {
            int s = flag?out.size()-2:out.size()-1;
            int ar[][] = out.get(s);
            ar[posX][posY + 1] = 1;
            out.set(s, ar);
            //out.set(out.size()-2, ar);
            flag = true;
        }
        return flag;
    }
}
