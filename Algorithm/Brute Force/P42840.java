/**
 * 문제 이름 : 모의고사
 * 작성자 : kkoon9
 * 날짜 : 2019.12.17
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42840
 * 완전 탐색(Brute Force) 문제!
 * 말 그대로 완전 탐색 문제
 * ********    리펙터링      **************
 * Math.max를 겹쳐줌으로써 maxScore를 찾았다.
 * list에 maxScore와 같은 학생(1,2,3)을 추가해준다.
 * */

import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int oneScore = 0, twoScore = 0, threeScore = 0;

        int len = answers.length;
        for(int i=0;i<len;i++){
            if(answers[i] == one[i%5]) oneScore++;
            if(answers[i] == two[i%8]) twoScore++;
            if(answers[i] == three[i%10]) threeScore++;
        }
        int maxScore = Math.max(oneScore, Math.max(twoScore, threeScore));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == oneScore)list.add(1);
        if(maxScore == twoScore)list.add(2);
        if(maxScore == threeScore)list.add(3);
        int lLen = list.size();
        answer = new int[lLen];
        for(int i=0;i< lLen;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
