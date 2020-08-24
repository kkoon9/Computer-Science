/**
 * 문제 이름 : 분해합
 * 작성자 : kkoon9
 * 날짜 : 2020.02.02
 * 링크 : https://www.acmicpc.net/problem/2231
 * N : 자연수 (1 ~ 1,000,000)
 * 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
 * 어떤 자연수 N의 분해합이 N인 경우, M을 N의 생성자라 한다.
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구하라.
 * 생성자가 없는 경우에는 0을 출력한다.
 * ********   내 풀이    **************
 * 1부터 N까지 해서 생성자를 구한다.
 * 생성자가 N이라면 그 인덱스가 답
 * */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(P2231());
    }
    static int P2231() throws IOException {
        /* 1. Init */
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] input = sc.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int i = 1;
        int max = Integer.MAX_VALUE;
        int maxIdx = 0;
        int[] creater = new int[N + 1];
        for(i = 1;i<=N;i++) {
            int buf = decomposition(i);
            creater[i] = buf;
            if(buf == N) if(max > buf){
                max =  buf;
                maxIdx = i;
                break;
            }
        }
        return maxIdx;
    }
    static int decomposition(int N) {
        int answer = N;
        String str = Integer.toString(N);
        for(int i = 0; i < str.length();i++) {
            answer += str.charAt(i) - '0';
        }
        return answer;
    }
}