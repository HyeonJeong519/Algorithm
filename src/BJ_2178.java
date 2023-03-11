import java.io.*;
import java.util.*;

public class BJ_2178 {
    static int n;
    static int m;

    static int[][] map;
    static int[][] visit;
    static Queue<Point> queue = new LinkedList<>();

    static int[] dist_y = {1, 0, -1, 0};
    static int[] dist_x = {0, 1, 0, -1};

    static class Point {
        int y;
        int x;
        int level;

        public Point(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    static int bfs(Point start) {
        int result = 0;
        queue.offer(start);
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            result = point.level;
            if (point.y == n - 1 && point.x == m - 1) break;
            for (int i = 0; i < 4; i++) {
                int row = point.y + dist_y[i];
                int col = point.x + dist_x[i];
                if (col < 0 || row < 0 || row >= n || col >= m) continue;
                if (visit[row][col] == 1) continue;
                if (map[row][col] == 0) continue;
                visit[row][col] = 1;
                queue.offer(new Point(row, col, point.level + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new int[n][m];

        for (int y = 0; y < n; y++) {
            String s = br.readLine();
            for (int x = 0; x < m; x++) {
                int num = Character.getNumericValue(s.charAt(x));
                map[y][x] = num;
                if (num == 0)
                    visit[y][x] = 1;
            }
        }
        Point point = new Point(0, 0, 1);
        System.out.println(bfs(point));
    }
}
