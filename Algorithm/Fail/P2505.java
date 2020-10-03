import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws java.lang.Exception {
    P2505();
  }

  static StringBuilder sb1 = new StringBuilder();
  static StringBuilder sb2 = new StringBuilder();
  static int N;

  private static void P2505() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int[] array = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }
    if (!front(array)) {
      back(array);
    }
  }

  private static boolean front(int[] origin) {
    int[] array = origin.clone();
    int cnt = 0;
    int target = 1;
    while (target != N) {
      for (int i = target; i <= N; i++) {
        if (target == array[target]) {
          break;
        }
        if (array[i] == target) {
          cnt++;
          reverse(array, target, i);
          sb1.append(target + " " + i + "\n");
        }
      }
      target++;
    }

    if (cnt == 1) {
      System.out.println("1 1");
      System.out.println(sb1.toString());
      return true;
    } else if (cnt == 2) {
      System.out.println(sb1.toString());
      return true;
    } else {
      return false;
    }
  }

  private static void back(int[] origin) {
    int[] array = origin.clone();
    int cnt = 0;
    int target = N;
    while (target != 1) {
      for (int i = target; i >= 1; i--) {
        if (target == array[target]) {
          break;
        }
        if (array[i] == target) {
          cnt++;
          reverse(array, i, target);
          sb2.append(i + " " + target + "\n");
        }
      }
      target--;
    }

    if (cnt == 1) {
      System.out.println("1 1");
      System.out.println(sb2.toString());
    } else if (cnt == 2) {
      System.out.println(sb2.toString());
    } else {
      System.out.println("1 1");
      System.out.println("1 1");
    }
  }

  public static void reverse(int[] array, int s, int e) {
    int n = (int) Math.ceil((e - s) / 2.0);
    for (int i = 0; i < n; i++) {
      int temp = array[s + i];
      array[s + i] = array[e - i];
      array[e - i] = temp;
    }
  }
}