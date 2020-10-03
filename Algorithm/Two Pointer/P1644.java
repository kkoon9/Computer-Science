
/**
 * @포인트 에라토스테네스의 체로 소수를 ArrayList에 넣어준 뒤, 투 포인터로 찾아준다.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws java.lang.Exception {
    System.out.println(P1644());
  }

  static int N;
  static ArrayList<Integer> primeNumber = new ArrayList<>();

  private static int P1644() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int answer = 0;
    int sum = 0;
    getPrime();
    int firstPoint = 0;
    int secondPoint = 0;
    int size = primeNumber.size();
    while (firstPoint < size) {
      sum += primeNumber.get(firstPoint++);
      while (N < sum) {
        sum -= primeNumber.get(secondPoint++);
      }
      if (sum == N) {
        answer++;
      }
    }
    return answer;
  }

  private static void getPrime() {
    boolean[] visit = new boolean[N + 1];
    for (int i = 2; i <= N; i++) {
      if (!visit[i]) {
        primeNumber.add(i);
        for (int notPrime = i + i; notPrime <= N; notPrime += i) {
          visit[notPrime] = true;
        }
      }
    }
  }
}