# 11279. 최대 힙

[링크](https://www.acmicpc.net/problem/11279)

|  난이도   | 정답률(\_%) |
| :-------: | :---------: |
| Silver II |   43.523    |

## 설계

1. Comparator.reverseOrder()를 사용하면 내림차순으로 우선순위 큐(최대 힙)에 넣을 수 있다.
2. 연산자 0이 나왔을 때, 우선순위 큐가 비어 있다면 0을 StringBuilder에 넣어준다.
3. 0이 아닌 값이 들어오면 우선순위 큐에 넣어준다.

### 시간 복잡도

- 우선순위 큐의 시간복잡도는 O(logn)이다.

## 정리

- System.out.println()을 사용하는 것보다 StringBuilder에 넣어서 한꺼번에 출력해주는 것이 더 시간적으로 절약될 수 있다.

| 내 코드 (ms) | 빠른 코드 (ms) |
| :----------: | :------------: |
|     340      |       -        |

## 고생한 점
