
/**
 * 문제 이름 : 셔틀버스
 * 작성자 : kkoon9
 * 날짜 : 2020.08.26
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/17678
 * sort를 사용한 문제!
 * (+) 순수 구현 문제
 * (+) 여러 가지 경우의 수를 염두하고 풀어야 하는 문제
 * ********
 * */
import java.util.Arrays;

class Solution {
  public String solution(int n, int t, int m, String[] timetable) {
    String answer = "";
    int[] timetableInt = new int[timetable.length];
    // [1] timetable Integer화
    for (int i = 0; i < timetable.length; i++) {
      timetableInt[i] = StringToInt(timetable[i]);
    }
    // [2] timetable sorting
    Arrays.sort(timetableInt);
    // [3]. 콘이 타야하는 마지막 버스 시간
    int index = 0;
    int busTime = 9 * 60;// 버스가 처음 도착하는 시간 셋팅
    int last = 0;
    while (n-- > 0) {
      int accept = m;// 수용 인원을 초기화
      int time = 0;// 마지막으로 탄 크루의 시간을 저장하기 위함

      while (accept > 0 && index < timetable.length) {// 기다리는 크루가 있다면
        if (timetableInt[index] <= busTime) {// 현재 버스의 도착시간보다 일찍왔으며, 수용인원도 있을 때,
          accept--;
          time = timetableInt[index++];
        } else
          break;
      }

      // 마지막 버스가 아님
      if (n > 0) {
        if (index >= timetableInt.length) {// 기다리는 크루가 없다면
          last = busTime + ((n + 1) * t);// 마지막 버스의 도착시간
          break;
        }
        busTime += t;// 버스의 다음 시간 셋팅
      } else {// 마지막 버스
        if (accept > 0)
          last = busTime;// 수용인원이 있다면, 버스의 도착시간으로
        else
          last = time - 1;// 없다면, 마지막으로 탄 크루의 시간보다 1분 일찍
        break;

      }
    }
    answer = IntToString(last);
    return answer;
  }

  public int StringToInt(String timeStr) {
    return Integer.parseInt(timeStr.substring(0, 2)) * 60 + Integer.parseInt(timeStr.substring(3));
  }

  public String IntToString(int timeInt) {
    return String.format("%02d", timeInt / 60) + ":" + String.format("%02d", timeInt % 60);
  }
}