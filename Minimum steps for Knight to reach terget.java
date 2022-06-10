/*
Given a square chessboard of N x N size, the position of Knight and position of a target is given. We need to find out the minimum steps a Knight will take to reach the target position
We use BFS for solution.
*/
import java.util.*;
class Solution {
	static class cell {
		int x, y;
		int dis;

		public cell(int x, int y, int dis){
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}

	static boolean isInside(int x, int y, int N){
		if (x >= 1 && x <= N && y >= 1 && y <= N)
			return true;
		return false;
	}


	static int minStepToReachTarget( int knightPos[], int targetPos[], int N){
		// x and y direction, where a knight can move
		int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
		int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

		Queue<cell> q = new LinkedList<>();
		boolean visit[][] = new boolean[N + 1][N + 1];
		cell t;
		int x, y;

		q.offer(new cell(knightPos[0], knightPos[1], 0));
		visit[knightPos[0]][knightPos[1]] = true;

		while (!q.isEmpty()) {
			t = q.poll();
			if (t.x == targetPos[0] && t.y == targetPos[1]) return t.dis;

			for (int i = 0; i < 8; i++) {
				x = t.x + dx[i];
				y = t.y + dy[i];
				if (isInside(x, y, N) && !visit[x][y]) {
					visit[x][y] = true;
					q.add(new cell(x, y, t.dis + 1));
				}
			}
		}
		return Integer.MAX_VALUE;
	}

	public static void main(String[] args){
		int N = 30;
		int knightPos[] = { 1, 1 };
		int targetPos[] = { 30, 30 };
		System.out.println( minStepToReachTarget(knightPos, targetPos, N));
	}
}

