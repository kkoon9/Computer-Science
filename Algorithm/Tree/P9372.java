
/**
 * @ 간선은 배열로 처리해주며 BFS로 문제를 해결하였다.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    P9372();
  }

  static int T, N, M;

  public static int P9372() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer = 0;

    T = Integer.parseInt(br.readLine());
    for (int testcase = 0; testcase < T; testcase++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      boolean[][] plane = new boolean[N + 1][N + 1];
      boolean[] visit = new boolean[N + 1];
      for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        plane[a][b] = plane[b][a] = true;
      }
      System.out.println(bfs(plane, visit));
    }
    return answer;
  }

  private static int bfs(boolean[][] plane, boolean[] visit) {
    int answer = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(1);
    visit[1] = true;
    while (!queue.isEmpty()) {
      answer++;
      int start = queue.poll();
      for (int i = 1; i <= N; i++) {
        if (plane[start][i] && !visit[i]) {
          queue.add(i);
          visit[i] = true;
        }
      }
    }
    return answer - 1;
  }
}
