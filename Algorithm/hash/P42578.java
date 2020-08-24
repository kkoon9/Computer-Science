/**
 * 문제 이름 : 위장
 * 작성자 : kkoon9
 * 날짜 : 2019.12.02
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42578
 * HashMap을 사용한 문제!
 ********* 첫 번째 시도 **************
 * 의상의 종류를 key값으로 두고 종류별 개수를 value로 두었다.
 * hashmap의 size가 1이 아닐 때 hm의 value들을 모두 곱해주었다.
 * 그런 뒤 answer에 clothes의 length를 더해준 뒤 return하였다.
 * 
 ********    해답      **************
 * 경우의 수를 구하는 공식
 * 모든 종류의 옷은 입거나 안입거나
 * (+) value에 1을 더해준 이유 : 안 입었을 경우
 * (+) 마지막 answer에 1을 빼준 이유 : 모두 안입었을 경우를 빼준다.
 * (+) hm.values : key값은 필요없으므로 value 값만 가져온다.
 * */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        int size = clothes.length;
        HashMap<String, Integer> hm = new HashMap();
        for(int i=0;i<size;i++){
            hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
        }
        answer = 1;
        for(int value : hm.values()) {
            answer *= (value+1);
            }
        answer--;
        return answer;
    }
}