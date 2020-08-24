/**
 * 문제 이름 : DFS와 BFS
 * 작성자 : kkoon9
 * 날짜 : 2020.02.08
 * 링크 : https://www.acmicpc.net/problem/1260
 * DFS와 BFS의 기초 문제
 * ********   내 풀이    **************
 * */
import java.util.*;
import java.io.*;

public class Main {
    static boolean [][] graph = new boolean[1002][1002];
    static boolean[] check = new boolean[1002];
    static Queue<Integer> q = new LinkedList<Integer>();
    public static void main(String[] args) throws IOException {
        P1260();
    }
    static void P1260() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);
        for(int i = 0 ;i<M;i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph[a][b] = graph[b][a] = true;
        }
        DFS(N,V);
        init();
        System.out.println();
        q.add(V);
        check[V] = true;
        BFS(N,V);
    }
    static void init() {
        for(int i = 0 ;i<1002;i++){
            check[i] = false;
        }
    }
    static void BFS(int N, int V) {
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0) {
                int val = q.poll();
                System.out.print(val + " ");
                for(int i = 1; i<=N;i++) {
                    if(graph[val][i] && !check[i]){
                        q.add(i);
                        check[i] = true;
                    }
                }
            }

        }
    }
    static void DFS(int N, int V) {
        check[V] = true;
        System.out.print(V + " ");
        for(int i = 1; i<=N;i++) {
            if(graph[V][i] && !check[i]){
                DFS(N,i);
            }
        }
    }
}