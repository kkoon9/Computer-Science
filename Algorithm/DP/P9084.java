
/**
 * @desc 동전 가치의 합이 k원이 되도록 하는 경우의 수를 구하는 프로그램
 * @param t(테스트케이스), n(동전의 종류), k(동전의 합), n개의 동전 가치
 * @return 경우의 수 출력
 */
import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    P9084();
  }

  static void P9084() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int testcase = 0; testcase < T; testcase++) {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] coin = new int[n];
      for (int i = 0; i < n; i++) {
        coin[i] = Integer.parseInt(st.nextToken());
      }
      int k = Integer.parseInt(br.readLine());
      int[] dp = new int[k + 1];
      dp[0] = 1;
      for (int i = 0; i < n; i++) {
        for (int j = coin[i]; j <= k; j++) {
          dp[j] += dp[j - coin[i]];
        }
      }
      System.out.println(dp[k]);
    }
  }
}