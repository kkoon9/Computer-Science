import java.io.*;
import java.util.*;

class Main {
    static int[][] height;
    static int n, m;
    static int INF = 10000000;
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        height = new int[n + 4][n + 4];
        /**
         * 플로이드 알고리즘 [1]. 연결되지 않은 인덱스 - 무한대로 초기화
         */
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++) {
                if (i != j) height[i][j] = INF;
            }
        }
        /**
         *  플로이드 알고리즘 [2]. 노드들 연결하기
         */
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            height[a][b] = 1;
        }
        /**
         *  플로이드 알고리즘 [3]. 최소 비용을 가지는 배열로 초기화
         */
        floyd();
        System.out.println(knowHeightCount());
    }
    static int knowHeightCount() {
        int know = 0;
        for (int i = 1; i <= n; i++) {
            int val = 0;
            for (int j = 1; j <= n; j++) {
                if(i==j)continue;
                if(height[i][j] == 1 || height[j][i] == 1)
                    val++;
            }
            if(val==(n-1))know++;
        }
        return know;
    }
    static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(height[i][j] == INF) height[i][j] = n+1;
                System.out.print(height[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void floyd() {
        // 거쳐가는 노드
        for(int k = 1; k <=n;k++){
            // 출발하는 노드
            for(int i =1;i<=n;i++){
                // 도착하는 노드
                for(int j =1;j<=n;j++){
                    if(i == j || i ==k || k == j) continue;
                    if(height[i][k] == 1 && height[k][j] == 1) {
                        height[i][j] = 1;
                    }
                }
            }
        }
    }
}