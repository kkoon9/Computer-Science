/**
 * 문제 이름 : 에디터
 * 작성자 : kkoon9
 * 날짜 : 2020.02.01
 * 링크 : https://www.acmicpc.net/problem/1406
 * 정답 비율 : 26.487%
 * 편집기가 지원하는 명령어
     * L : 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
     * D : 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
     * B : 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
     * (+) 삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
     * P $ : $라는 문자를 커서 왼쪽에 추가함
 * 문자열은 길이가 N이고 길이는 100,000을 넘지 않는다.
 * M : 명령어 개수 (입력)
 * T : 입력 데이터의 수 (입력)
 * PS : 괄호 문자열 (입력)
 * ********   풀이 방법    **************
 * '(' 면 push ')' 면 pop
 * 스택이 비었는데 ')'하면 "NO"
 * PS가 끝났는데 스택이 비어있지 않다면 "NO"
 * 
 * */