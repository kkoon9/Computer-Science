import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    System.out.println(solution.P13460());
  }
}

class Baekjoon {
  char[][] board;
  int dx[] = { 0, 0, 1, -1 };
  int dy[] = { 1, -1, 0, 0 };
  int N, M;

  public int P13460() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 세로
    M = Integer.parseInt(st.nextToken()); // 가로
    board = new char[N][M];
    int count = 0;
    Queue<Point> redQueue = new LinkedList<>();
    Queue<Point> blueQueue = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      board[i] = br.readLine().toCharArray();
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] == 'B') {
          blueQueue.add(new Point(i, j));
          board[i][j] = '.';
        } else if (board[i][j] == 'R') {
          redQueue.add(new Point(i, j));
          board[i][j] = '.';
        }
      }
    }
    while (!redQueue.isEmpty() && count < 10) {
      count++;
      int size = redQueue.size();
      for (int i = 0; i < size; i++) {
        Point R = redQueue.poll();
        Point B = blueQueue.poll();
        Point red = null;
        Point blue = null;
        for (int d = 0; d < 4; d++) {
          red = move(R.y, R.x, d);
          blue = move(B.y, B.x, d);
          if (board[red.y][red.x] == 'O' && board[blue.y][blue.x] != 'O') {
            return count;
          } else if (board[blue.y][blue.x] == 'O') {
            continue;
          } else if (red.y == blue.y && red.x == blue.x) {
            if (d == 0) {
              if (R.y < B.y) {
                red.y -= 1;
              } else {
                blue.y -= 1;
              }
            } else if (d == 1) {
              if (R.y > B.y) {
                red.y += 1;
              } else {
                blue.y += 1;
              }
            } else if (d == 2) {
              if (R.x < B.x) {
                red.x -= 1;
              } else {
                blue.x -= 1;
              }
            } else if (d == 3) {
              if (R.x > B.x) {
                red.x += 1;
              } else {
                blue.x += 1;
              }
            }
          }
          redQueue.add(red);
          blueQueue.add(blue);
        }
      }
    }
    return -1;
  }

  Point move(int y, int x, int d) {
    Point ball = null;
    int ny, nx;
    while (true) {
      ny = y + dy[d];
      nx = x + dx[d];
      if (isLimit(nx, ny)) {
        break;
      }
      if (board[ny][nx] == 'O') {
        ball = new Point(ny, nx);
        break;
      } else if (board[ny][nx] == '#') {
        ball = new Point(y, x);
        break;
      }
      y = ny;
      x = nx;
    }

    return ball;
  }

  private boolean isLimit(int nx, int ny) {
    return nx < 0 || ny < 0 || nx >= M || ny >= N;
  }

  class Point {
    int y;
    int x;

    Point(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }
}