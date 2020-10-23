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
  Stack<Character> stackBracket = new Stack<>();
  Stack<Integer> stackNumber = new Stack<>();

  public int P2504() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String S = br.readLine();
    int answer = 0;
    int stringSize = S.length();
    for (int i = 0; i < stringSize; i++) {
      char ch = S.charAt(i);
      if (ch == ')') {
        int num = 0;
        while (!stackBracket.isEmpty()) {
          char stackBracketPop = stackBracket.pop();
          if (stackBracketPop == 'N') {
            int stackNumberPop = stackNumber.pop();
            if (num == 0) {
              num = stackNumberPop;
            } else {
              num += stackNumberPop;
            }
          } else if (stackBracketPop == '(') {
            num *= 2;
            num = num == 0 ? 2 : num;
            stackNumber.push(num);
            stackBracket.push('N');
            break;
          } else {
            return 0;
          }
        }
        if (num == 0) {
          return 0;
        }
      } else if (ch == ']') {
        int num = 0;
        while (!stackBracket.isEmpty()) {
          char stackBracketPop = stackBracket.pop();
          if (stackBracketPop == 'N') {
            int stackNumberPop = stackNumber.pop();
            if (num == 0) {
              num = stackNumberPop;
            } else {
              num += stackNumberPop;
            }
          } else if (stackBracketPop == '[') {
            num *= 3;
            num = num == 0 ? 3 : num;
            stackNumber.push(num);
            stackBracket.push('N');
            break;
          } else {
            return 0;
          }
        }
        if (num == 0) {
          return 0;
        }
      } else {
        stackBracket.push(ch);
      }
      /*
       * for(char cha : stackBracket){ System.out.print(cha + " "); }
       * System.out.print(" num : "); System.out.println();
       */
    }
    for (char ch : stackBracket) {
      if (ch != 'N') {
        return 0;
      }
    }
    for (int num : stackNumber) {
      answer += num;
    }

    return answer;
  }
}