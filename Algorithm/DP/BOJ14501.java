class BOJ14501 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st;
    int max = 0;
    int[] T = new int[N + 10];
    int[] P = new int[N + 10];
    int[] dp = new int[N + 10];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 1; i <= N + 1; i++) {
      dp[i] = Math.max(dp[i], max);
      dp[T[i] + i] = Math.max(dp[T[i] + i], P[i] + dp[i]);
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }
}