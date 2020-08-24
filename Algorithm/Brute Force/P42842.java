/**
 * 문제 이름 : 카펫
 * 작성자 : kkoon9
 * 날짜 : 2020.01.16
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42842
 * 완전 탐색(Brute Force) 문제!
 * 이건 해답을 본 문제!
 * ********** 잘못된 접근 방법 ************
 * Red, Brown에 따라서 경우의 수를 생각했었다.
 * 그렇기 때문에 로직도 복잡해졌다.
 * *********** 해답 접근 방법 ************
 * Red, Brown이 아닌 정답 [가로, 세로]의 값에 따라 Red를 찾아주었다.
 * Brown값은 가로가 모두 같지만 Red의 값이 다르다는 점을 찾아낼 수 있었다.
 * 출처 : https://chaibin0.tistory.com/entry/%EC%B9%B4%ED%8E%AB
 * */

import java.util.*;
class Solution {
    public int[] solution(int brown, int red) {
        int x = (brown - 2) / 2;
        int y = 3;
        int firstRed = x - 2;
        int lastRed = x - 2;
        int i = 0;

        while(true){
            if(lastRed == red) break;
            i++;
            x -= 1;
            y += 1;
            lastRed = (firstRed - i) * (i + 1);
        }

        int[] answer = {x, y};

        return answer;
    }
}

class Solution2 {
    public int[] solution(int brown, int red) {
        int sum = brown + red;
        int height, width;
        for (height = 3; ; height++) {
            if (!(sum % height != 0)) {
                width = sum / height;
                if (((height - 2) * (width - 2)) == red)
                    break;
            }
        }
        int answer[] = {width, height};
        return answer;
    }
}