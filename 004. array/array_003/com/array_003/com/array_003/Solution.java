package com.array_003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // ArrayList 선언
        ArrayList<Integer> idx = new ArrayList<Integer>();
        int cnt = 0;

        // ArrayList로 컨버팅
        for (Integer cit : citations)   {
            // 중복값을 제거해서 인용 횟수만 직관적으로 파악
            if(!idx.contains(cit))
                idx.add(cit);
        }

        // Collections를 통한 내림차순 수행
        Collections.sort(idx, Comparator.reverseOrder());
        System.out.println(idx);

        for (Integer high_rank : idx)   {
            for (Integer idx_list : citations)  {
                if (idx_list >= high_rank)  {
                    cnt ++;
                }
            }

            if (cnt >= high_rank)
                answer = high_rank;
            else
                cnt = 0;
        }

        return answer;
    }
}