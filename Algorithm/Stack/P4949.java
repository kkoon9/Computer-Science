
/**
 * @처음생각 괄호의 수만 맞으면 된다 생각해서 big, small Integer 변수를 선언하였다.
 * @포인트 stack에 넣어줌으로써 top()에 있는 괄호의 짝이 맞는지 확인해줘야 한다.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main {
  public static void main(String[] args) throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String str = br.readLine();
      if (str.equals(".")) {
        break;
      }
      if (isCheckString(str)) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
  }

  private static boolean isCheckString(String str) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '(' || ch == '[') {
        stack.push(ch);
      } else if (ch == ')') {
        if (stack.isEmpty() || stack.peek() != '(') {
          return false;
        }
        stack.pop();
      } else if (ch == ']') {
        if (stack.isEmpty() || stack.peek() != '[') {
          return false;
        }
        stack.pop();
      }
    }
    if (!stack.isEmpty()) {
      return false;
    }
    return true;
  }
}
