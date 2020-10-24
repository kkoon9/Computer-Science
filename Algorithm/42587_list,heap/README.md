# 42587. 프린터

[링크](https://programmers.co.kr/learn/courses/30/lessons/42587)

|  난이도  | 정답률(\_%) |
| :------: | :---------: |
| Level II |      -      |

## 설계

- q와 pq에 prirorities에 있는 원소들을 넣어주었다.
- pq는 Collections.reverseOrder()를 통해 내림차순으로 설정해주었다.
- pq가 빌 때까지 q와 맞는 prior를 찾아주어 정답 큐인 aq에 넣어주었다.
- aq의 idx와 location이 같은 수를 카운팅하면서 찾아내어 카운팅한 값을 return 해준다.

### 시간 복잡도

- 우선순위 큐의 시간복잡도는 O(logn)이다.
- n만큼 반복문이 진행되므로 O(nlongn)이다.

## 정리

| 내 코드 (ms) | 빠른 코드 (ms) |
| :----------: | :------------: |
|      -       |       -        |

## 고생한 점
