/**
 * 문제 이름 : 책 나눠주기
 * 작성자 : kkoon9
 * 날짜 : 2020.02.07
 * 링크 : https://www.acmicpc.net/problem/9576
 * N : 나눠줄 책의 개수 (1 ~ 1000)
 * M : 책을 원하는 학생 수 (1 ~ 1000)
 * a, b : 원하는 책 번호 구간 (1 ~ a ~ b ~ N)
 * 다음 줄부터 M개의 줄에는 책 번호 a, b가 주어진다
 * 책을 줄 수 있는 최대 학생 수를 구하라.
 * ********   첫 번째 생각    **************
 * 첫 번째로 생각이 든 건 greedy였다.
 * 크기가 N인 배열에 원하는 학생 수를 더해준다.
 * 그러고 난 뒤, 구간에서 가장 작은 인덱스의 값을 0, 나머지 구간 -1
 * ********   두 번째 생각    **************
 * 회의실배정이랑 비슷한 문제인데 그걸 생각 못해냈다 바보
 * b 기준으로 오름차순 정렬해주고 풀면 되는 문자였다.ㅠㅠ
 * */

 // 첫 도전 코드
 import java.io.*;
 import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        P9576();
    }
    static class Want {
        int a;
        int b;

        Want(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    static void P9576() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T;i++) {
            int answer = 0;
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int [] wantCount = new int[N+1];
            Want [] student = new Want[M];
            for(int j = 0 ; j<M;j++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                student[j] = new Want(a,b);
                for(int k = a; k <=b;k++)
                    wantCount[k]++;
            }
            for(int idx = 0;idx <M;idx++) {
                int min = Integer.MAX_VALUE;
                int minidx = -1;
                for(int a = student[idx].a; a<=student[idx].b;a++) {
                    if(wantCount[a] == 0){
                        continue;
                    }
                    wantCount[a]--;
                    if(wantCount[a] < min){
                        min = wantCount[a];
                        minidx = a;
                    }
                }
                if(minidx != -1) {
                    wantCount[minidx] = 0;
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }
}

// 두 번째 시도

public class Main1 {
    public static void main(String[] args) throws IOException {
        P9576();
    }
    static class Want implements Comparable<Want> {
        int a;
        int b;

        Want(int a, int b){
            this.a = a;
            this.b = b;
        }
        @Override
        public int compareTo(Want o) {
       int r = this.b - o.b;
        if(r==0) r = this.a - o.a;
        return r;
        }
    }
    static void P9576() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T;i++) {
            int answer = 0;
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            boolean [] wanted = new boolean[N+1];
            Want [] student = new Want[M];
            for(int j = 0 ; j<M;j++) {
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                student[j] = new Want(a,b);
            }
            Arrays.sort(student);
            for(int idx = 0;idx <M;idx++) {
                for(int a = student[idx].a; a<=student[idx].b;a++) {
                    if(!wanted[a]){
                        wanted[a] = true;
                        answer++;
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}