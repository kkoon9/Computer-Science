# 알고리즘 풀면서 배운 java 메소드 모음

## HashMap
[링크](주소)

## StartsWith
- 이 메소드는 어떤 문자열이 주어진 접두표현을 가지고 시작하는지 확인한다.
- 만약 주어진 접두표현을 가지고 시작한다면 true, 아니라면 false
```java
public boolean startsWith(String prefix)
public boolean startWith String prefix, int offset)
// example
public class StartWithExample{
    public static void main(String args[]) {
        String s1 = "java string split method by javatpoint";
        System.out.println(s1.startsWith("ja"));

    }
}
```

## String 길이로 정렬
- 보통 String을 sort할 때에는 알파벳 순으로 한다.
```java
// example s1[3] = ["abc", "cd", "aaqq"];
Arrays.sort(s1);
// "aaqq", "abc", "cd"
```
- 다음은 길이로 정렬하는 코드이다.
```java
class comp implements Comparator<String> {
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            return 0;
        }
    }
}
// example s1[3] = ["abc", "cd", "aaqq"];
Arrays.sort(s1, new comp());
// "cd", "abc", "aaqq"
```
