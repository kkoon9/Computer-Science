
/**
 * @틀린이유 N의 범위가 100,000이기 때문에 2차원 배열을 선언하면 메모리 초과가 발생하낟.
 * @접근방법 ArrayList로 풀이!
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P11725();
  }

  static void P11725() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Queue<Edge> queue = new LinkedList<>();
    int N = Integer.parseInt(br.readLine());
    int[] answer = new int[N + 1];
    boolean[] visit = new boolean[N + 1];
    ArrayList<ArrayList<Integer>> trees = new ArrayList<>();
    for (int i = 0; i <= N; i++) {
      trees.add(new ArrayList<>());
    }
    for (int index = 1; index < N; index++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int vertex1 = Integer.parseInt(st.nextToken());
      int vertex2 = Integer.parseInt(st.nextToken());
      trees.get(vertex1).add(vertex2);
      trees.get(vertex2).add(vertex1);
    }
    visit[1] = true;
    for (int vertex = 0; vertex < trees.get(1).size(); vertex++) {
      int child = trees.get(1).get(vertex);
      queue.add(new Edge(1, child));
      visit[child] = true;
    }
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Edge edge = queue.poll();
        answer[edge.child] = edge.parent;
        for (int vertex = 0; vertex < trees.get(edge.child).size(); vertex++) {
          int child = trees.get(edge.child).get(vertex);
          if (visit[child])
            continue;
          queue.add(new Edge(edge.child, child));
          visit[child] = true;
        }
      }
    }
    for (int vertex = 2; vertex <= N; vertex++) {
      System.out.println(answer[vertex]);
    }
  }

  static class Edge {
    int parent;
    int child;

    Edge(int parent, int child) {
      this.parent = parent;
      this.child = child;
    }
  }
}