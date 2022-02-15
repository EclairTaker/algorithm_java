package com.hash_003;

import java.util.HashMap;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        int temp = 1;

        // 과정 1. 옷 DB를 입력받아 HashMap으로 만든다
        // 옷DB 구조 (의상 이름, 의상 종류
        // HashMap 구조, (Key : 옷 카테고리_str, Value : 해당 카테고리 옷의 갯수_int)
        HashMap<String, Integer> cloth_map = new HashMap<>();

        // 카테고리 별 옷의 가지 수만 확인하면 되기 대문에 이중 배열값만 확인해서 Map에 입력
        for (int i=0; i < clothes.length; i++)
            cloth_map.put(clothes[i][1], cloth_map.getOrDefault(clothes[i][1], 0) + 1);

        // 과정 2. 해당 옷 DB를 토대로 가능한 경우의 수 연산
        for (String categories : cloth_map.keySet())
            // 해당 카테고리를 아예 입지 않는 경우 포함
            temp = temp * (cloth_map.get(categories) + 1);
        // 모든 옷을 입지 않는 경우의 수 1개 감산
        answer = temp - 1;

        return answer;
    }
}
