/**
 * 문제 이름 : 큐
 * 작성자 : kkoon9
 * 날짜 : 2020.02.01
 * 링크 : https://www.acmicpc.net/problem/10845
 * 정수를 저장하는 큐을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하자.
 * push x : 정수 X를 큐에 넣는 연산이다.
 * pop : 큐에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size : 큐에 들어있는 정수의 개수를 출력한다.
 * empty : 큐이 비어있으면 1, 아니면 0을 출력한다.
 * front : 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * back : 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * N : 명령의 수 (입력) : 1 ~ 10000
 * 주어지는 정수는 1 ~ 100,000 이다.
 * 문제에 나와 있지 않은 명령이 주어지는 경우는 없다.
 * ********   배운 점    **************
 * java에서의 queue에는 뒤에 출력하는게 없음 ㅜㅜ
 * 
 * */
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        P10845();
    }
    static void P10845() throws IOException {
        /* 1. Init */
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(sc.readLine());
        Queue<Integer> q = new LinkedList<Integer>();
        String back = "";
        for (int i = 0; i < N; i++) {
            String[] command = sc.readLine().split(" ");
            String cmd = command[0];
            if(cmd.equals("push")) {
                q.add(Integer.parseInt(command[1]));
                back = command[1];
            } else if(cmd.equals("pop")) {
                if (!q.isEmpty())
                    System.out.println(q.poll());
                else
                    System.out.println("-1");
            } else if(cmd.equals("size")) {
                System.out.println(q.size());
            } else if(cmd.equals("empty")) {
                System.out.println(q.isEmpty() ? "1" : "0");
            } else if(cmd.equals("front")) {
                if (!q.isEmpty())
                    System.out.println(q.peek());
                else
                    System.out.println("-1");
            } else {
                if (q.isEmpty())
                    System.out.println("-1");
                else
                    System.out.println(back);
            }
        }
    }
}