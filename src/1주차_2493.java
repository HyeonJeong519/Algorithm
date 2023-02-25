import java.io.*;
import java.util.*;

public class BJ_2493 {
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Long> tower = new ArrayList<>();
    static int[] answer;

    static void compare(int n) {
        for (int i = n - 1; i > -1; i--) {
            // 스택이 빌 때까지 스택의 피크값(인덱스) 위치의 탑과 현재 인덱스의 탑의 값 비교
            // 현재 위치가 더 큰 경우 결과값 저장하는 배열의 스택에 저장된 인덱스를 가져와 그 위치에 탑의 위치 저장
            while (!stack.isEmpty()) {
                if((tower.get(stack.peek())) < tower.get(i)) {
                    answer[stack.peek()] = i + 1;
                    stack.pop();
                }
                else break;
            }
            // 스택에 현재 인덱스 값 입력
            stack.push(i);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        answer = new int[n];
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            tower.add(Long.parseLong(st.nextToken()));
        }

        compare(n);

        for (int i = 0; i < n; i++)
            System.out.print(answer[i] + " ");

    }
}
