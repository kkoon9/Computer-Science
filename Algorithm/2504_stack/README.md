# 2504. 괄호의 값

[링크](https://www.acmicpc.net/problem/2504)

|  난이도   | 정답률(\_%) |
| :-------: | :---------: |
| Silver II |   28.433    |

## 설계

1. 스택에 괄호를 넣어준다.
2. 수가 완성되면 숫자를 스택에 넣어준다.
3. 숫자와 숫자가 만나면 더해준다.
4. 숫자와 괄호가 만나면 곱해준다. ( : 2, [ : 3
5. 올바른 괄호가 아니라면 0을 리턴해준다.

### 시간 복잡도

## 정리

- 더 나은 코드를 봤는데 스택을 하나만 사용해도 됐다.
- 스택 하나만 사용하고 sum 변수를 사용하여 풀이하였다.

| 내 코드 (ms) | 빠른 코드 (ms) |
| :----------: | :------------: |
|      84      |       -        |

## 고생한 점

- 리팩토링이 필요