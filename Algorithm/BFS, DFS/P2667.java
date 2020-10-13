
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
    solution.P2667();
  }
}

class Baekjoon {
  boolean[][] map, visit;
  int cnt = 0;
  int N;

  public void P2667() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());
    int count = 0;
    List<Integer> width = new LinkedList<>();
    N = Integer.parseInt(br.readLine());
    map = new boolean[N + 1][N + 1];
    visit = new boolean[N + 1][N + 1];
    for (int i = 1; i <= N; i++) {
      String[] row = br.readLine().split("");
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(row[j - 1]) == 1 ? true : false;
      }
    }
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (visit[i][j] || !map[i][j])
          continue;
        visit[i][j] = true;
        DFS(i, j);
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
    if (isRange(x - 1, y) && map[x - 1][y] && !visit[x - 1][y]) {
      visit[x - 1][y] = true;
      DFS(x - 1, y);
    }
    if (isRange(x + 1, y) && map[x + 1][y] && !visit[x + 1][y]) {
      visit[x + 1][y] = true;
      DFS(x + 1, y);
    }
    if (isRange(x, y - 1) && map[x][y - 1] && !visit[x][y - 1]) {
      visit[x][y - 1] = true;
      DFS(x, y - 1);
    }
    if (isRange(x, y + 1) && map[x][y + 1] && !visit[x][y + 1]) {
      visit[x][y + 1] = true;
      DFS(x, y + 1);
    }
  }

  private boolean isRange(int x, int y) {
    return x > 0 && y > 0 && x <= N && y <= N;
  }
}