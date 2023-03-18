import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_15651 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int[] visit;
    static Stack<Integer> store = new Stack<>();

    static int n;
    static int m;

    static void run(int level) throws IOException {
        if (level == n) {
            for (int a : store) {
                bw.write(a + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 0; i < m; i++) {
            store.push(arr[i]);
            run(level + 1);
            store.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visit = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = i+1;
        }

        run(0);


        bw.close();
        br.close();
    }
}
