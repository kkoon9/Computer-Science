/**
 * 문제 이름 : 블랙잭
 * 작성자 : kkoon9
 * 날짜 : 2020.02.02
 * 링크 : https://www.acmicpc.net/problem/2798
 * 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓고 숫자 M을 외친다.
 * 이제 플레이어는 N장의 카드 중에서 3장의 카드를 고른다.
 * 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
 * N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구하라.
 * N : 카드의 개수 (3 ~ 100)
 * M : 합의 최대(10 ~ 300,000)
 * ********   풀이 방법    **************
 * N의 개수가 100까지 밖에 없으므로 완전탐색으로 해도 시간초과가 나지 않는다.
 * */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(P2798());
    }
    static int P2798() throws IOException {
        /* 1. Init */
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] input = sc.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] arr = new int[N];
        input = sc.readLine().split(" ");
        for(int i =0;i<N;i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<N-2;i++) {
            for(int j = i + 1;j<N-1;j++) {
                for(int k =j + 1;k<N;k++) {
                    int temp = arr[i] + arr[j] + arr[k];
                    if(temp > max && temp <= M) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }
}