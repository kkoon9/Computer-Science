import java.io.*;
import java.util.*;

class Main {
  static int N;
  static int answer = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    N = Integer.parseInt(br.readLine());
    int[] chess = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      chess[1] = i;
      BackTracking(chess, 1);
    }
    System.out.println(answer);
  }

  private static void BackTracking(int[] chess, int row) {
    if (row == N) {
      answer++;
      return;
    }
    for (int i = 1; i <= N; i++) {
      chess[row + 1] = i;
      if (isPossible(chess, row + 1))
        BackTracking(chess, row + 1);
    }
  }

  private static boolean isPossible(int[] chess, int row) {
    for (int i = 1; i < row; i++) {
      if (chess[i] == chess[row])
        return false;

      if (Math.abs(i - row) == Math.abs(chess[i] - chess[row]))
        return false;
    }
    return true;
  }
}