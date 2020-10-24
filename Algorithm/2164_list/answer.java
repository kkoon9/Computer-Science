
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P2164());
  }

  static int N;

  static int P2164() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(br.readLine());
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      deque.add(i);
    }
    while (deque.size() != 1) {
      deque.pollFirst();
      deque.addLast(deque.pollFirst());
    }
    return deque.poll();
  }
}