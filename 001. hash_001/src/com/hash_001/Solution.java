package com.hash_001;// HashMap 사용을 위한 java.util.HashMap 패키지.클래스 import
import java.util.HashMap;

public class Solution {
    public String solution(String[] participant, String[] completion)  {
        String answer = "";

        // HashMap 새 객체 생성
        HashMap<String, Integer> map001 = new HashMap<>();

        // 1번 과정, 참가자를 전부 HashMap에 등록 수행
        // 동명이인의 경우 처리를 위해 getOrDefault를 통해 동일한 key값이 put 될 경우 value값을 증가
        for(String name : participant)  {
            map001.put(name, map001.getOrDefault(name, 0) + 1);
        }

        // 2번 과정, 완주자를 HashMap에서 찾아서 제거 수행
        // 완주 수행을 처리하기 위해 해당 key값이 확인될 경우 value를 차감
        // 차감시킨 value값을 덮어씌기하는 방식으로 갱신화
        for(String name : completion)   {
            map001.put(name, map001.get(name)-1);
        }

        // keySet()으로 HashMap의 key값들만 전부 추출, 반복문 처리
        // key값 순회 중 value가 0이 아닌 key가 확인될 경우, 해당 key가 낙오자
        for(String name : map001.keySet())  {
            if(map001.get(name) != 0)   {
                answer = name;
                break;
            }
        }
        return answer;
    }
}
