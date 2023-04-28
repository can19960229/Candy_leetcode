import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int n = scanner.nextInt();
        int[] time = new int[n + 1];
        int[] reward = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            time[i] = scanner.nextInt();
            reward[i] = scanner.nextInt();
        }
        int[][] dp = new int[n + 1][T + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= T; j++) {
                if (j >= time[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time[i]] + reward[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[n][T]);
    }
}
