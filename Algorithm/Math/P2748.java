
/**
 * @desc n번째 피보나치 수를 구하는 프로그램
 * @param n
 * @return n번째 피보나치 수를 출력
 */
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P2748());
  }

  static final int SIZE = 90 + 1;

  static int P2748() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] fibo = new int[SIZE];
    fibo[0] = 0;
    fibo[1] = 1;
    for (int i = 2; i <= n; i++) {
      fibo[i] = fibo[i - 1] + fibo[i - 2];
    }
    return fibo[n];
  }
}