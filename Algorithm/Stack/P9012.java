/**
 * 문제 이름 : 괄호
 * 작성자 : kkoon9
 * 날짜 : 2020.01.31
 * 링크 : https://www.acmicpc.net/problem/9012
 * 스택 문제
 * 괄호 문자열은 두 개의 괄호 기호인 "("와 ")" 만으로 구성되어 있는 문자열이다.
 * 괄호의 모양이 바르게 구성된 문자열을 올바른 괄호 문자열(Valid PS, VPS)이라고 부른다.
 * 한 쌍의 괄호 기호로 된 “( )” 문자열은 기본 VPS 이라고 부른다. 
 * 입력은 T개의 테스트 데이터로 주어진다.
 * PS의 길이는 2 ~ 50 이다.
 * T : 입력 데이터의 수 (입력)
 * PS : 괄호 문자열 (입력)
 * ********   풀이 방법    **************
 * '(' 면 push ')' 면 pop
 * 스택이 비었는데 ')'하면 "NO"
 * PS가 끝났는데 스택이 비어있지 않다면 "NO"
 * 
 * */

import java.util.*;

class Solution {

    public void P9012() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // nextInt를 받아올 때 \n때문에 해준다.
        for(int i = 0;i<T;i++) {
            Stack<Character> st = new Stack<Character>();
            String PS = sc.nextLine();
            int len = PS.length();
            boolean flag = true;
            for(int j = 0;j<len;j++) {
                if(PS.charAt(j) == '('){
                    st.push('(');
                } else {
                    if(st.isEmpty()){
                        flag = false;
                        break;
                    } else {
                        st.pop();
                    }
                }
            }
            if(!st.isEmpty()) {
                flag = false;
            }
            if(flag){
                System.out.println("YES");
            } else
                System.out.println("NO");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution Test = new Solution();
        Test.P9012();
    }
}
