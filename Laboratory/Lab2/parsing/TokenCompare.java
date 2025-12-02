package parsing;

import java.util.List;

import parsing.token.Token;

public class TokenCompare {

    public static int lcs(List<Token> x, List<Token> y) {
        int m = x.size();
        int n = y.size();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x.get(i - 1).equals(y.get(j - 1))) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

}
