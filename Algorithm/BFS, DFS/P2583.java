
/**
 * @포인트 DFS 문제(BFS로도 가능)
 * @포인트 DFS,BFS에 기초가 되는 문제
 * @포인트 x,y의 범위가 배열 내에 있는지 꼭 확인해주어야 한다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    solution.P2583();
  }
}

class Baekjoon {
  boolean[][] map, visit;
  int cnt = 0;
  int M, N, K;

  public void P2583() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int count = 0;
    List<Integer> width = new LinkedList<>();
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new boolean[N][M];
    visit = new boolean[N][M];
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      for (int x = x1; x < x2; x++) {
        for (int y = y1; y < y2; y++) {
          map[x][y] = true;
        }
      }
    }
    for (int i = 0; i < M; i++) {
      for (int j = 0; j < N; j++) {
        if (visit[j][i] || map[j][i])
          continue;
        visit[j][i] = true;
        DFS(j, i);
        width.add(cnt);
        cnt = 0;
        count++;
      }
    }
    Collections.sort(width);
    System.out.println(count);
    for (int w : width) {
      System.out.print(w + " ");
    }
    System.out.println();
  }

  private void DFS(int x, int y) {
    cnt++;
    if (isRange(x - 1, y) && !map[x - 1][y] && !visit[x - 1][y]) {
      visit[x - 1][y] = true;
      DFS(x - 1, y);
    }
    if (isRange(x + 1, y) && !map[x + 1][y] && !visit[x + 1][y]) {
      visit[x + 1][y] = true;
      DFS(x + 1, y);
    }
    if (isRange(x, y - 1) && !map[x][y - 1] && !visit[x][y - 1]) {
      visit[x][y - 1] = true;
      DFS(x, y - 1);
    }
    if (isRange(x, y + 1) && !map[x][y + 1] && !visit[x][y + 1]) {
      visit[x][y + 1] = true;
      DFS(x, y + 1);
    }
  }

  private boolean isRange(int x, int y) {
    return x >= 0 && y >= 0 && x < N && y < M;
  }
}