
/**
 * @desc [1차] 오픈채팅방
 * @desc https://programmers.co.kr/learn/courses/30/lessons/42888
 * @desc map을 활용하여 유저들의 닉네임을 관리하였다.
 */

import java.util.*;

class Solution {
  public String[] solution(String[] record) {
    final String ENTER = "Enter";
    final String LEAVE = "Leave";
    final String CHANGE = "Change";
    final String ENTERMESSAGE = "님이 들어왔습니다.";
    final String LEAVEMESSAGE = "님이 나갔습니다.";
    String[] answer = { "" };
    int length = record.length;
    String[][] str = new String[length][];
    HashMap<String, String> hm = new HashMap<>();
    for (int i = 0; i < record.length; i++) {
      str[i] = record[i].split(" ");
      if (!str[i][0].equals(LEAVE)) {
        hm.put(str[i][1], str[i][2]);
      }
      if (str[i][0].equals(CHANGE)) {
        length--;
      }
    }
    int i = 0;
    answer = new String[length];
    for (String[] player : str) {
      if (player[0].equals(ENTER)) {
        answer[i++] = hm.get(player[1]) + ENTERMESSAGE;
      } else if (player[0].equals(LEAVE)) {
        answer[i++] = hm.get(player[1]) + LEAVEMESSAGE;
      }
    }
    return answer;
  }
}

class Kakao {
  public static void main(String[] args) throws Exception {
    Solution s1 = new Solution();
    String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
        "Change uid4567 Ryan" };
    // System.out.println(s11.solution(8, 32, arr));
    String[] answer = s1.solution(record);
    for (String str : answer) {
      System.out.print(str + " ");
    }
    System.out.println();
  }
}