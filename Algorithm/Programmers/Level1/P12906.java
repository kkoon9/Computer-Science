/**
 * 문제 이름 : 같은 숫자는 싫어
 * 작성자 : kkoon9
 * 날짜 : 2020.01.26
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12906
 * arr : 배열  (매개변수)
 * 배열 arr의 각 원소는 0 ~ 9 까지 이루어져 있다.
 * arr에서 연속적으로 나탄나는 숫자는 하나만 남기고 전부 제거해야 한다.
 * 단, 제거된 후 남은 수들을 반환할 때에는 arr의 순서를 유지해야 한다.
 * arr의 크기 : 1,000,000 이하의 자연수
 * ********   1번째 시도      **************
 * LinkedList에 넣어준 뒤 마지막에 answer에 넣어줬더니 효율성에서 실패했다.
 * ********    배운 점      **************
 * LinkedList보다 ArrayList를 사용하자. 더 빠름
 *  
 * */

// 효율성 테스트에서 떨어진 코드
import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        int len = arr.length;
        List answerList = new LinkedList();
        answerList.add(arr[0]);
        for(int i = 1; i < len;i++){
            if(arr[i - 1] == arr[i]) continue;
            answerList.add(arr[i]);
        }
        int [] answer = new int[answerList.size()];
        for(int i = 0;i<answerList.size(); i++){
            answer[i] = (Integer) answerList.get(i);
        }
        return answer;
    }
}

// LinkedList가 아닌 ArrayList로 풀이
class Solution2 {
    public int[] solution(int []arr) {
        int len = arr.length;
        ArrayList<Integer> answerList = new ArrayList<Integer>();
        answerList.add(arr[0]);
        for(int i = 1; i < len;i++){
            if(arr[i - 1] == arr[i]) continue;
            answerList.add(arr[i]);
        }
        int [] answer = new int[answerList.size()];
        for(int i = 0;i<answerList.size(); i++){
            answer[i] = (Integer) answerList.get(i);
        }
        return answer;
    } 
}