
/**
 * @desc 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램
 * @param N, M N*M 직사각형
 * @return 정사각형의 크기를 출력
 * @틀린이유 모든 정사각형의 크기를 구하는 걸로 착각했다. 문제를 더 열심히 읽자.
 * @해결법 가장 큰 정사각형을 찾는 것이므로 Math.max를 통해 answer를 계속 바꿔준다.
 * @해결법 M과 N 중에 가장 작은 것을 변으로 생각하고 조사한다.
 */
import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P1051());
  }

  static int N, M;

  static int P1051() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int[][] square = new int[N][M];
    final int MIN = Math.min(N, M);
    int answer = -1;
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < M; j++) {
        square[i][j] = str.charAt(j) - '0';
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int min = 0; min < MIN; min++) {
          if (IsSquare(square, i, j, min)) {
            answer = Math.max(answer, (min + 1) * (min + 1));
          }
        }
      }
    }
    return answer;
  }

  private static boolean IsSquare(int[][] square, int i, int j, int count) {
    if (i + count >= N || j + count >= M)
      return false;
    int value = square[i][j];
    if (square[i + count][j] != value || square[i][j + count] != value || square[i + count][j + count] != value)
      return false;
    return true;
  }
}