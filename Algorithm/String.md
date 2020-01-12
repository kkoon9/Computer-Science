# String 관련

## 형변환
### Int to String
- Integer.toString(int 변수) : Int to String
- Integer.parseInt(String 변수) : String to Int

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

## 문자열 자르기
### 1. substring
- index를 이용하여 문자열 자르는 방식
- String.substring(start) // 문자열 start index부터 끝까지 문자열 자르기
- String.substring(start, end) // 문자열 start index부터 end-1 index까지 문자열 자르기
```java
//예제
String str = "ABCDEFG"; //대상 문자열
/*A=0 B=1 C=2 D=3 E=4 F=5 G=6의 index를 가진다.*/
		
str.substring(3); 
/*substring(시작위치) 결과값 = DEFG*/

str.substring(3, 6); 
/*substring(시작위치,끝위치) 결과값 = DEF*/
```
### 2. split
- 특정문자를 기준으로 문자열을 잘라서 배열에 넣어주는 방식
- 문자열배열 = 대상문자열.split("기준문자");
```java
//예제
String str = "";

for(int i=0;i<5;i++) {
str += i+"#";
}
		
String[] array = str.split("#");
		
for(int i=0;i<array.length;i++) {
System.out.println(array[i]);
}

//결과값 
//array[0] = 1
//array[1] = 2
//array[2] = 3
//array[3] = 4
```
- [출처](https://coding-factory.tistory.com/126)