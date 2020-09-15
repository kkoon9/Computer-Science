
/**
 * @desc 동전 가치의 합이 k원이 되는 최소 개수를 구하는 프로그램
 * @param n(동전의 종류), k(동전의 합), n개의 동전 가치
 * @return 동전 가치의 합이 k원이 되는 동전의 최소 개수 출력
 */
import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P2294());
  }

  static int P2294() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int i, j;
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int coin[] = new int[n + 1], dp[] = new int[k + 1];

    for (i = 1; i <= k; i++)
      dp[i] = 100001;
    dp[0] = 0;

    for (i = 1; i <= n; i++)
      coin[i] = Integer.parseInt(br.readLine());

    for (i = 1; i <= n; i++)
      for (j = coin[i]; j <= k; j++)
        dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);

    if (dp[k] == 100001)
      dp[k] = -1;
    return dp[k];
  }
}