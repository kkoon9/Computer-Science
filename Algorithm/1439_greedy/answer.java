import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    System.out.println(solution.P1439());
  }
}

class Baekjoon {
  public int P1439() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    int size = S.length();
    int[] count = new int[2];
    int beforeNumber = S.charAt(0) - '0';
    count[beforeNumber]++;
    for (int i = 1; i < size; i++) {
      int nowNumber = S.charAt(i) - '0';
      if (nowNumber != beforeNumber) {
        count[nowNumber]++;
        beforeNumber = nowNumber;
      }
    }
    return Math.min(count[0], count[1]);
  }
}