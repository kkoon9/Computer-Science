
/**
 * 문제 이름 : 파일명 정렬
 * 작성자 : kkoon9
 * 날짜 : 2020.08.27
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/17686
 * 정규표현식과 custom class를 통한 comparable compareTo를 사용한 문제!
 * 배운점 : String 배열을 new 연산자를 통해 선언했을 때 처음 값은 null이 들어가있다.
 * ********
 * */
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
  public class FileClass implements Comparable<FileClass> {
    String head;
    String number;
    String tail;

    FileClass(String head, String number, String tail) {
      this.head = head;
      this.number = number;
      this.tail = tail;
    }

    @Override
    public int compareTo(FileClass o) {
      int result = this.head.toLowerCase().compareTo(o.head.toLowerCase());
      if (result == 0) {
        result = Integer.parseInt(this.number) - Integer.parseInt(o.number);
      }
      return result;
    }
  }

  public String[] solution(String[] files) {
    String[] answer = new String[files.length];
    FileClass[] fileclass = new FileClass[files.length];
    for (int index = 0; index < files.length; index++) {
      String[] strArr = GetSlice(files[index]);
      fileclass[index] = new FileClass("", "", "");
      fileclass[index].head = strArr[0];
      fileclass[index].number = strArr[1];
      fileclass[index].tail = strArr[2];
    }
    Arrays.sort(fileclass);
    for (int i = 0; i < files.length; i++) {
      answer[i] = fileclass[i].head + fileclass[i].number + fileclass[i].tail;
    }

    return answer;
  }

  String[] GetSlice(String file) {
    String[] strArr = new String[3];
    strArr[2] = "";
    int i;
    for (i = 0; i < file.length(); i++) {
      if (file.charAt(i) >= '0' && file.charAt(i) <= '9')
        break;
    }
    strArr[0] = file.substring(0, i);
    file = file.substring(i);
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(file);
    m.find();
    strArr[1] = m.group();
    int length = strArr[1].length();
    if (length != file.length()) {
      strArr[2] = file.substring(length);
    }
    return strArr;
  }
}

class Main {
  public static void main(String[] args) throws Exception {
    Solution s = new Solution();
    String[] str = { "F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14" };
    s.solution(str);
  }
}