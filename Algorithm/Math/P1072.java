
/**
 * @링크 https://kkoon9.tistory.com/53
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P1072());
  }

  static long X, Y;

  static int P1072() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int answer = 0;
    X = Integer.parseInt(st.nextToken());
    Y = Integer.parseInt(st.nextToken());
    long Z = Y * 100 / X;
    if (Z >= 99) {
      return -1;
    }
    long wantZ = Z + 1;
    double odds = (double) (wantZ * X - (long) 100 * Y) / (double) ((long) 100 - wantZ);
    answer = (int) Math.ceil(odds);
    return answer;
  }
}