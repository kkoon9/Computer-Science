# HashMap

## HashMap?
- Java Collections Framework에 속한 구현체 클래스입니다.
- Key와 value를 묶어 하나의 entry로 저장한다.
- hashing을 사용하기 때문에 많은 양의 데이터를 검색하는데 뛰어난 성능을 갖는다.
    * Map 인터페이스의 한 종류이다.
    * key 값은 중복이 불가능하다.
    * value에 null값도 사용 가능하다.
    * 멀티쓰레드에서는 HashTable를 사용한다.

## hash_Map vs map
## hash_map
- 특정 키에 대한 값을 찾는 과정에서 hash table을 이용해서 key-value 관계를 유지한다.
### Big(O)
- 이상적으로 O(1)의 시간 소요
- 실제로는 hash table의 크기에 반비례하는 O(n)의 시간을 소요

## map
- red-black tree를 이용한다.


## Method
### values
### containsKey
### keySet
### entrySet
### get

## entrySet, keySet, get
- KeySet을 한 뒤 get을 이용하여 value 값을 얻어오는 코드 방식은 비효율적입니다. HashMap을 두 번 체크하기 때문입니다.
- entrySet을 이용하여 key와 value를 모두 가져와서 하면 HashMap을 한 번만 체크할 수 있습니다.

## HashMap vs. HashTable
- HashTable : JDK 1.0부터 있던 Java API
- HashMap : Java 2에서 처음 선보인 JCF에 속한 API
[출처 Naver D2](https://d2.naver.com/helloworld/831311)


* * *
### JCF
- 1998년 12월에 발표한 Java 2에서 정식으로 선보였습니다.