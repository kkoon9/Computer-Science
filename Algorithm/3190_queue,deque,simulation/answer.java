import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    Baekjoon solution = new Baekjoon();
    System.out.println(solution.P3190());
  }
}

class Baekjoon {
  final int NORMAL = 0;
  final int APPLE = 1;
  final int SNAKE = 2;
  int[] dy = { 0, 1, 0, -1 };
  int[] dx = { 1, 0, -1, 0 };
  int N;

  public int P3190() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int d = 0; // 처음에는 오른쪽(동)으로 가므로 초기값을 0으로 설정
    N = Integer.parseInt(br.readLine());
    int[][] board = new int[N + 1][N + 1];
    int K = Integer.parseInt(br.readLine()); // 사과의 개수
    for (int i = 0; i < K; i++) {
      st = new StringTokenizer(br.readLine());
      int y = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      board[y][x] = APPLE; // 사과의 위치
    }
    int L = Integer.parseInt(br.readLine());
    Queue<Turn> queue = new LinkedList<>();
    for (int i = 0; i < L; i++) {
      st = new StringTokenizer(br.readLine());
      int time = Integer.parseInt(st.nextToken());
      char turn = st.nextToken().charAt(0);
      queue.add(new Turn(time, turn));
    }

    Deque<Point> deque = new LinkedList<>(); // 뱀의 경로
    deque.addLast(new Point(1, 1));
    board[1][1] = 2;
    int dequeSize = 1;
    int time = 0;
    while (true) {
      time++;
      Point now = deque.peekFirst();
      Point next = new Point(now.y + dy[d], now.x + dx[d]);
      deque.addFirst(next);
      if (isLimit(next) || board[next.y][next.x] == SNAKE) { // 벽에 부딪히거나 자기 자신(뱀)에 부딪히는 경우 끝
        break;
      }
      if (board[next.y][next.x] == APPLE) {
        dequeSize++;
      }
      board[next.y][next.x] = SNAKE;
      if (deque.size() > dequeSize) {
        Point point = deque.pollLast();
        board[point.y][point.x] = NORMAL;
      }
      if (!queue.isEmpty() && queue.peek().time == time) {
        if (queue.poll().turn == 'D') { // 오른쪽으로 90도
          d = (d + 1) % 4;
        } else { // 왼쪽으로 90도
          d -= 1;
          if (d < 0) {
            d = 3;
          }
        }
      }
    }
    return time;
  }

  private boolean isLimit(Point next) {
    return next.x > N || next.y > N || next.x <= 0 || next.y <= 0;
  }

  private class Point {
    int y;
    int x;

    Point(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  private class Turn {
    int time;
    char turn;

    Turn(int time, char turn) {
      this.time = time;
      this.turn = turn;
    }
  }
}