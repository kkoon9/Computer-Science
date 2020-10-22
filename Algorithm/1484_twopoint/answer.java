import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    solution.P1484();
  }
}

class Baekjoon {
  final int MAX = 100000;

  public void P1484() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int G = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    int before = 1, present = 1;
    while (true) {
      if (present * present - before * before > MAX * 2) {
        break;
      }
      if (present * present - before * before > G) {
        before++;
      } else if (present * present - before * before < G) {
        present++;
      } else {
        sb.append(present);
        sb.append('\n');
        present++;
      }
    }
    if (sb.length() == 0) {
      sb.append(-1);
    }
    System.out.println(sb.toString());
  }
}