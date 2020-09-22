
/**
 * @포인트 Stack을 사용하여 연산자가 나올 때 연산을 진행해주고 다시 스택에 넣어준다.
 * @리펙터링 swtich로 하면 코드가 더 깔끔해질 수 있다.
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P1935();
  }

  static int N, M;

  static void P1935() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    double answer = 0.0;
    N = Integer.parseInt(br.readLine());
    char[] input = br.readLine().toCharArray();
    int len = input.length;
    double[] array = new double[N];
    Stack<Double> stack = new Stack<>();

    for (int i = 0; i < N; i++) {
      array[i] = Integer.parseInt(br.readLine());
    }
    for (int i = 0; i < len; i++) {
      char ch = input[i];

      switch (ch) {
        case '+':
        case '-':
        case '*':
        case '/':
          stack.push(Operation(stack.pop(), stack.pop(), ch));
          break;
        default:
          stack.push(array[ch - 'A']);
          break;
      }
    }
    answer = stack.pop();
    System.out.format("%.2f", answer);
  }

  private static double Operation(double a, double b, char command) {
    double answer;
    if (command == '+') {
      double plus = b + a;
      answer = plus;
    } else if (command == '-') {
      double minus = b - a;
      answer = minus;
    } else if (command == '*') {
      double multiple = b * a;
      answer = multiple;
    } else {
      double divide = b / a;
      answer = divide;
    }
    return answer;
  }
}