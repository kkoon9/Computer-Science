
/**
 * @처음생각 contains, replaceAll을 사용 => 메모리 초과(string GC)
 * @포인트 스택으로 해결
 */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Main {
  public static void main(String[] args) throws java.lang.Exception {
    System.out.println(P9935());
  }

  private static String P9935() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack = new Stack<>();
    char[] string = br.readLine().toCharArray();
    String bomb = br.readLine();

    int length = string.length;
    int bombLength = bomb.length();
    for (int index = 0; index < length; index++) {
      stack.push(string[index]);
      if (stack.size() >= bombLength) {
        if (isBomb(stack, bomb)) {
          for (int b = 0; b < bombLength; b++) {
            stack.pop();
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Character ch : stack) {
      sb.append(ch);
    }
    if (sb.length() == 0) {
      return "FRULA";
    } else {
      return sb.toString();
    }
  }

  private static boolean isBomb(Stack<Character> stack, String bomb) {
    for (int index = 0; index < bomb.length(); index++) {
      if (stack.get(stack.size() - bomb.length() + index) != bomb.charAt(index)) {
        return false;
      }
    }
    return true;
  }
}