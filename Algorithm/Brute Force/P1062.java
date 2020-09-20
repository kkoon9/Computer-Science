
/**
 * @접근방법 입력 최대값이 50이어서 크지않은 값이라 완탐을 선택.
 * @접근방법 알파벳의 visit을 boolean형 배열을 선언하여 N개의 단어를 검사해주었다.
 * @더 좋은 방법 비트마스킹을 활용한다.
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P1062());
  }

  static int N, K;
  static int answer = 0;
  static final int SIZE = 26;
  static String[] antarcticWord;

  static int P1062() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken()) - 5;
    if (K < 0)
      return 0;
    // [1]. a, c, n, t, i 는 모두 있어야 한다.
    antarcticWord = new String[N];
    for (int i = 0; i < N; i++) {
      antarcticWord[i] = br.readLine().replaceAll("a|c|t|n|i", "");
    }
    go(0, 0, 0);
    return answer;
  }

  public static void go(int cnt, int learn, int index) {
    if (index > 26)
      return;
    if (cnt == K) {
      int total = 0;
      for (int i = 0; i < N; i++) {
        boolean isOk = true;
        String s = antarcticWord[i];
        for (int j = 0; j < s.length(); j++) {
          int num = s.charAt(j) - 'a';
          if ((learn & (1 << num)) > 0)
            continue;
          isOk = false;
          break;
        }
        if (isOk)
          ++total;
      }
      answer = Math.max(total, answer);
      return;
    }

    if (index == 'a' - 'a' || index == 'n' - 'a' || index == 't' - 'a' || index == 'i' - 'a' || index == 'c' - 'a')
      go(cnt, learn, index + 1);
    else if (index != 'a' - 'a' && index != 'n' - 'a' && index != 't' - 'a' && index != 'i' - 'a'
        && index != 'c' - 'a') {
      if (cnt <= K)
        go(cnt + 1, (learn | (1 << index)), index + 1);
      go(cnt, learn, index + 1);
    }
  }
}