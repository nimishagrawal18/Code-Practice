package Blind75;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;


// https://leetcode.com/problems/course-schedule/
public class CourseSched {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); // To store the adjacency lists
        int[] indeg = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][1]))
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indeg[prerequisites[i][0]]++;
        }
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        for (int i = 0; i < indeg.length; i++) {
            // indeg[i]=map.get(i).size();
            if (indeg[i]==0) Q.add(i);
        }
        int c = 0;
        while(!Q.isEmpty()) {
            int u = Q.pop();
            if (map.get(u)!=null)
            for(int x :map.get(u)) {
                indeg[x]--;
                if(indeg[x]==0) Q.add(x);
            }
            c++;
        }
        return c==numCourses;
        
    }
    public static void main(String[] args) {
        System.out.println(canFinish(5, new int[][]{{1,0},{2,0},{3,1},{1,4},{4,3}}));
    }
}


/*
public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][0]))
                map.put(prerequisites[i][0], new ArrayList<Integer>());
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        HashSet<Integer> vis = new HashSet<>();
        int curr=0;
        boolean res = true;
        for(int i=0;i<numCourses;i++) {
            if(!canFinish(i, map, vis)) {
                res=false;
                break;
            }
        }
        return res;
    }
    static boolean canFinish(int course, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> vis) {
        if (vis.contains(course)) return false; 
        vis.add(course);
        if (!map.containsKey(course) || map.get(course).isEmpty()) return true;
        for ( int x : map.get(course) ) {
            if (canFinish(x, map, vis)) {
                map.get(course).remove((Integer)x);
            }
        }
        return map.get(course).isEmpty()?true:false;
    }

*/