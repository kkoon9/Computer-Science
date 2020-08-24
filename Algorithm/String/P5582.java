/**
 * 문제 이름 : 공통 부분 문자열
 * 작성자 : kkoon9
 * 날짜 : 2020.02.07
 * 링크 : https://www.acmicpc.net/problem/5582
 * 두 문자열이 주어졌을 때, 두 문자열에 모두 포함된 가장 긴 공통 부분 문자열을 찾아라.
 * 문자열의 길이는 1 ~ 4000 이다.
 * ********   첫 번째 생각    **************
 * contains 와 substring을 사용하여 완전탐색을 하였다.
 * 예상대로 시간초과!
 * ********   두 번째 생각    **************
 * 긴 것부터 시작해서 contains 되면 break해주는 걸로 생각함!
 * queue에 넣어서 한다.
 * */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(P5582());
    }
    static int P5582() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int answer = 0;
        answer = LCS(a,b);
        return answer;

    }
    static int LCS(String a, String b) { 
        int answer = 0;
        int max = 4004;
        int[][] memo = new int[max][max];
        int alength = a.length();
        int blength = b.length();
        for(int i = 0; i<alength;i++) {
            for(int j = 0;j<blength;j++) {
                if(a.charAt(i) == b.charAt(j)) {
                    memo[i + 1][j + 1] = memo[i][j] + 1;
                }
                answer = Math.max(answer, memo[i+1][j+1]);
            }
        }
        return answer;
    }
}