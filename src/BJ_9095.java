import java.io.*;

public class BJ_9095 {
    static int[] test;
    static int[] memory;

    static int dp(int n) {
        if(memory[n] != 0) return memory[n];
        else {
            return memory[n] = dp(n-1)+ dp(n-2);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        test = new int[t];
        memory = new int[t];
        for (int i = 0; i < t; i++) {
            test[i] = Integer.parseInt(br.readLine());
        }
    }
}
