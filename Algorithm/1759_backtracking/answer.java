import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    solution.P1759();
  }
}

class Baekjoon {
  char[] charArr;
  boolean[] visit;
  char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
  int L, C;
  StringBuilder sb = new StringBuilder();

  public void P1759() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    char[] password = new char[L];
    visit = new boolean[C];
    charArr = new char[C];
    String[] strArr = br.readLine().split(" ");
    for (int i = 0; i < C; i++) {
      charArr[i] = strArr[i].charAt(0);
    }
    Arrays.sort(charArr); // ※1
    for (int i = 0; i <= C - L; i++) {
      visit[i] = true;
      int vowelCount = 0;
      for (int v = 0; v < 5; v++) {
        if (vowels[v] == charArr[i]) {
          vowelCount = 1;
          break;
        }
      }
      password[0] = charArr[i];
      backTracking(password, vowelCount, 1, i);
      visit[i] = false;
    }
    System.out.println(sb.toString());
  }

  private void backTracking(char[] password, int vowelCount, int index, int sequence) {
    if (index == L) {
      if (index - vowelCount >= 2 && vowelCount >= 1) {
        sb.append(password);
        sb.append("\n");
      }
      return;
    }
    for (int i = sequence; i < C; i++) {
      if (visit[i])
        continue;
      int val = 0;
      for (int v = 0; v < 5; v++) {
        if (vowels[v] == charArr[i]) {
          val++;
          break;
        }
      }
      password[index] = charArr[i];
      visit[i] = true;
      backTracking(password, vowelCount + val, index + 1, i);
      visit[i] = false;
    }
  }

}