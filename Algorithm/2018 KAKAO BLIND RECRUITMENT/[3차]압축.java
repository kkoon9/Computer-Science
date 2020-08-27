
/**
 * 문제 이름 : 압축
 * 작성자 : kkoon9
 * 날짜 : 2020.08.27
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/17684
 * 문자열 메서드를 이용하여 풀이한 문제(startsWith)
 * 배운점 : 예외상황을 꼭 생각하자!
 * 문자열의 길이를 확인 후 startsWith나 substring을 사용해야한다. 
 * ********
 * */
import java.util.*;

class Solution {
  class Autocomplete {
    String word;
    int index;

    Autocomplete(String word, int index) {
      this.word = word;
      this.index = index;
    }
  }

  public int[] solution(String msg) {
    int[] answer = {};
    if (msg.length() == 1) {
      answer = new int[1];
      answer[0] = msg.charAt(0) - 'A' + 1;
      return answer;
    }
    LinkedList<Integer> list = new LinkedList<>();
    ArrayList<Autocomplete> dictionary = new ArrayList<>();
    int num = 27;
    HashMap<String, Integer> hm = new HashMap<>();
    list.add(msg.charAt(0) - 'A' + 1);
    dictionary.add(new Autocomplete(msg.substring(0, 2), num++));
    System.out.println(msg.substring(0, 2));
    msg = msg.substring(1);
    while (msg.length() > 1) {
      boolean isDictionary = false;
      System.out.println(msg);
      for (int i = dictionary.size() - 1; i >= 0; i--) {
        String word = dictionary.get(i).word;
        if (msg.startsWith(word)) { // 사전에 있는 단어인지 확인
          list.add(dictionary.get(i).index);
          msg = msg.substring(word.length());
          if (msg.length() != 0)
            dictionary.add(new Autocomplete(word + msg.substring(0, 1), num++));
          isDictionary = true;
          break;
        }
      }
      if (isDictionary) {
        continue;
      }
      list.add(msg.charAt(0) - 'A' + 1);
      dictionary.add(new Autocomplete(msg.substring(0, 2), num++));
      msg = msg.substring(1);
    }
    if (msg.length() != 0) {
      list.add(msg.charAt(0) - 'A' + 1);
    }
    answer = new int[list.size()];
    int i = 0;
    for (int number : list) {
      answer[i++] = number;
    }
    return answer;
  }
}

class Main {
  public static void main(String[] args) throws Exception {
    Solution s = new Solution();
    String sa = "ABABABABABABAB";
    String[] str = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14" };
    s.solution(sa);
  }
}