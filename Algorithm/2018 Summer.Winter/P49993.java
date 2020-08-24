/**
 * 문제 이름 : 스킬트리
 * 작성자 : kkoon9
 * 날짜 : 2020.01.30
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/49993
 * ********   제한 사항      **************
 * skill : 선행 스킬 순서 (매개변수)
 * skill_trees : 유저들이 만든 스킬트리를 담은 배열 (매개변수)
 * sequence : 선행 스킬 순서 초기값(1)
 * skillArr : 선행 스킬이 없는 스킬은 0, 선행 스킬이 있는 스킬들은 1부터 차례대로 값을 가진다.
 * 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
 * 스킬 순서와 스킬트리는 문자열로 표기합니다.
 * 예를 들어, C → B → D 라면 CBD로 표기합니다
 * 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
 * skill_trees는 길이 1 이상 20 이하인 배열입니다.
 * skill_trees의 원소는 스킬을 나타내는 문자열입니다.
 * skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
 * ********    풀이 방법      **************
 * skill_trees의 값들을 skillArr와 비교해주면서 answer를 ++ 해주면 된다.
 * */

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] skillArr = new int[26];
        int sequence = 1; // 스킬 순서
        for(int i = 0;i<skill.length();i++) {
            skillArr[skill.charAt(i) - 'A'] = sequence++;
        }
        int len = skill_trees.length;
        for(int i = 0; i<len;i++) {
            boolean flag = true;
            String st = skill_trees[i];
            int stLen = st.length();
            int skilltree = 1;
            for(int j = 0; j<stLen;j++) {
                int stCh = skillArr[st.charAt(j) - 'A'];
                if(stCh == 0) continue;
                if(stCh != skilltree){
                    flag = false;
                    break;
                } else {
                    skilltree++;
                }
            }
            if(flag)answer++;
        }
        return answer;
    }
}
