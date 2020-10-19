import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    solution.P11729();
  }
}

class Baekjoon {
  int count = 0;
  StringBuilder sb = new StringBuilder();

  public void P11729() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(br.readLine());
    hanoi(N, 1, 2, 3);
    System.out.println(count);
    System.out.println(sb.toString());
  }

  private void hanoi(int n, int from, int by, int to) {
    count++;
    if (n == 1) { // 원판이 1개일 때
      sb.append(from + " " + to + "\n");
      return;
    } else { // 원판이 1개가 아닐 때
      hanoi(n - 1, from, to, by); // n-1을 한 후, 1->3->2로 원판을 전달
      sb.append(from + " " + to + "\n");
      hanoi(n - 1, by, from, to); // n-1을 한 후, 2->1->3으로 원판을 전달
    }
  }
}