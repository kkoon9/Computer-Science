import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    solution.P1987();
  }
}

class Baekjoon {
  char[][] board;
  boolean[][] visit;
  boolean[] alpha = new boolean[26];
  int R, C;
  int answer = Integer.MIN_VALUE;
  int[] dx = { 0, 0, 1, -1 };
  int[] dy = { 1, -1, 0, 0 };

  public void P1987() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    visit = new boolean[R + 1][C + 1];
    board = new char[R + 1][C + 1];
    for (int i = 1; i <= R; i++) {
      String str = br.readLine();
      for (int j = 1; j <= C; j++) {
        board[i][j] = str.charAt(j - 1);
      }
    }
    visit[1][1] = true;
    alpha[board[1][1] - 'A'] = true;
    backTracking(1, 1, 1);
    System.out.println(answer);
  }

  private void backTracking(int r, int c, int count) {
    for (int i = 0; i < 4; i++) {
      int nextR = r + dx[i];
      int nextC = c + dy[i];
      if (!isLimit(nextR, nextC) || !canGo(nextR, nextC)) {
        if (count > answer) {
          answer = count;
        }
        continue;
      } else {
        visit[nextR][nextC] = true;
        alpha[board[nextR][nextC] - 65] = true;
        backTracking(nextR, nextC, count + 1);
        visit[nextR][nextC] = false;
        alpha[board[nextR][nextC] - 65] = false;
      }
    }
  }

  private boolean canGo(int r, int c) {
    return !alpha[board[r][c] - 'A'] && !visit[r][c];
  }

  private boolean isLimit(int r, int c) {
    return r > 0 && c > 0 && r <= R && c <= C;
  }

}