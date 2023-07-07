import java.io.*;
import java.util.*;

public class BJ_10815 {
    static int n;
    static int m;
    static int start;
    static int end;
    static int mid;

    static int[] have;
    static int[] cards;

    static int[] answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //상근이가 보유한 숫자카드 입력
        n = Integer.parseInt(br.readLine());
        have = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            have[i] = Integer.parseInt(st.nextToken());
        }
        //보유한 숫자카드 정렬
        Arrays.sort(have);

        //숫자카드에 적혀있는 수 입력
        m = Integer.parseInt(br.readLine());
        cards = new int[m];
        //정답 배열 선언
        answer = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int key = cards[i];

            start = 0;
            end = n - 1;

            while(start <= end){

                mid = (start + end) / 2;

                if (have[mid] > key) {
                    end = mid - 1;
                }
                else if (have[mid] < key) {
                    start = mid + 1;
                }
                else {
                    answer[i] = 1;
                    break;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            System.out.println(answer[i]);
        }
    }
}
