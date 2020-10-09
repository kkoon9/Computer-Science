import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P2042();
  }

  static void P2042() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N, M, K;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    long[] numbers = new long[N];
    for (int index = 0; index < N; index++) {
      numbers[index] = Long.parseLong(br.readLine());
    }
    SegmentTree segObj = new SegmentTree(numbers, N);
    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      int mode = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      long b = Long.parseLong(st.nextToken());
      if (mode == 1) { // update
        segObj.update(0, N - 1, 1, a - 1, b - numbers[a - 1]);
        numbers[a - 1] = b;
      } else { // 구간 합
        System.out.println(segObj.query(a - 1, (int) b - 1, 1, 0, N - 1));
      }
    }
  }

  static class SegmentTree {
    static long[] segmentArr;

    SegmentTree(long[] arr, int n) {
      int x = (int) Math.ceil(Math.log(n) / Math.log(2));
      int size = (int) Math.pow(2, x) * 2;
      segmentArr = new long[size];
      Arrays.fill(segmentArr, Long.MAX_VALUE);
      init(arr, 0, n - 1, 1);
    }

    static long init(long arr[], int left, int right, int node) {
      if (left == right) {
        return segmentArr[node] = arr[left];
      }
      int mid = (left + right) / 2;
      return segmentArr[node] = (init(arr, left, mid, node * 2) + init(arr, mid + 1, right, node * 2 + 1));
    }

    static void update(int start, int end, int node, int index, long diff) {
      if (!(start <= index && index <= end)) {
        return;
      }
      segmentArr[node] += diff;
      int mid = (start + end) / 2;
      if (start != end) {
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
      }
    }

    static long query(int start, int end, int node, int nodeLeft, int nodeRight) {
      if (start > nodeRight || end < nodeLeft) {
        return 0L;
      }
      if (start <= nodeLeft && end >= nodeRight) {
        return segmentArr[node];
      }
      int mid = (nodeLeft + nodeRight) / 2;
      return query(start, end, node * 2, nodeLeft, mid) + query(start, end, node * 2 + 1, mid + 1, nodeRight);
    }
  }
}