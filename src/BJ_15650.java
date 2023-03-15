import java.io.*;
import java.util.*;

//N과 M (2)
// 무순서 start = i : 중복허용
// 무순서 start = i+1 : 중복불가
// 순서 visit[]X : 중복허용
// 순서 visit[] : 중복불가

public class BJ_15650 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static Stack<Integer> store = new Stack<>();

    static int n;
    static int m;

    static void run(int level, int start) throws IOException {
        if (level == n) {
            for (int a : store) {
                bw.write(a + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = start; i < m; i++) {
            store.push(arr[i]);
            run(level + 1, i + 1);
            store.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = i+1;
        }

        run(0, 0);


        bw.close();
        br.close();
    }
}
