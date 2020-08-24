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
