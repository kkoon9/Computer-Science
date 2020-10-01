
/**
 * @포인트 스택
 */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
  public static void main(String[] args) throws java.lang.Exception {
    System.out.println(P10773());
  }

  private static int P10773() throws java.lang.Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int K = Integer.parseInt(br.readLine());
    int answer = 0;
    Stack<Integer> stack = new Stack<>();
    for (int index = 0; index < K; index++) {
      int number = Integer.parseInt(br.readLine());
      if (number == 0) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else {
        stack.push(number);
      }
    }
    while (!stack.isEmpty()) {
      answer += stack.pop();
    }
    return answer;
  }
}
