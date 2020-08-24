/**
 * 문제 이름 : 에디터
 * 작성자 : kkoon9
 * 날짜 : 2020.02.01
 * 링크 : https://www.acmicpc.net/problem/1406
 * 정답 비율 : 26.487%
 * 편집기가 지원하는 명령어
     * L : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
     * D : 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
     * B : 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
     * (+) 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
     * P $ : $라는 문자를 커서 왼쪽에 추가함
 * 문자열은 길이가 N이고 길이는 100,000을 넘지 않는다.
 * M : 명령어 개수 (입력)
 * ********   풀이 방법    **************
 * Stack 두개를 두어 Cursor를 기준으로 앞 뒤에 있는 글자를 넣어준다.
 * ********   배운점    **************
 * 이 문제에서는 많은 걸 배웠다.
 * (1). Scanner보다는 BuffedReader를 사용해야 빠르다!
 * (2). String += 연산자보다는 StringBuilder를 사용하여 Append로 하자.
 * */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(P1406());
    }
    static String P1406() throws IOException {
        /* 1. Init */
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String init = sc.readLine();
        Stack<Character> frontCursor = new Stack<Character>();
        Stack<Character> backCursor = new Stack<Character>();

        int len = init.length();
        for(int i = 0; i<len;i++) {
            frontCursor.push(init.charAt(i));
        }
        int M = Integer.parseInt(sc.readLine());
        for(int i = 0; i< M;i++) {
            String[] command = sc.readLine().split(" ");
            char cmd = command[0].charAt(0);
            if(cmd == 'L') {
                if(!frontCursor.isEmpty()) {
                    backCursor.push(frontCursor.pop());
                }
            } else if(cmd == 'D') {
                if(!backCursor.isEmpty()) {
                    frontCursor.push(backCursor.pop());
                }
            } else if(cmd == 'B') {
                if(!frontCursor.isEmpty()){
                    frontCursor.pop();
                }
            } else {
                frontCursor.push(command[1].charAt(0));
            }
        }
        while(!frontCursor.isEmpty()) {
            backCursor.push(frontCursor.pop());
        }
        StringBuilder sb = new StringBuilder();
        while(!backCursor.isEmpty()) {
            sb.append(backCursor.pop());
        }
        return String.valueOf(sb);
    }
}