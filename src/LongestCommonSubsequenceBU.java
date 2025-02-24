class LongestCommonSubsequenceBU {
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];  // Match case
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);  // No match
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace")); // Output: 3
        System.out.println(longestCommonSubsequence("abc", "abc"));   // Output: 3
        System.out.println(longestCommonSubsequence("abc", "def"));   // Output: 0
    }
}