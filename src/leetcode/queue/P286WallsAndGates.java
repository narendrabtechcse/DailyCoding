package leetcode.queue;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
286. Walls and Gates
Medium

You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
 */
public class P286WallsAndGates {

    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(
      new int[] {1,0},
      new int[] {-1,0},
      new int[] {0,1},
      new int[] {0,-1}
    );

    public void wallsAndGates(int[][] rooms)
    {
        int m = rooms.length;
        if(m==0) return;

        int n = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for(int row=0;row<m;row++)
        {
            for (int col=0;col<n;col++)
            {
                if(rooms[row][col] == GATE)
                {
                    queue.add(new int[]{row,col});
                }
            }
        }

        while(!queue.isEmpty())
        {
            int[] point = queue.poll();

            int row = point[0];
            int col = point[1];

            for(int[] direction : DIRECTIONS)
            {
                int r = row + direction[0];
                int c = col + direction[1];

                if(r<0 || c<0 || r>=m || c>=n || rooms[r][c] != EMPTY)
                {
                    continue;
                }

                rooms[r][c] = rooms[row][col] + 1;
                queue.add(new int[] {r,c});

            }
        }
    }
}
