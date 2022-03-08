package com.array_001;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        // 문제 과정을 분리
        // 과정 1. 입력받은 배열 자르기 수행
        // 과정 2. 자른 배열 정렬 수행
        // 과정 3. 자른 배열에서 정답 추출
        int i;
        int j;
        // answer에 추가하기 위한 변수
        int q = 0;
        // start : 시작 순번
        // end : 종료 순번
        // key : answer 추출 순번
        int start, end, key;
        int[] temp;
        answer = new int[commands.length];

        // 과정 1. 입력받은 배열 자르기 수행
        // 입력받은 Case별로 분리 수행
        for (i=0; i < commands.length; i++)    {
            // 사실상 commands[i].length == 3
            // start, end, key 추출
            start = commands[i][0];
            end = commands[i][1];
            key = commands[i][2];
            int k = 0;
            temp = new int[end-(start-1)];
            // 본격적인 배열 자르기
            for (j=start-1; j < end; j++) {
                temp[k] = array[j];
                k++;
            }
            // 과정 2. 자른 배열 정렬 수행
            Arrays.sort(temp);
            // 과정 3. 자른 배열에서 정답 추출 후 입력
            answer[q] = temp[key-1];
            q++;
        }
        return answer;
    }
}
