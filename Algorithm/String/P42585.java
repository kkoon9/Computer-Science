/**
 * 문제 이름 : 쇠막대기
 * 작성자 : kkoon9
 * 날짜 : 2019.12.13
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42585
 * '('일 때 left_cnt++,
 * ')'일 때에는 바로 앞에 문자가 '('인지 ')'인지 확인한다.
 *   '('일 때에는 (left_cnt-1) 값을 answer에 추가해준다.
 *   ')'일 때에는 left_cnt--해주고 answer++ 해준다.
 ********    배운점      **************
 * charAt
 * (+) string index를 접근하려면 charAt() 메서드를 이용해야 한다.
 *  * */

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        int len = arrangement.length();
        int left_cnt = 1;
        for(int i = 1;i < len;i++){
            if(arrangement.charAt(i) == '(') {
                left_cnt++;
            }
            else {
                if(arrangement.charAt(i-1) == '('){
                    answer += (--left_cnt);
                }
                else {
                    answer++;
                    left_cnt--;
                }
            }
        }
        return answer;
    }
}