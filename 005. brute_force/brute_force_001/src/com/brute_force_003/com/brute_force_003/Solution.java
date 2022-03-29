package com.brute_force_003;

import java.util.*;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int area = brown + yellow; //전체 갯수

        //행과 열의 갯수는 3이상이여야 합니다.
        for (int i=3; i <= area; i++) {
            int col = i;             // 열
            int row = area / col;    // 행

            //행의 갯수가 3이하이면 Pass합니다.
            if(row<3){
                continue;
            }

            //행은 열보다 크거나 같아야 합니다.
            if(row>=col) {
                //문제의 규칙에 의하면 row-2*col-2 = yellow 입니다.
                if((row-2) * (col-2) == yellow) {
                    answer[0] = row;
                    answer[1] = col;
                    return answer;
                }
            }
        }
        return answer;
    }
}

// 참조 : https://hidelookit.tistory.com/67