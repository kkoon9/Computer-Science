/**
 * 문제 이름 : H-Index
 * 작성자 : kkoon9
 * 날짜 : 2019.12.05
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42747
 * 정렬을 사용한 문제!
 ******* 배운 점 ************
 * */
import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int h;
        Arrays.sort(citations);
        int ln = citations.length;
        for(int i = 0; i < ln; i++){
            h= citations[i];
            if(h >= (ln - i)){
                answer = (ln - i);
                break;
            }
        }
        return answer;
    }
}