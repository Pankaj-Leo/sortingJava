import java.util.*;

class CutRodSegments {
    public static int maxSegments(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);  // Fill with -1 to indicate unreachable states
        dp[0] = 0;  // Base case: 0-length rod has 0 segments

        for (int i = 0; i <= n; i++) {
            if (dp[i] != -1) {  // If this length is reachable
                if (i + x <= n)
                    dp[i + x] = Math.max(dp[i + x], dp[i] + 1);
                if (i + y <= n)
                    dp[i + y] = Math.max(dp[i + y], dp[i] + 1);
                if (i + z <= n)
                    dp[i + z] = Math.max(dp[i + z], dp[i] + 1);
            }
        }

        return dp[n] != -1 ? dp[n] : 0;  // If `n` is unreachable, return 0
    }

    public static void main(String[] args) {
        System.out.println(maxSegments(7, 5, 2, 3));  // Output: 3 (Segments: 2+2+3 or 5+2)
        System.out.println(maxSegments(10, 2, 3, 5)); // Output: 5 (Segments: 2+2+2+2+2)
    }
}