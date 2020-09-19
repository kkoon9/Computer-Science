
/**
 * @desc 주어진 연산을 K번 했을 때, 만들 수 있는 가장 큰 수를 출력한다. 만약 연산을 K번 할 수 없으면 -1을 출력하는 프로그램
 * @param N, K
 * @return 연산을 주어졌을 때 가장 큰수
 * @틀린이유 visit을 설정해주지 않아서 Queue의 크기가 점점 커짐에 따라 메모리 초과가 발생하였다.
 * @해결법 2차원 boolean형 배열을 설정하여 각 연산 순서에 같은 수가 나오면 Queue에 넣지 않았다.
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P1039());
  }

  static int N, K;
  static int answer = -1;
  static int MAX = 1000001;
  static Queue<String> q = new LinkedList<>();
  static boolean[][] visit;

  static int P1039() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    q.add(String.valueOf(N));
    visit = new boolean[MAX][K + 1];
    while (K-- > 0) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        char[] number = q.poll().toCharArray();
        Swap(number, K);
      }
    }
    while (!q.isEmpty()) {
      answer = Math.max(answer, Integer.parseInt(q.poll()));
    }
    return answer;
  }

  private static void Swap(char[] arr, int count) {
    int size = arr.length;
    for (int i = 0; i < size; i++) {
      for (int j = i + 1; j < size; j++) {
        char buffer = arr[i];
        arr[i] = arr[j];
        arr[j] = buffer;
        String arrStr = String.valueOf(arr);
        if (arr[0] != '0' && !visit[Integer.parseInt(arrStr)][count + 1]) {
          visit[Integer.parseInt(arrStr)][count + 1] = true;
          q.add(arrStr);
        }
        buffer = arr[i];
        arr[i] = arr[j];
        arr[j] = buffer;
      }
    }
  }
}