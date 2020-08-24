import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] lab;
    static int[][] tempLab;
    static boolean[][] visit;
    static int safeArea;
    static Queue<Dot> queue;
    static ArrayList<Dot> blank = new ArrayList<>(); // 입력이 0인 좌표
    static ArrayList<Dot> virus = new ArrayList<>(); // 입력이 2인 좌표

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /**
         * [1]. Init
         */
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N + 1][M + 1];
        tempLab = new int[N + 1][M + 1];
        visit = new boolean[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2)  // 바이러스 좌표 저장
                    virus.add(new Dot(i, j));
                if (lab[i][j] == 0) {
                    blank.add(new Dot(i, j));
                }
            }
        }
        int size = blank.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    if (isSame(blank.get(i), blank.get(j))) continue;
                    if (isSame(blank.get(j), blank.get(k))) continue;
                    if (isSame(blank.get(k), blank.get(i))) continue;
                    setLab();
                    setWall(blank.get(i), blank.get(j), blank.get(k));
                    queue = new LinkedList<>();
                    int virusCount = virus.size();
                    for (int v = 0; v < virusCount; v++) {
                        queue.add(virus.get(v));
                    }
                    BFS();
                    safeArea = (safeArea<getSafeArea())?getSafeArea():safeArea;
                }
            }
        }
        System.out.println(safeArea);
    }

    private static int getSafeArea() {
        int nonVirus = 0;
        for(int i = 0 ;i<N;i++){
            for(int j =0;j<M;j++){
                if(tempLab[i][j] == 0){
                    nonVirus++;
                }
            }
        }
        return nonVirus;
    }

    private static void setLab() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempLab[i][j] = lab[i][j];
                visit[i][j] = false;
            }
        }
    }

    private static boolean isSame(Dot dot1, Dot dot2) {
        int firstX = dot1.x;
        int firstY = dot1.y;
        int secondX = dot2.x;
        int secondY = dot2.y;
        if (firstX == secondX && firstY == secondY) {
            return true;
        }
        return false;
    }

    private static void setWall(Dot first, Dot second, Dot third) {
        int firstX = first.x;
        int firstY = first.y;
        int secondX = second.x;
        int secondY = second.y;
        int thirdX = third.x;
        int thirdY = third.y;
        tempLab[firstX][firstY] = tempLab[secondX][secondY] = tempLab[thirdX][thirdY] = 1;
    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int idx = 0; idx < size; idx++) {
                Dot v = queue.poll();
                int x = v.x;
                int y = v.y;
                for (int d = 0; d < 4; d++) {
                    int moveX = x + dx[d];
                    int moveY = y + dy[d];
                    if(isLimit(moveX,moveY)) continue;
                    if(visit[moveX][moveY])continue;
                    visit[moveX][moveY] = true;
                    if(tempLab[moveX][moveY] == 1) continue;
                    tempLab[moveX][moveY] = 2;
                    queue.add(new Dot(moveX,moveY));
                }
            }
        }
    }

    private static boolean isLimit(int moveX, int moveY) {
        return moveX < 0 || moveY < 0 || moveX >= N || moveY >= M;
    }

    private static class Dot {
        int x, y;

        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}