import java.io.*;
import java.util.*;

class Main {
  static int[] buttons = { 300, 60, 10 };
  static int[] buttonCount = { 0, 0, 0 };

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 체스판이 될 수 있는 2가지 경우
    int T = Integer.parseInt(st.nextToken());
    if (T % buttons[2] != 0) {
      System.out.println(-1);
      return;
    }
    int i = 0;
    for (int button : buttons) {
      if (T / button == 0) {
        buttonCount[i++] = 0;
        continue;
      }
      buttonCount[i++] = T / button;
      T %= button;
    }
    for (int count : buttonCount) {
      System.out.print(count + " ");
    }
    System.out.println();
  }
}