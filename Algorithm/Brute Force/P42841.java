/**
 * 문제 이름 : 숫자 야구
 * 작성자 : kkoon9
 * 날짜 : 2020.01.12
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42841
 * 완전 탐색(Brute Force) 문제!
 * 이건 해답을 본 문제!
 * 먼저 숫자 야구에서 가능한 수를 stack에 넣어준다.
 * baseball에 있는 모든 경우를 stack 모두에 비교해주고 해당되는 숫자를 다른 스택(temp)에 넣어준다.
 * 출처 : https://lkhlkh23.tistory.com/71
 * */
import java.util.*;
class Solution {
    public static int solution(int[][] baseball) {
        Stack stack = new Stack<String>();
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
                for(int k = 1; k < 10; k++) {
                    if(i != j && j != k && i != k) {
                        stack.add(String.valueOf(i * 100 + j * 10 + k));
                    }
                }
            }
        }
        Stack temp = new Stack<String>();
        boolean flag = true;
        while(!stack.isEmpty()) {
            String num = (String) stack.pop();
            for(int i = 0; i < baseball.length && flag; i++) {
                int strike = strike(num, String.valueOf(baseball[i][0]));
                int ball = ball(num, String.valueOf(baseball[i][0])) - strike;
                if(strike != baseball[i][1] || ball != baseball[i][2]) {
                    flag = false;
                }
            }
            if(flag) {
                temp.add(num);
            }
            flag = true;
        }
        return temp.size();
    }

    public static int strike(String num, String target) {
        int cnt = 0;
        for(int i = 0; i < target.length(); i++) {
            cnt = num.charAt(i) == target.charAt(i) ? cnt + 1 : cnt;
        }
        return cnt;
    }

    public static int ball(String num, String target) {
        int cnt = 0;
        for(int i = 0; i < target.length(); i++) {
            cnt = num.contains(String.valueOf(target.charAt(i))) ? cnt + 1 : cnt;
        }
        return cnt;
    }
}
