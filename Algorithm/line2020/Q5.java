package com.company;

import java.io.*;
import java.util.*;

class Solution {
    static class Document implements Comparable<Document> {
        String doc;
        int tag_count;
        Document(String doc, int tag_count){
            this.doc = doc;
            this.tag_count = tag_count;
        }
        @Override
        public int compareTo(Document o) {
            int result = o.tag_count - this.tag_count;
            if(result == 0){
                result = this.doc.compareTo(o.doc);
            }
            return result;
        }
    }
    public String[] solution(String[][] dataSource, String[] tags) {
        String[] answer;
        HashMap<String, String> hm = new LinkedHashMap<>();
        HashMap<String, Integer> hm_result = new LinkedHashMap<>();
        /**
         * [1]. 태그 별 문서 등록!
         */
        int size = dataSource.length;
        for(int i = 0; i<size;i++){
            int tag_count = dataSource[i].length;
            for(int j=1;j<tag_count;j++){
                hm.put(dataSource[i][j], hm.getOrDefault(dataSource[i][j], "") + dataSource[i][0]+",");
            }
        }
        int tags_size = tags.length;
        for(int i = 0 ;i<tags_size;i++){
            String value = hm.get(tags[i]);
            String [] arr = value.split(",");
            for(String str : arr){
                hm_result.put(str, hm_result.getOrDefault(str, 0) + 1);
            }
        }
        Document[] doc = new Document[hm_result.size()];
        int i = 0;
        for(Map.Entry<String, Integer> elem : hm_result.entrySet()){

            String key = elem.getKey();
            int value = elem.getValue();
            doc[i++] = new Document(key, value);
        }
        Arrays.sort(doc);
        answer = new String[doc.length];
        for(i=0;i<doc.length;i++){
            answer[i] = doc[i].doc;
        }
        return answer;
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
        String[][] ss = {{"doc1", "t1", "t2", "t3"},{"doc2", "t0", "t2", "t3"},{"doc3", "t1", "t6", "t7"},{"doc4", "t1", "t2", "t4"},{"doc5", "t6", "t100", "t8"}};
        String[] tr = {"t1", "t2", "t3"};
        System.out.println(s.solution(ss,tr));
    }
}