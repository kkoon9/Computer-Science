import java.util.*;

class Solution {
    static class Road {
        int count;
        boolean isNormal;

        Road(int count, boolean isNormal) {
            this.count = count; // 개수
            this.isNormal = isNormal;
        }
    }

    public int solution(String road, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(road);
        int answer = -1;
        int road_length = road.length();
        ArrayList<Road> arr = new ArrayList<>();
        int normal_count = 0;
        int abnormal_count = 0;
        int count = 1;
        boolean isNormal;
        if(road.charAt(0) == '0'){
            abnormal_count++;
            isNormal = false;
        } else {
            normal_count++;
            isNormal = true;
        }
        for(int i = 1 ; i<road_length;i++) {
            int road_condition = road.charAt(i) - '0';
            if(road_condition == 1) {
                normal_count++;
                if (!isNormal) {
                    arr.add(new Road(count, false));
                    isNormal = true;
                    count = 0;
                }
            } else {
                abnormal_count++;
                if (isNormal) {
                    arr.add(new Road(count, true));
                    isNormal = false;
                    count=0;
                }
            }
            count++;
            isNormal = road_condition==1?true:false;
        }
        arr.add(new Road(count, isNormal));
        if(abnormal_count <= n){ // 보수할 수 있는 수가 더 많으면 도로의 길이 리턴
            return road_length;
        }
        int arr_size = arr.size();
        for(int i = 0; i<arr_size;i++){
            int length = 0;
            int repair = n;
            int index = i;
            boolean nextPlus = true;
            while(repair > 0 && index < arr_size){
                if(!arr.get(index).isNormal) {
                    repair -= arr.get(index).count;
                    if (repair < 0) {
                        length += repair;
                        nextPlus = false;
                    }
                }
                length+= arr.get(index).count;
                index++;
            }
            if(index <arr_size && nextPlus){
                length += arr.get(index).count;
            }
            if(answer < length){
                answer = length;
            }

        }
        return answer;
    }

}