import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2170 {
    static int n;
    static Point[] arr;

    static class Point{
        int start; int end;
        public Point(int x,int y) {
            this.start = x;
            this.end = y;
        }
    }

    static int  calculate() {
        int s = arr[0].start;
        int e = arr[0].end;
        int len = e - s;

        for (int i = 1; i < n; i++) {
            if (e < arr[i].start) {
                s = arr[i].start;
                e = arr[i].end;
                len += e - s;
                continue;
            }
            if (e < arr[i].end) {
                len += arr[i].end - e;
                e = arr[i].end;
            }
        }

        return len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new Point[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Point(x, y);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.start == b.start) {
                return Integer.compare(a.end, b.end);
            }
            return Integer.compare(a.start, b.start);
        });

        System.out.println(calculate());

    }
}
