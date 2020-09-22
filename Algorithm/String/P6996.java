
/**
 * @접근방법 A와 B의 알파벳 개수를 서로 비교하여 아나그램인지 아닌지 판별하면 된다.
 * @더 좋은 방법 sort한 A와 B가 다르면 아나그램이 아닌 것을 판별할 수 있다.
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P6996();
  }

  static int T;
  static final int alphaSize = 26;

  static void P6996() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    for (int index = 0; index < T; index++) {
      int[] aAlpha = new int[26];
      int[] bAlpha = new int[26];
      StringTokenizer st = new StringTokenizer(br.readLine());
      String A = st.nextToken();
      String B = st.nextToken();
      for (int aIndex = 0; aIndex < A.length(); aIndex++) {
        aAlpha[A.charAt(aIndex) - 'a']++;
      }
      for (int bIndex = 0; bIndex < B.length(); bIndex++) {
        bAlpha[B.charAt(bIndex) - 'a']++;
      }
      boolean anagram = true;
      for (int i = 0; i < alphaSize; i++) {
        if (aAlpha[i] != bAlpha[i]) {
          anagram = false;
          break;
        }
      }
      if (anagram) {
        System.out.println(A + " & " + B + " are anagrams.");
      } else {
        System.out.println(A + " & " + B + " are NOT anagrams.");
      }
    }
  }
}