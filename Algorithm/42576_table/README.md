# 42576. 완주하지 못한 선수

[링크](https://programmers.co.kr/learn/courses/30/lessons/42576)

| 난이도  | 정답률(\_%) |
| :-----: | :---------: |
| Level I |      -      |

## 설계

- getOrDefault과 put을 사용하여 선수(participant)를 넣어준다.
- 그 다음 completion을 순회하면서 participant를 넣어준데에서 빼준다.
- 마지막에 hm에 남아있는(value가 1인) 선수를 출력해준다.

### 시간 복잡도

## 정리

- keySet하고 get하는 방법은 비효율적인 방법이다 : HashMap을 두 번 체크하기 때문!
- for (Map.Entry<String, Integer> entry : hm.entrySet()) : May.Entry를 사용하자.

| 내 코드 (ms) | 빠른 코드 (ms) |
| :----------: | :------------: |
|      -       |       -        |

## 고생한 점
