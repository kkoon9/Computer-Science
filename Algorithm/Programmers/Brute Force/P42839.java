/**
 * 문제 이름 : 소수 찾기
 * 작성자 : kkoon9
 * 날짜 : 2020.01.12
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42839
 * 완전 탐색(Brute Force) 문제!
 * String 타입 numbers에서 만들 수 있는 모든 순열을 찾을 때 애를 먹었다!
 * 소수 찾는 방법은 Math.sqrt를 사용하여 해결하였다!
 * */
import java.util.*;
import  java.lang.Math;

class Solution {
    Set <Integer> hs = new HashSet<Integer>();
    public int solution(String numbers) {
        int answer = 0;
        func("", numbers);
/*        for(Iterator i = hs.iterator(); i.hasNext();) {
            System.out.println(i.next());
        }*/
        for (Iterator i = hs.iterator(); i.hasNext(); ) {
            int val = (Integer) (i.next());
            if (val == 1 || val == 0) continue;
            boolean flag = false;
            for (int num = 2; num <= Math.sqrt(val); num++) {
                if (val % num == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            answer++;

        }
        return answer;
    }
    public void func(String s, String number) {
        if (number.length() == 0) {
            if(!s.equals(""))
                hs.add(Integer.parseInt(s));
        } else {
            for (int i = 0; i < number.length(); i++)
                func(s + number.charAt(i), number.substring(0,i) + number.substring(i+1, number.length()));
            for (int i = 0; i< number.length(); i++)
                func(s, number.substring(0,i) + number.substring(i+1, number.length()));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Solution Test = new Solution();
        int answer = Test.solution("011");
        System.out.println(answer);
    }
}