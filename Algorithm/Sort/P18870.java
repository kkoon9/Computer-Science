import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P18870();
  }

  static int N;

  static void P18870() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    Point[] location = new Point[N];
    int[] answer = new int[N];
    for (int i = 0; i < N; i++) {
      location[i] = new Point(i, Integer.parseInt(st.nextToken()));
    }
    Arrays.sort(location);
    int press = 0;
    for (int i = 0; i < N - 1; i++) {
      answer[location[i].x] = press;
      if (location[i].number != location[i + 1].number) {
        press++;
      }
    }
    answer[location[N - 1].x] = press;
    for (int i = 0; i < N; i++) {
      System.out.print(answer[i] + " ");
    }

  }

  private static class Point implements Comparable<Point> {
    int x;
    int number;

    Point(int x, int number) {
      this.x = x;
      this.number = number;
    }

    @Override
    public int compareTo(Point o) {
      int result = this.number - o.number;
      return result;
    }
  }
}