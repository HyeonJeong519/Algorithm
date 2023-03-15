import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9663 {
    static int n;
    static int[] visit;
    static int result = 0;

    static class Point{
        int y; int x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static void run(int level, int m) {
        if (level == n) {
            return;
        }

        for (int i = 0; i < n; i++) {
            visit[level] = i;
            if(checkX(visit[level]))
                run(level + 1, m + 1);
        }
    }

    static boolean checkX(int x){
        for (int i = 0; i < n; i++) {
            if (visit[i] == x) return false;
        }
        return true;
    }

    /*static boolean checkCross(){

    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visit = new int[n];

        run(0, 0);

        System.out.println(result);
    }
}
