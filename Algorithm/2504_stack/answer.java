import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    System.out.println(solution.P2504());
  }
}

class Baekjoon {
  Stack<Character> stack = new Stack<>();

  public int P2504() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    int answer = 0;
    int sum = 1;
    int stringSize = S.length();
    for (int i = 0; i < stringSize; i++) {
      char ch = S.charAt(i);
      switch (ch) {
        case '(':
          sum *= 2;
          stack.push(ch);
          break;
        case '[':
          sum *= 3;
          stack.push(ch);
          break;
        case ')':
          if (stack.isEmpty() || stack.pop() != '(') {
            return 0;
          }
          if (S.charAt(i - 1) == '(')
            answer += sum;
          sum /= 2;
          break;
        case ']':
          if (stack.isEmpty() || stack.pop() != '[') {
            return 0;
          }
          if (S.charAt(i - 1) == '[')
            answer += sum;
          sum /= 3;
          break;
      }
    }
    if (!stack.isEmpty()) {
      return 0;
    }
    return answer;
  }
}