import java.io.*;
import java.util.*;

class Main {
  static String[] chessWB = { "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW",
      "WBWBWBWB" };
  static String[] chessBW = { "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB", "BWBWBWBW", "WBWBWBWB",
      "BWBWBWBW" };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 체스판이 될 수 있는 2가지 경우
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int max = Integer.MAX_VALUE;
    String[] square = new String[N + 1];
    for (int i = 0; i < N; i++) {
      square[i] = br.readLine();
    }
    for (int i = 0; i <= M - 8; i++) {
      for (int j = 0; j <= N - 8; j++) {
        // square[j][i] ~ square[j+8][i+8]까지

        int count = createChess(square, i, j);
        max = Math.min(count, max);
      }
    }
    System.out.println(max);
  }

  static int createChess(String[] square, int x, int y) {
    int countBW = 0;
    int countWB = 0;
    for (int j = y; j < y + 8; j++) {
      String str = square[j].substring(x, x + 8);
      for (int k = 0; k < 8; k++) {
        if (chessWB[j % 8].charAt(k) != str.charAt(k)) {
          countWB++;
        }
        if (chessBW[j % 8].charAt(k) != str.charAt(k)) {
          countBW++;
        }
      }
    }
    int answer = Math.min(countBW, countWB);
    return answer;
  }
}