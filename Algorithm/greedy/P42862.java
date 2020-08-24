/**
 * 문제 이름 : 체육복
 * 작성자 : kkoon9
 * 날짜 : 2019.12.19
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42862
 * Greedy Algorithm를 사용한 문제!
 * ********   제한 사항      **************
 * 전체 학생의 수는 2 ~ 30 이다.
 * 체육복을 도난당한 학생의 수는 1 ~ n 이고 중복되는 번호는 없다.
 * 여벌의 체육복을 가져온 학생의 수는 1 ~ n 이고 중복되는 번호는 없다.
 * 여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있다.
 * 여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있다.
 * 
 * ********    첫 번째 시도      **************
 * testcase 12만 실패했다.
 * 반례 : 3, [1, 2], [2, 3] 기댓값 : 2
 * ********    주의 사항      **************
 * (1) lostLen이 1이거나 n일 때를 생각해야 한다.
 * (2) 여벌 옷을 가져온 학생이 도난당할 수도 있다는 것을 생각해야 한다.
 * (+) 여벌 옷을 가져온 학생이 도난당했다면 무조건 자기 자신이 입어야 한다.
 * (+) 그러므로 (2)는 이 반복문에서 빼줘야 한다.
 * (3) (2)에서 수행된 경우 lost[i]를 0으로 바꿔줘야한다.
 * */
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int lostLen = lost.length;
        int reserveLen = reserve.length;
        boolean[] reserveBoolean = new boolean[n + 1];
        for (int i = 0; i < reserveLen; i++) {
            reserveBoolean[reserve[i]] = true;
        }
        for (int i = 0; i < lostLen; i++) {
            if (reserveBoolean[lost[i]]) {// (2)
                reserveBoolean[lost[i]] = false;
                lost[i] = 0; // (3)
            }
        }
        for (int i = 0; i < lostLen; i++) {
            int student = lost[i];
            if(student == 0) continue; // (3)
            /**
             * (1) lostLen이 1이거나 n일 때를 생각해야 한다.
             * (2) 여벌 옷을 가져온 학생이 도난당할 수도 있다는 것을 생각해야 한다.
             * (+) 여벌 옷을 가져온 학생이 도난당했다면 무조건 자기 자신이 입어야 한다.
             * (+) 그러므로 (2)는 이 반복문에서 빼줘야 한다.
             * (3) (2)에서 수행된 경우 lost[i] 값을 0으로 바꿔준다.
             */
            if (student == 1) { // (1)
                if (!reserveBoolean[2]) answer--;
                else reserveBoolean[2] = false;
            } else if (student == n) { // (1)
                if (!reserveBoolean[n - 1]) answer--;
                else reserveBoolean[n - 1] = false;
            } else {
                if (reserveBoolean[student - 1])
                    reserveBoolean[student - 1] = false;
                else {
                    if (reserveBoolean[student + 1])
                        reserveBoolean[student + 1] = false;
                    else
                        answer--;
                }
            }
        }
        return answer;
    }
}