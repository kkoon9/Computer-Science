
/**
 * @접근방법 수열은 사전 순으로 증가하는 순서로 출력해야 하므로 BackTracking으로 풀이하였다.
 * @풀이방법 number와 visit을 사용한다. 
 * @풀이방법 이미 사용했던 숫자는 visit으로 거른다.
 * @풀이방법 이미 사용하지 않았다면 number[count+1]에 넣어준다.
 * @포인트 visit[i]를 true로 한 뒤, BackTracking 함수를 호출해주고 visit[i]를 false로 바꿔준다.(백트래킹의 핵심)
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
    int[] number = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      visit[i] = true;
      number[1] = i;
      BackTracking(number, visit, 1);
      visit[i] = false;
    }
  }

  private static void BackTracking(int[] number, boolean[] visit, int count) {
    if (count == M) {
      for (int i = 1; i <= count; i++) {
        System.out.print(number[i] + " ");
      }
      System.out.println();
      return;
    }
    for (int i = 1; i <= N; i++) {
      if (visit[i])
        continue;
      visit[i] = true;
      number[count + 1] = i;
      BackTracking(number, visit, count + 1);
      visit[i] = false;
    }
  }
}