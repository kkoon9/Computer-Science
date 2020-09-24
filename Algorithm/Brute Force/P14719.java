
/**
 * @틀린이유 스택을 사용했는데 반례가 존재했다.
 * @반례 6 6
 * @반례 6 1 4 0
 * @접근방법 현재 인덱스 기준으로 왼쪽, 오른쪽의 최대값을 구한다.
 * @접근방법 각 최대값 중 작은 값에서 현재 인덱스의 값을 빼준다.
 * @주의할점 각 최대값 중 작은 값이 현재 인덱스의 값보다 작다면 그대로 넘어간다.
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P14719());
  }

  static int H, W;

  static int P14719() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int answer = 0;
    int lowBlock;
    Stack<Integer> stack = new Stack<>();
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    int[] blocks = new int[W];
    st = new StringTokenizer(br.readLine());
    for (int block = 0; block < W; block++) {
      blocks[block] = Integer.parseInt(st.nextToken());
    }
    for (int block = 1; block < W - 1; block++) {
      int maxLeft = GetMaxLeft(blocks, block);
      int maxRight = GetMaxRight(blocks, block);
      if (Math.min(maxLeft, maxRight) < blocks[block])
        continue;
      answer += Math.min(maxLeft, maxRight) - blocks[block];
    }
    return answer;
  }

  private static int GetMaxRight(int[] blocks, int index) {
    int max = -1;
    for (int i = index + 1; i < W; i++) {
      max = Math.max(max, blocks[i]);
    }
    return max;
  }

  private static int GetMaxLeft(int[] blocks, int index) {
    int max = -1;
    for (int i = 0; i < index; i++) {
      max = Math.max(max, blocks[i]);
    }
    return max;
  }
}