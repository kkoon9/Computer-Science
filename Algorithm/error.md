# Error 모음

## Index error
- Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
### 원인
- 다음과 같은 코드에 주어지는 answer에는 size가 주어져 있지 않다.
```java
int[] answer = {};
```
- 그래서 다음과 같이 사이즈를 주어준 다음 사용해야 한다.
```java
int [] answer = new int[SIZE];
```