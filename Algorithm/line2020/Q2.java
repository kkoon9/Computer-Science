import java.io.*;
import java.util.*;

class Solution {
    static class Student implements Comparable<Student> {
        int wrong = 0;
        int long_wrong = 0;
        Student(int wrong, int long_wrong){
            this.wrong = wrong;
            this.long_wrong = long_wrong;
        }
        @Override
        public int compareTo(Student o) {
            int o_score = (o.long_wrong)*(o.long_wrong) + o.wrong;
            int this_score = (this.long_wrong)*(this.long_wrong) + this.wrong;
            int result = o_score - this_score;
            return result;
        }
    }
    static int cheating = 0;
    static StringBuilder sb_answer = new StringBuilder();
    static Student [] student_cheating;
    static int question_count;
    static int student_count;
    public int solution(String answer_sheet, String[] sheets) {
        question_count = answer_sheet.length();
        sb_answer = new StringBuilder();
        sb_answer.append(answer_sheet);
        student_count = sheets.length;
        student_cheating = new Student[student_count];
        for(int i = 0 ;i<student_count;i++){
            student_cheating[i] = new Student(0,0);
        }
        /**
         * 학생별 가장 길게 같이 틀린 개수 파악
         */
        for(int i = 0 ;i<student_count - 1;i++){
            for(int j = i + 1;j<student_count;j++){
                int wrong = 0;
                int long_wrong=0;
                int buffer = 0;
                for(int k = 0; k<question_count;k++){
                    char answer = sb_answer.charAt(k);
                    char student_i = sheets[i].charAt(k);
                    char student_j = sheets[j].charAt(k);
                    if(isBothWrong(answer,student_i,student_j)){
                        if(student_i == student_j) {
                            wrong++;
                            buffer++;
                        }
                    }
                }
                if(long_wrong < buffer){
                    long_wrong= buffer;
                    buffer=0;
                }
                if(student_cheating[i].wrong < wrong){
                    student_cheating[i].wrong = wrong;
                }
                if(student_cheating[i].long_wrong < long_wrong){
                    student_cheating[i].long_wrong = long_wrong;
                }
                if(student_cheating[j].wrong < wrong){
                    student_cheating[j].wrong = wrong;
                }
                if(student_cheating[j].long_wrong < long_wrong){
                    student_cheating[j].long_wrong = long_wrong;
                }
            }
        }
        Arrays.sort(student_cheating);
        cheating = student_cheating[0].wrong + (student_cheating[0].long_wrong * student_cheating[0].long_wrong);
        return cheating;
    }

    private boolean isBothWrong(char answer, char student_i, char student_j) {
        return (student_i != answer) && (student_j != answer);
    }
}
class Main {

    public static void main(String[] args) throws Exception {
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());*/
        /**
         * [1]. Init
         */
        Solution s = new Solution();
        String[][] ss = {{"doc1", "t1", "t2", "t3"}, {"doc2", "t0", "t2", "t3"}, {"doc3", "t1", "t6", "t7"}, {"doc4", "t1", "t2", "t4"}, {"doc5", "t6", "t100", "t8"}};
        String[] tr = {"1234512345", "1234512345", "1234551234", "1234551234"};
        String str = "1234512345";
        System.out.println(s.solution(str, tr));
    }
}