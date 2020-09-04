
/**
 * @desc [1차] 실패율
 * @desc https://programmers.co.kr/learn/courses/30/lessons/42889
 * @desc stages를 오름차순으로 했지만 어려워서 내림차순으로 정렬 후 풀이하였다.
 * @desc 도달했으나 아직 클리어하지 못한 플레이어 수가 0일 때 NaN이 들어간다. 이것을 예외처리 해주어야 함!
 */
import java.util.*;

class Solution {
  public int[] solution(int N, int[] stages) {
    int[] answer = new int[N];
    int[] stagePlayerNum = new int[N + 2];
    int AllPlayerCount = stages.length;
    Stage[] stage = new Stage[N];
    for (int i = 0; i < N + 2; i++) {
      stagePlayerNum[i] = 0;
    }
    for (int playerStage : stages) {
      stagePlayerNum[playerStage]++;
    }
    for (int i = 1; i <= N; i++) {
      if (AllPlayerCount <= 0 || stagePlayerNum[i] == 0) {
        stage[i - 1] = new Stage(i, 0.0);
        continue;
      }
      stage[i - 1] = new Stage(i, (double) stagePlayerNum[i] / AllPlayerCount);
      AllPlayerCount -= stagePlayerNum[i];
    }
    Arrays.sort(stage);
    for (int i = 0; i < N; i++) {
      answer[i] = stage[i].stageNum;
    }
    return answer;
  }

  class Stage implements Comparable<Stage> {
    int stageNum;
    double failPercent;

    Stage(int stageNum, double failPercent) {
      this.stageNum = stageNum;
      this.failPercent = failPercent;
    }

    @Override
    public int compareTo(Stage o) {
      int result = this.failPercent > o.failPercent ? -1 : 1;
      if (this.failPercent == o.failPercent) {
        result = 0;
      }
      return result;
    }
  }
}

class Kakao {
  public static void main(String[] args) throws Exception {
    Solution s1 = new Solution();

    int[] arr = { 4, 4, 4, 4, 4 };
    int[] A = { 1, 3, 6 };
    int[] B = { 2, 3, 6, 7, 9 };
    String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
        "Change uid4567 Ryan" };
    // System.out.println(s11.solution(8, 32, arr));
    int[] answer = s1.solution(7, arr);
    for (int str : answer) {
      System.out.print(str + " ");
    }
    System.out.println();
  }
}