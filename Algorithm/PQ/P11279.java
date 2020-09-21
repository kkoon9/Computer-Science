
/**
 * @접근방법 우선순위 큐(PriorityQueue)를 사용하면 된다.
 * @포인트 Comparator.reverseOrder()를 사용하면 내림차순으로 우선순위 큐에 넣을 수 있다.
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P2108();
  }

  static int N, M;
  static final int SIZE = 4000;

  static void P2108() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    // StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      int command = Integer.parseInt(br.readLine());
      if (command == 0) {
        if (pq.size() == 0) {
          System.out.println("0");
        } else {
          System.out.println(pq.poll());
        }
      } else {
        pq.add(command);
      }
    }
  }
}