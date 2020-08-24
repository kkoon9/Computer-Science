/**
 * 문제 이름 : KMP는 왜 KMP일까? 
 * 작성자 : kkoon9
 * 날짜 : 2020.02.04
 * 링크 : https://www.acmicpc.net/problem/2902
 * 사람들은 사람 성이 들어간 알고리즘을 두 가지 형태로 부른다.
 * 첫 번째는 성을 모두 쓰고, 이를 하이픈(-)으로 이어 붙인 것이다. 예를 들면, Knuth-Morris-Pratt이다. 이것을 긴 형태라고 부른다.
 * 두 번째로 짧은 형태는 만든 사람의 성의 첫 글자만 따서 부르는 것이다. 예를 들면, KMP이다.
 * 긴 형태의 알고리즘 이름이 주어졌을 때, 이를 짧은 형태로 바꾸어 출력하는 프로그램을 작성하시오.
 * ********   풀이 방법    **************
 * split("-")를 통해 String 배열로 입력 받는다.
 * stringBuilder를 사용하여 append로 input[i]의 0번째 문자를 합친다.
 * answer을 toString()으로 return 해준다.
 * */
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(P2902());
    }
    static String P2902() throws IOException {
        /* 1. Init */
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String[] input = sc.readLine().split("-");
        StringBuilder answer = new StringBuilder();
        for(int i = 0;i<input.length;i++) {
            answer.append(input[i].charAt(0));
        }
        return answer.toString();
    }
}