package com.hash_002;

import java.util.HashMap;

public class Solution {
    public boolean solution(String[] phone_book)    {
        // 기본 answer값 true로 초기화
        boolean answer = true;

        // HashMap 객체 생성 및 선언, phone_num
        HashMap<String, Integer> phone_num = new HashMap<>();
        // 과정 1. phone_book을 반복문 수행하며 HashMap에 입력 수행
        for (String number : phone_book) {
            // key : 번호, value : 번호의 길이
            phone_num.put(number, number.length());
        }

        // 과정 2. 전화번호부 순회하며 접두사 Check
        for (int i = 0; i < phone_book.length; i++) {
            // 각 전화번호의 접두사 부분을 분리하여 확인하기 위한 이중 for문
            for (int j = 0; j < phone_book[i].length(); j++)    {
                // HashMap phone_num의 Key값 중에 전화번호부 순회 중 substring과 일치하는 것이 있는가 확인
                // Key값을 글자별로 분리, 앞에서부터 검사를 시작해서 key값과 정확히 일치하는 substring = 접두사
                if (phone_num.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                }
            }
        }
       return answer;
    }
}
