/**
 * 문제 이름 : 조이스틱
 * 작성자 : kkoon9
 * 날짜 : 2019.12.19
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42860
 * Greedy Algorithm를 사용한 문제!
 * ********   제한 사항      **************
 * 맨 처음에는 A로만 이루어져 있다.
 * 세 글자면 AAA, 네 글자면 AAAA !
 * 조이스틱을 각 방향으로 움직이면 다음과 같다.
     * ▲ - 다음 알파벳
     * ▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z)
     * ◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
     * ▶ - 커서를 오른쪽으로 이동
 * ********    주의 사항      **************
 * 위 아래로 움직이는 건 고정이므로 좌 우로 어떻게 움직일지가 중요하다.
 * */
class Solution {
    public int solution(String name) {
        int answer = 0;
        int exp = name.length() - 1;
        for(int i = 0; i < name.length(); i++){
            char c = name.charAt(i);
            answer += ('Z'- c + 1) > c - 'A' ? c - 'A' : ('Z' - c + 1);
            if(c == 'A'){
                int nextIdx = i+1;
                int countA = 0;
                while (nextIdx < name.length() &&
                        name.charAt(nextIdx) == 'A'){
                    countA ++;
                    nextIdx++;
                }
                int tmp = i*2 + (name.length() -1 -i - countA) ;
                if(exp > tmp) exp = tmp;
            }
        }

        answer += exp;
        return answer;
    }
}