class Solution {
    static char[] left = {'(','{','[','<'};
    static char[] right = {')','}',']','>'};
    public int olution(String inputString) {
        int answer = 0;
        int len = inputString.length();
        int[] left_cnt = new int[4];
        for(int i = 0;i < len;i++){
            int flag = -1; // 0이면 왼쪽, 1이면 오른쪽, 2이면 짝이 안맞는 괄호(탈출)
            for(int j = 0;j<4; j++){ // left 괄호인지 검사
                if(inputString.charAt(i) == left[j]) {
                    left_cnt[j]++;
                    flag = 0;
                    break;
                }
            }
            if(flag == 0)continue;
            for(int j = 0; j<4;j++){
                if(inputString.charAt(i) == right[j]) {
                    if(left_cnt[j]-- == 0) {
                        answer = -1;
                        flag = 2;
                        break;
                    } else{
                        answer++;
                    }
                }
            }
            if(flag==2)break;

        }
        for(int i = 0; i<4;i++){
            if(left_cnt[i] !=0){
                answer = -1;
                break;
            }
        }
        return answer;
    }
}