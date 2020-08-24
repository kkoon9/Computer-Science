/**
 * 문제 이름 : 스택
 * 작성자 : kkoon9
 * 날짜 : 2020.01.31
 * 링크 : https://www.acmicpc.net/problem/10828
 * 스택 문제
 * 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하자.
 * push X: 정수 X를 스택에 넣는 연산이다.
 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * size: 스택에 들어있는 정수의 개수를 출력한다.
 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 * N : 명령의 수 (입력) : 1 ~ 10000
 * 주어지는 정수는 1 ~ 100,000 이다.
 * 문제에 나와 있지 않은 명령이 주어지는 경우는 없다.
 * ********   배운 점    **************
 * java에서는 Scanner를 통해 입력을 받는다.
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
 * 
 * */
import java.util.*;

class Solution {

    public void P10828() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); // nextInt를 받아올 때 \n때문에 해준다.
        Stack<String> st = new Stack<String>();
        for(int i = 0;i<n;i++) {
            String input = sc.nextLine();
            String[] command = input.split(" ");
            if(command[0].equals("push")) {
                st.push(command[1]);
            } else if(command[0].equals("pop")) {
                if(st.isEmpty()){
                    System.out.println("-1");
                } else {
                    System.out.println(st.peek());
                    st.pop();
                }
            } else {
                command(st,command);
            }
        }
    }
    void command(Stack<String> st, String[] command) {
        String result = "";
        String cmd = command[0];
        if(cmd.equals("size")) {
            System.out.println(st.size());
        }
        else if(cmd.equals("empty")){
            if(st.isEmpty())
                System.out.println("1");
            else
                System.out.println("0");
        } else{
            if(st.isEmpty()){
                System.out.println("-1");
            } else {
                System.out.println(st.peek());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution Test = new Solution();
        Test.P10828();
    }
}