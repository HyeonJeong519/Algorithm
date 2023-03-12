//단지번호붙이기

import java.io.*;
import java.util.*;

public class BJ_2667 {
    static int n;
    static int[][] map;
    static int[][] visit;
    static ArrayList<Integer> result = new ArrayList<>();

    static int[] dist_y = {1, 0, -1, 0};
    static int[] dist_x = {0, 1, 0, -1};
    static int cnt = 0;

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int bfs(Point start) {
        Queue<Point> queue = new LinkedList<>();
        int r =0;
        queue.offer(start);
        visit[start.y][start.x] =1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            r++;
            for (int i = 0; i < 4; i++) {
                int col = p.y + dist_y[i];
                int row = p.x + dist_x[i];
                if (col >= n || col < 0 | row < 0 || row >= n) continue;
                if (visit[col][row] == 1) continue;
                if (map[col][row] == 0) continue;
                visit[col][row] = 1;
                queue.offer(new Point(col, row));
            }
        }
        return r;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                int num = Character.getNumericValue(s.charAt(j));
                map[i][j] = num;
                if (num == 0)
                    visit[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0||visit[i][j]==1) continue;
                result.add(bfs(new Point(i, j)));
                cnt++;
            }
        }
        Collections.sort(result);
        System.out.println(cnt);
        for(int i=0;i<result.size();i++)
            System.out.println(result.get(i));
    }

}
