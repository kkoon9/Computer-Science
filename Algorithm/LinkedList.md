# LinkedList

## ArrayList와 차이점

- ArrayList는 내부적으로 데이터를 배열에서 관리한다.
- 데이터의 추가, 삭제를 위해 **임시 배열을 생성**해 데이터를 복사 하는 방법을 사용 하고 있다.
- 대량의 자료를 추가/삭제 하는 경우에는 그만큼 데이터의 복사가 많이 일어나게 되어 성능 저하를 일으킬 수 있다.
- 반면 각 데이터는 인덱스를 가지고 있기 때문에 한번에 참조가 가능해 데이터의 **검색에는 유리**한 구현체이다.

## LinkedList?

- 데이터를 저장하는 각 노드가 이전 노드와 다음 노드의 상태만 알고 있다고 보면 된다.

## 검색

- 데이터 검색 시에는 ArrayList는 LinkedList에 비해 굉장히 빠르다.
- ArrayList는 **인덱스 기반**의 자료 구조이며 get(int index) 를 통해 O(1) 의 시간 복잡도를 가진다.
- 그에 비해 LinkedList는 검색 시 모든 요소를 탐색해야 하기 때문에 최악의 경우에는 O(N)의 시간 복잡도를 가진다.

## 삽입, 삭제

- LinkedList에서의 데이터의 삽입, 삭제 시에는 ArrayList와 비교해 굉장히 빠르다.
- LinkedList는 이전 노드와 다음 노드를 참조하는 상태만 변경하면 되기 때문이다.
- 삽입, 삭제가 일어날 때 O(1)의 시작 복잡도를 가진다. - 반면 ArrayList의 경우 삽입, 삭제 이후 다른 데이터를 복사해야 하기 때문에 최악의 경우 O(N) 의 성능을 내게 된다.

- 같은 타입의 많은 데이터를 관리하기 위해 상황에 맞게 적절하게 사용하기 위한 방법을 알아 보았는데 데이터 관리를 위한 성능 이슈를 위해 고려해야 요소들이 더 많음을 상기해야 한다.

---

## 출처

- https://www.holaxprogramming.com/2014/02/12/java-list-interface/
