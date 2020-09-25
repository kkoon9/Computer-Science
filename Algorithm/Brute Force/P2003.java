
/**
 * @N이 최대가 10000이라 2중 for문으로 풀 수 있는 문제
 * @더좋은방법 투 포인트 문제!
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P2003());
  }

  static int N, M;

  static int P2003() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int answer = 0;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int[] numbers = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    for (int i = 0; i < N; i++) {
      int sum = numbers[i];
      if (sum == M) {
        answer++;
        continue;
      }
      for (int j = i + 1; j < N; j++) {
        sum += numbers[j];
        if (sum < M) {
          continue;
        }
        if (sum == M)
          answer++;
        break;
      }
    }
    return answer;
  }
}