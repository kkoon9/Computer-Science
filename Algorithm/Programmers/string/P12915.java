/**
 * 문제 이름 : 문자열 내 마음대로 정렬하기
 * 작성자 : kkoon9
 * 날짜 : 2020.01.28
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12915
 * String + sort 문제
 * strings : 문자열로 구성된 리스트 (매개변수)
 * n : 기준으로 잡을 문자열의 인덱스 (매개변수)
 * 각 n번째 글자를 기준으로 오름차순 정렬을 하려 한다.
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
class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.charAt(n) > s2.charAt(n)) return 1;
                else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                else if(s1.charAt(n) < s2.charAt(n)) return -1;
                else return 0;
            }
        });
        return strings;
    }
}

// 배울 만한 코드
class Solution2 {
    public String[] solution(String[] strings, int n) {
        for(int i = 0 ; i < strings.length; i++) {
            strings[i] = strings[i].charAt(n) + strings[i];
        }
        Arrays.sort(strings);
        String[] ans = new String[strings.length];
        for(int i = 0 ; i < strings.length; i++) {
            ans[i] = strings[i].substring(1,strings[i].length());
        }
        return ans;
    }
}
