
/**
 * @desc 첫 페이지는 1쪽이고, 마지막 페이지는 N쪽인 책에 각 쪽수의 숫자가 모두 몇 번이 나오는지 출력하는 프로그램
 * @param N
 * @return 0~9의 개수를 출력한다.
 * @desc start의 1의 자리 숫자를 0, N의 1의 자리 숫자를 9로 맞춰야 한다.
 * @desc 그 이유는, 1~9이어야 모든 자릿수가 digit만큼 더하기 수월하기 때문이다.
 */
import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    P1019();
  }

  static void P1019() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] answer = new int[10];
    int start = 1;
    int digit = 1;
    while (start <= N) {
      // [1]. n의 끝자리를 9로 만들어준다.
      while (N % 10 != 9 && start <= N) {
        GetCount(answer, N, digit); // N의 자릿수(digit)에 따라 answer의 값을 변경해준다.
        N--;
      }
      if (N < start)
        break;
      // [2]. start의 끝자리를 0로 만들어준다.
      while (start % 10 != 0 && start <= N) {
        GetCount(answer, start, digit); // start의 자릿수(digit)에 따라 answer의 값을 변경해준다.
        start++;
      }
      start /= 10;
      N /= 10;
      for (int i = 0; i < 10; i++) {
        answer[i] += (N - start + 1) * digit;
      }
      digit *= 10; // 자릿수 추가 ex) 1 => 10
    }
    for (int i = 0; i < 10; i++) {
      System.out.print(answer[i] + " ");
    }
  }

  private static void GetCount(int[] answer, int n, int digit) {
    while (n > 0) {
      answer[n % 10] += digit;
      n /= 10;
    }
  }
}