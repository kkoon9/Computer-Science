/**
 * 문제 이름 : K번째 수
 * 작성자 : kkoon9
 * 날짜 : 2019.12.04
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42748
 * 정렬을 사용한 문제!
 ******* 배운 점 ************
 * (+) Arrays 라이브러리 : sort, copyOfRange
 * */
import java.util.Arrays;

// 고유 번호(idx)와 재생 횟수(plays)를 가진 Song 클래스 생성
class Number {
    public int i;
    public int j;
    public int k;
    public Number(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
    }
}
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int ln = commands.length;
        int [] answer = new int[ln];
        for(int test_case = 0 ; test_case < ln; test_case++){
            Number num = new Number(commands[test_case][0], commands[test_case][1], commands[test_case][2]);
            int[] temp = Arrays.copyOfRange(array, num.i - 1, num.j);
            Arrays.sort(temp);
            answer[test_case] = temp[num.k -1];
        }
        return answer;
    }
}