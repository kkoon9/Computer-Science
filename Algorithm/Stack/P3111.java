
/**
 * @처음생각 indexOf, delete를 사용 => 시간초과 O(N^2)
 * @포인트 left, right스택으로 해결
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P3111());
  }

  static String key, text;
  static int start, end;

  static String P3111() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    key = br.readLine();
    text = br.readLine();
    Stack<Character> left = new Stack<>();
    Stack<Character> right = new Stack<>();
    start = 0;
    end = text.length() - 1;
    boolean isRemove = false;
    int keyLength = key.length();
    while (start <= end) {
      if (!isRemove) {
        isRemove = SearchKeyLeft(left, keyLength);
      }
      if (isRemove && start <= end) {
        isRemove = SearchKeyRight(right, keyLength);
      }
    }
    while (!left.isEmpty()) {
      right.push(left.pop());
    }
    while (!right.isEmpty()) {
      sb.append(right.pop());
    }
    while (true) {
      int idx = sb.indexOf(key);
      if (idx < 0)
        break;
      sb.delete(idx, idx + key.length());
    }
    return sb.toString();
  }

  private static boolean SearchKeyLeft(Stack<Character> left, int keyLength) {
    left.push(text.charAt(start++));
    if (left.size() >= keyLength && left.peek() == key.charAt(keyLength - 1)) {
      int keyLen = keyLength - 1;
      boolean check = true;
      for (int j = left.size() - 1; j >= left.size() - keyLength; j--) {
        if (left.get(j) != key.charAt(keyLen--)) {
          check = false;
          break;
        }
      }
      if (check) {
        for (int j = 0; j < keyLength; j++) {
          left.pop();
        }
        return true;
      }
    }
    return false;
  }

  private static boolean SearchKeyRight(Stack<Character> right, int keyLength) {
    String keyReverse = new StringBuilder(key).reverse().toString();
    right.push(text.charAt(end--));
    if (right.size() >= keyLength && right.peek() == keyReverse.charAt(keyLength - 1)) {
      int keyLen = keyLength - 1;
      boolean check = true;
      for (int j = right.size() - 1; j >= right.size() - keyLength; j--) {
        if (right.get(j) != keyReverse.charAt(keyLen--)) {
          check = false;
          break;
        }
      }
      if (check) {
        for (int j = 0; j < keyLength; j++) {
          right.pop();
        }
        return false;
      }
    }
    return true;
  }
}