
//문제 이름 : 뉴스 클러스터링 
//작성자 : kkoon9 
//날짜 : 2020.08.26 
//링크 : https://programmers.co.kr/learn/courses/30/lessons/17677 
//합집합, 교집합을 구하는 문제 (+)
//순수 구현 문제 
//(+) 자카드 유사도를 몰라도 설명이 잘 나와있어서 풀 수 있었다. 
//(+)중복이 가능한 합집합, 교집합이라 multiSet을 사용했어야 했는데 java에는 없었음 
//(+)2차원 배열을 구현해서 풀이하였다.

class Solution {
  public int solution(String str1, String str2) {
    final int VALUE = 65536;
    final int SIZE = 27;
    int answer = 0;
    int[][] jaccard1 = new int[SIZE][SIZE];
    int[][] jaccard2 = new int[SIZE][SIZE];
    int emptyCount = 0; // 교집합 개수
    int unionCount = 0; // 합집합 개수
    // [1]. 모두 공집합일 때에는 1 (공집합 flag 값)
    boolean isEmptySet1 = true;
    boolean isEmptySet2 = true;
    float similarity = 0;
    // [2]. 대소문자 구분하지 않는다.
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();
    // [3]. 영문자가 아닌 쌍은 버린다.

    // jaccard1
    System.out.print("jaccard 1 : ");
    for (int i = 0; i < str1.length() - 1; i++) {
      char chFirst = str1.charAt(i);
      if (!isAlpha(chFirst)) { // 알파벳이 아니라면
        continue;
      }
      char chSecond = str1.charAt(i + 1);
      if (!isAlpha(chSecond)) { // 알파벳이 아니라면
        i++;
        continue;
      }
      System.out.print(chFirst + " " + chSecond + ", ");
      jaccard1[chFirst - 'a'][chSecond - 'a']++;
      isEmptySet1 = true;
    }
    System.out.println();
    System.out.print("jaccard 2 : ");
    // jaccard2
    for (int i = 0; i < str2.length() - 1; i++) {
      char chFirst = str2.charAt(i);
      if (!isAlpha(chFirst)) { // 알파벳이 아니라면
        continue;
      }
      char chSecond = str2.charAt(i + 1);
      if (!isAlpha(chSecond)) { // 알파벳이 아니라면
        i++;
        continue;
      }
      System.out.print(chFirst + " " + chSecond + ", ");
      jaccard2[chFirst - 'a'][chSecond - 'a']++;
      isEmptySet2 = false;
    }
    System.out.println();
    // [1]. 모두 공집합일 때에는 1
    if (isEmptySet1 && isEmptySet2) {
      answer = VALUE;
      return answer;
    }
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        // [4] 교집합 개수 구하기
        if (jaccard1[i][j] != 0 && jaccard2[i][j] != 0) {
          emptyCount += (jaccard1[i][j] > jaccard2[i][j]) ? jaccard2[i][j] : jaccard1[i][j];
        }
        // [5] 합집합 개수 구하기
        unionCount += (jaccard1[i][j] > jaccard2[i][j]) ? jaccard1[i][j] : jaccard2[i][j];
      }
    }
    System.out.println("emptyCount : " + emptyCount + " unionCount : " + unionCount);
    similarity = (float) emptyCount / unionCount;
    System.out.println("similarity : " + similarity);
    answer = (int) (VALUE * similarity);
    return answer;
  }

  public boolean isAlpha(char ch) {
    return (ch >= 'a' && ch <= 'z');
  }
}

class Main {
  public static void main(String[] args) throws Exception {
    Solution s = new Solution();
    String str1 = "FRANCE";
    String str2 = "french";
    int answer = s.solution(str1, str2);
    System.out.println(answer);
  }
}