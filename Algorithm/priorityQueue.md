# PriorityQueue
- 우선순위 큐
```java
//장르 순위 판별을 위한 우선순위 큐 생성 (java에서 int형 우선순위 큐는 작은 것 부터 나오므로 lamda식을 이용해 역순으로 변환)
PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> y - x);
```

## 메서드
```java
public interface Queue<E> extends Collection<E> {
E element(); //큐의 처음에 있는 원소를 삭제하지 않고 가져온다. 큐가 비어있으면 예외발생
E peak(); //큐의 처음에 있는 원소를 삭제하지 않고 가져온다. 큐가 비어있으면 null을 반환
boolean offer(E e); //원소를 추가할 때 큐의 용량을 넘어서면 false를 반환한다.
E poll(); //큐의 처음에 있는 원소를 가져온다. 큐에 원소가 없으면 null을 반환한다.
E remove(); //큐의 처음에 있는 원소를 제거한다. 큐에 원소가 없으면 예외가 발생한다.
}
```
### element
### peak
### offer
### poll
### remove
