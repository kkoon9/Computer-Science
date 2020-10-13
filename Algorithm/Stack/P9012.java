
/**
 * @포인트 Stack 문제
 * @포인트 Stack은 '('만 넣고 ')'가 나올 때에는 pop만 해준다.
 * @포인트 stack이 비어있는지 확인해줘야 한다(isEmpty).
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    solution.P9012();
  }
}

class Baekjoon {
  public void P9012() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());
    Stack<Character> stack;
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      stack = new Stack<>();
      char[] PS = br.readLine().toCharArray();
      if (isVPS(PS, stack)) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }
  }

  private boolean isVPS(char[] PS, Stack<Character> stack) {
    for (int i = 0; i < PS.length; i++) {
      char ch = PS[i];
      if (ch == ')') {
        if (stack.isEmpty()) {
          return false;
        } else {
          stack.pop();
        }
      } else {
        stack.push('(');
      }

    }
    if (!stack.isEmpty()) {
      return false;
    }
    return true;
  }
}