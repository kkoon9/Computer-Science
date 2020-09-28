import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    p1068();
  }

  static int N, target;
  static int cnt = 0;
  static int start;
  static ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

  public static void p1068() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++)
      arrList.add(new ArrayList<>());

    for (int i = 0; i < N; i++) {
      int val = Integer.parseInt(st.nextToken());
      if (val != -1) {
        arrList.get(val).add(i);
      } else {
        start = i;
      }
    }

    target = Integer.parseInt(br.readLine());
    delete();
    if (target != start) {
      search(start);
      System.out.println(cnt);
    } else {
      System.out.println(0);
    }

  }

  public static void delete() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < arrList.get(i).size(); j++)
        if (arrList.get(i).get(j) == target)
          arrList.get(i).remove(j);
    }
  }

  public static void search(int index) {
    if (arrList.get(index).size() == 0) {
      cnt++;
      return;
    }
    for (int i = 0; i < arrList.get(index).size(); i++) {
      int next = arrList.get(index).get(i);
      if (arrList.get(index).size() == 1 && next == target) {
        cnt++;
        return;
      }
      if (next < N && next != target)
        search(next);
    }
  }
}