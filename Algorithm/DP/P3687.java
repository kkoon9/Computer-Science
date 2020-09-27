
/**
 * @틀린이유 잘못된 접근 방법
 * @링크 https://kkoon9.tistory.com/60
 */
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P3687();
  }

  static final int SIZE = 100;
  static int[] matches = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };
  static long[] min = new long[SIZE + 1];

  static void P3687() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0; i <= SIZE; i++) {
      min[i] = Long.MAX_VALUE;
    }
    GetMinNumber();
    for (int testcase = 0; testcase < T; testcase++) {
      int n = Integer.parseInt(br.readLine()); // 성냥개비의 개수
      String maxNumber = GetMaxNumber(n);
      System.out.println(min[n] + " " + maxNumber);
    }
  }

  static String GetMaxNumber(int leftCount) {
    String result = "";
    if (leftCount == 2) {
      return "1";
    } else if (leftCount == 3) {
      return "7";
    }
    if (leftCount % 2 == 0) { // 짝수
      while (leftCount != 0) {
        result += "1";
        leftCount -= 2;
      }
    } else {
      result += "7";
      leftCount -= 3;
      while (leftCount > 0) {
        result += "1";
        leftCount -= 2;
      }
    }
    return result;
  }

  private static void GetMinNumber() {
    min[2] = 1;
    min[3] = 7;
    min[4] = 4;
    min[5] = 2;
    min[6] = 6; // 다른 숫자 뒤에 올 때는 0
    min[7] = 8;
    min[8] = 10;
    String[] add = { "1", "7", "4", "2", "0", "8" };

    for (int i = 9; i <= SIZE; i++) {
      for (int j = 2; j <= 7; j++) {
        String curr = String.valueOf(min[i - j]) + add[j - 2];
        min[i] = Math.min(min[i], Long.parseLong(curr));
      }
    }
  }
}