import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_5427 {
    static char[][] map;
    static int[][] visit;
    static int h;
    static int w;

    static int[] dist_x = {1, 0, -1, 0};
    static int[] dist_y = {0, 1, 0, -1};

    static class Point {
        int y; int x; int level;
        public Point(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    public int bfs() {

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visit = new int[h][w];
            for (int y = 0; y < h; y++) {
                String s = br.readLine();
                for (int x = 0; x < w; x++) {
                    char ch = s.charAt(x);
                    if (ch == '#') visit[y][x] = 1;

                    map[y][x] = ch;
                }
            }
        }
    }
}
