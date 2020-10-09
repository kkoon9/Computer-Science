
/**
 * @포인트 세그먼트 트리로 풀어야 하는 문제
 * @포인트 구간의 최대, 최소, 합을 구하는 문제는 세그먼트 트리로 풀어야 한다!
 */
import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P10868();
  }

  static void P10868() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N, M;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int[] numbers = new int[N];
    for (int index = 0; index < N; index++) {
      numbers[index] = Integer.parseInt(br.readLine());
    }
    SegmentTree segObj = new SegmentTree(numbers, N);
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      System.out.println(segObj.query(a - 1, b - 1, 1, 0, N - 1));
    }
  }

  static class SegmentTree {
    static int[] segmentArr;

    SegmentTree(int[] arr, int n) {
      segmentArr = new int[n * 4];
      Arrays.fill(segmentArr, Integer.MAX_VALUE);
      init(arr, 0, n - 1, 1);
    }

    static int init(int arr[], int left, int right, int node) {
      if (left == right) {
        return segmentArr[node] = arr[left];
      }
      int mid = (left + right) / 2;
      return segmentArr[node] = Math.min(init(arr, left, mid, node * 2), init(arr, mid + 1, right, node * 2 + 1));
    }

    static int query(int start, int end, int node, int nodeLeft, int nodeRight) {
      if (start > nodeRight || end < nodeLeft) {
        return Integer.MAX_VALUE;
      }
      if (start <= nodeLeft && end >= nodeRight) {
        return segmentArr[node];
      }
      int mid = (nodeLeft + nodeRight) / 2;
      return Math.min(query(start, end, node * 2, nodeLeft, mid), query(start, end, node * 2 + 1, mid + 1, nodeRight));
    }
  }
}