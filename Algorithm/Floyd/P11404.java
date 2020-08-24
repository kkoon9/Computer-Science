import java.io.*;
import java.util.*;

class Main {
    static int[][] cost;
    static int n, m;
    static int INF = 1000000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        StringTokenizer st = null;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        cost = new int[n + 4][n + 4];
        /**
         * 플로이드 알고리즘 [1]. 연결되지 않은 인덱스 - 무한대로 초기화
         */
        for(int i = 0 ;i<=n;i++)
            for(int j = 1; j<=n;j++)
                if(i!=j) cost[i][j] = INF;

        /**
         *  플로이드 알고리즘 [2]. 노드들 연결하기
         */
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[a][b] = Math.min(cost[a][b], c);
        }
        if(n==1){
            System.out.println(0);
            return;
        }
        /**
         *  플로이드 알고리즘 [3]. 최소 비용을 가지는 배열로 초기화
         */
        floyd();
        print();
    }

    static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(cost[i][j] == INF) cost[i][j] = 0;
                System.out.print(cost[i][j] + " ");
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
                    if(cost[i][j] > cost[i][k] + cost[k][j])
                        cost[i][j] = cost[i][k] + cost[k][j];
                }
            }
        }
    }
}