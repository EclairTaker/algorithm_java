
package com.brute_force_001;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> MaxScore = new ArrayList<Integer>();

        // 답안을 하나하나 만들고 비교하는 것이 옳은가?
        // 어차피 답안 생성은 규칙적이다
        int[][] test_case = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        // 1번 수포자 : 5번마다 반복
        // 2번 수포자 : 8번마다 반복
        // 3번 수포자 : 10번마다 반복
        int[] score = {0, 0, 0};

        // 각 답안지 규칙대로 채점 수행, score에 대입
        for (int i=0; i < answers.length; i++)  {
            for (int j = 0; j < score.length; j++)  {
                int len = test_case[j].length;
                if (test_case[j][i%len] == answers[i])    {
                    score[j]++;
                }
            }
        }

        int [] sortScore = score.clone();
        Arrays.sort(sortScore);

        // 최대점수
        int max_score = sortScore[2];

        for (int i = 0; i < score.length; i++)  {
            if (score[i] == max_score)    {
                MaxScore.add(i+1);
            }
        }

        // ArrayList의 Size를 활용하여 배열 선언
        int[] answer = new int[MaxScore.size()];
        for (int i=0; i < answer.length; i++)   {
            answer[i] = MaxScore.get(i);
        }

        return answer;
    } 
}