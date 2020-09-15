
/**
 * @desc 동전 가치의 합이 k원이 되도록 하는 경우의 수를 구하는 프로그램
 * @param n(동전의 종류), k(동전의 합), n개의 동전 가치
 * @return 경우의 수 출력
 */
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P2293());
  }

  static final int SIZE = 90 + 1;

  static int P2293() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] coin = new int[n];
    int[] dp = new int[k + 1];

    for (int i = 0; i < n; i++) {
      coin[i] = Integer.parseInt(br.readLine());
    }

    dp[0] = 1;

    for (int i = 0; i < n; i++) {
      for (int j = coin[i]; j <= k; j++) {
        dp[j] += dp[j - coin[i]];
      }
    }

    return dp[k];
  }
}