/**
 * 문제 이름 : [1차] 다트 게임
 * 작성자 : kkoon9
 * 날짜 : 2020.02.20
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/17682
 * String 문제
 * split과 contains으로 문제를 해결하였다.
 * ********   제한 사항     **************
 * strings는 길이 1 이상, 50이하인 배열입니다.
 * strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
 * strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
 * 모든 strings의 원소의 길이는 n보다 큽니다.
 * 인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.
 * ********   해결 방법    **************
 * Comparator<String>() @Override compare를 사용했다.
 * 먼저 n번째 인덱스를 비교해준다.
 * 같다면 s1.compareTo(s2)를 해준다.
 * ********   배울만한 코드    **************
 * 속도는 느렸지만 재치있다 생각하여 추가했다.
 * n번째 글자를 strings의 맨 앞에 추가하여 정렬 후 answer에는 substring을 통해 1 ~ len까지의 문자열을 넣어줬다.
 * 출처 : https://keepgoing0328.tistory.com/entry/programmers-%EB%AC%B8%EC%9E%90%EC%97%B4-%EB%82%B4-%EB%A7%88%EC%9D%8C%EB%8C%80%EB%A1%9C-%EC%A0%95%EB%A0%AC%ED%95%98%EA%B8%B0-java
 * */
import java.util.*;
import java.io.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] SDT = new char[3];
        int[] ans = new int[3];
        int idx = 0;
        int len = dartResult.length();
        for(int i = 0;i<len;i++){
            char ch = dartResult.charAt(i);
            if(ch == 'S' || ch == 'D' || ch == 'T')
                SDT[idx++] = ch;
        }
        String[] str = dartResult.split("S|D|T");
        len = str.length;
        for(int i = 0 ;i<3;i++){
            char ch = SDT[i];
            String buffer = str[i];
            if(buffer.contains("*")){
                ans[i-1]*=2;
                if(i > 1)
                    ans[i-2] *=2;
                buffer = buffer.substring(1,buffer.length());
            }
            if (buffer.contains("#")) {
                ans[i-1] = - ans[i-1];
                buffer = buffer.substring(1,buffer.length());
            }
            int score = Integer.parseInt(buffer);
            if(ch == 'D'){
                score *= score;
            } else if(ch == 'T'){
                score *= (score * score);
            }
            ans[i] = score;
        }
        if(len == 4){
            if(str[3].equals("#")){
                ans[2] = -ans[2];
            } else { // str[3]이 *이면
                ans[1] *= 2;
                ans[2] *= 2;
            }
        }
        for(int i = 0 ;i<3;i++){
            answer += ans[i];
        }
        return answer;
    }
}