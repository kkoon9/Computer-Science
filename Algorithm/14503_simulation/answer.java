import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    solution.P14503();
  }
}

class Baekjoon {
  int[][] area;
  final int NON_CLEAN = 0;
  final int WALL = 1;
  final int ALREADY_CLEAN = 2;
  int[] dx = { 0, 1, 0, -1 };
  int[] dy = { -1, 0, 1, 0 };

  public void P14503() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int answer = 0;
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    area = new int[N][M];
    st = new StringTokenizer(br.readLine());
    int robotY = Integer.parseInt(st.nextToken());
    int robotX = Integer.parseInt(st.nextToken());
    int robotDirect = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        area[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    while (true) {
      // 1. 현재 위치를 청소한다.
      if (area[robotY][robotX] == NON_CLEAN) {
        answer++;
        area[robotY][robotX] = ALREADY_CLEAN;
      }
      int presentRobotDirect = robotDirect;
      boolean flag = false;
      // 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
      for (int i = 0; i < 4; i++) {
        if (--presentRobotDirect < 0) {
          presentRobotDirect = 3;
        }
        int x = robotX;
        int y = robotY;
        x += dx[presentRobotDirect];
        y += dy[presentRobotDirect];
        // 2-1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
        if (area[y][x] == NON_CLEAN) {
          robotX = x;
          robotY = y;
          robotDirect = presentRobotDirect;
          flag = true;
          break;
        }
        // 2-2. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다. continue
      }
      // 2-1
      if (flag) {
        continue;
      }
      // 2-3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
      int behindX = robotX + dx[(robotDirect + 2) % 4];
      int behindY = robotY + dy[(robotDirect + 2) % 4];

      // 2-4. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
      if (area[behindY][behindX] == WALL) {
        break;
      }
      robotX = behindX;
      robotY = behindY;
      robotDirect = presentRobotDirect;
    }
    System.out.println(answer);
  }
}