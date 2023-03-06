import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1926 {
    static Queue<Point> queue = new LinkedList<Point>();
    static int[][] array;
    static int[] dist_x = {1, 0, -1, 0};
    static int[] dist_y = {0, 1, 0, -1};
    static int area = 0;

    static void bfs(int[][] array, int n, int m) {
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();

            area++;

            int row = point.x;
            int col = point.y;

            array[row][col] = 0;

            for (int i = 0; i < 4; i++) {
                int x = row + dist_x[i];
                int y = col + dist_y[i];
                if (x > n || x < 0 || y > m || y < 0)
                    continue;
                else {
                    if (array[x][y] == 1)
                        queue.add(new Point(x, y));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new int[n][m];

        // 배열 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(array,n,m);
        System.out.println(area);
    }
}
