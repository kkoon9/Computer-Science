
/**
 * 문제 이름 : 튜플
 * 작성자 : kkoon9
 * 날짜 : 2020.08.27
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/64065
 * 정규표현식과 HashSet, custom class를 통한 comparable compareTo를 사용한 문제!
 * 배운점[1] : 이번에 사용한 정규표현식은 두고두고 쓸거 같다!
 * 배운점[2] : HashSet의 add 메서드 반환값은 true, false이다.
 * (+) : set에 있는 값을 add하면 false를 return.
 * ********
 * */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
  class Tuple implements Comparable<Tuple> {
    int[] list;
    int size;

    Tuple(int[] list, int size) {
      this.list = list;
      this.size = size;
    }

    @Override
    public int compareTo(Tuple o) {
      int result = this.size - o.size;
      return result;
    }
  }

  public int[] solution(String s) {
    int[] answer = {};
    s = s.substring(2);
    String[] str = s.split("\\{");
    Tuple[] tuple = new Tuple[str.length];
    for (int i = 0; i < str.length; i++) {
      int[] list = getNumber(str[i]);
      tuple[i] = new Tuple(list, list.length);
    }
    Arrays.sort(tuple);
    answer = new int[tuple[str.length - 1].size];
    int index = 0;
    HashSet<Integer> hs = new HashSet<>();
    for (int i = 0; i < tuple.length; i++) {
      int[] list = tuple[i].list;
      for (int number : list) {
        if (hs.add(number)) {
          answer[index++] = number;
        }
        ;
      }
    }
    return answer;
  }

  int[] getNumber(String str) {
    List<Integer> list = new LinkedList<>();
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(str);
    while (m.find()) {
      list.add(Integer.parseInt(m.group()));
    }
    int[] result = new int[list.size()];
    int i = 0;
    for (int number : list) {
      result[i++] = number;
    }
    return result;
  }
}

class Main {
  public static void main(String[] args) throws Exception {
    Solution s = new Solution();
    String sa = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
    String[] str = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14" };
    s.solution(sa);

  }
}