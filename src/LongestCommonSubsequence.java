
import java.util.*;

public class LongestCommonSubsequence {
    private static int[][] memo;

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m][n]; // Memoization table
        for (int[] row : memo) {
            Arrays.fill(row, -1); // Initialize with -1 (uncomputed)
        }
        return lcs(text1, text2, 0, 0);
    }

    private static int lcs(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0; // Base case: End of one string
        }
        if (memo[i][j] != -1) {
            return memo[i][j]; // Return cached result
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + lcs(text1, text2, i + 1, j + 1);
        } else {
            memo[i][j] = Math.max(lcs(text1, text2, i + 1, j), lcs(text1, text2, i, j + 1));
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace")); // Output: 3
        System.out.println(longestCommonSubsequence("abc", "abc"));   // Output: 3
        System.out.println(longestCommonSubsequence("abc", "def"));   // Output: 0
    }
}