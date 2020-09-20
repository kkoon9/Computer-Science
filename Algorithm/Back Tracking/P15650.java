
/**
 * @접근방법 N과 M (1)과 다르게 수열 안에 숫자가 오름차순이어야 하므로 visit 배열만 사용하였다.
 * @포인트 매개변수에 number를 추가하여 number+1부터 visit 배열에 true로 바꿔준다.
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P15650();
  }

  static int N, M;

  static void P15650() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    boolean[] visit = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      visit[i] = true;
      BackTracking(visit, 1, i);
      visit[i] = false;
    }
  }

  private static void BackTracking(boolean[] visit, int count, int number) {
    if (count == M) {
      for (int i = 1; i <= N; i++) {
        if (visit[i])
          System.out.print(i + " ");
      }
      System.out.println();
      return;
    }
    for (int i = number + 1; i <= N; i++) {
      visit[i] = true;
      BackTracking(visit, count + 1, i);
      visit[i] = false;
    }
  }
}