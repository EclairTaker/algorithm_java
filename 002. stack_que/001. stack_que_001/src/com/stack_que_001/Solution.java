package com.stack_que_001;

import java.util.Stack; // stack 패키지 import
import java.util.ArrayList;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // answer 배열 선언
        int answer[];
        ArrayList<Integer> answer_list = new ArrayList<>();
        ArrayList<Integer> final_answer = new ArrayList<>();
        // answer에 집어넣기 위한 배열 순번 cnt용 변수
        int answer_cnt = 0;
        // 배포 된 project 갯수 cnt용
        int temp = 0;
        // speed의 배수용 변수
        int time_cnt = 0;

        Stack<Integer> progress = new Stack<>();    // int형 progress용 스택 선언
        Stack<Integer> pj_speed = new Stack<>();    // int형 project 진행 속도용 스택 선언

        // 과정 1. progresses & speeds를 알맞게 Stack에 재분배
        // Stack에 걸맞게 입력받은 progress와 speeds를 Stack에 쌓아올림
        for (int i = (progresses.length - 1); i >= 0; i--)  {
            // progress의 초기 작업 진도를 Stack에 입력
            progress.push(progresses[i]);
            // speeds의 작업 속도를 Stack에 입력
            pj_speed.push(speeds[i]);
        }

        // 과정 2. Stack들을 활용해 문제 해결
        // 만약 Stack이 비었다면 while문 종료
        while(progress.empty()==false)  {
            // temp 반복문 동작 전 초기화
            // progress별 진행 속도가 각기 다르기 때문에 반복된 횟수 cnt를 speed와 연산하여 진행 여부를 check
            // stack.peek()를 사용해서 check 수행
            // 프로젝트 진행 기록 + 진행속도 * 반복횟수 >= 100 일 경우 == 프로젝트 완료, 배포해야함
            if (progress.peek() + (pj_speed.peek() * time_cnt) >= 100) {
                //System.out.println("progress 초기 진행도 : " + progress.peek());
                //System.out.println("프로젝트 진행속도 : " + pj_speed.peek());
                //System.out.println("최종 진행도 : " + (progress.peek() + (pj_speed.peek() * time_cnt)));
                // 완료 된 프로젝트 pop해서 제거 수행
                progress.pop();
                // 완료 된 프로젝트 진행속도 pop해서 제거 수행
                pj_speed.pop();
                temp++;
                answer_list.add(temp);
            }
            else {
                temp = 0;
                time_cnt++;
            }
        }
        //System.out.println(answer_list);

        // temp 값을 본격적으로 활용하는 부분
        // answer_list에 추가된 temp값의 변동횟수만큼 확인하여 최종적으 동시에 배포되었던 프로젝트 갯수만 선별
        for (int number=0; number <= answer_list.size(); number++) {
            // 마지막 idx에서는 그냥 그 프로젝트 갯수가 최종 배포본 갯수이기 때문에 그대로 final_answer에 추가
            if (number == answer_list.size()) {
                final_answer.add(answer_cnt);
            }
            // 일반적인 idx 진행 중 배포 프로젝트 갯수를 기록한 answer_cnt가 새로 받은 프로젝트 변동 갯수보다 작을 경우
            // 해당 수치로 배포 프로잭트 갯수(answer_cnt)를 갱신한다
            else if (answer_cnt < answer_list.get(number)) {
                //System.out.println(answer_list.get(number));
                answer_cnt = answer_list.get(number);
            }
            // 배포 프로잭트 갯수가 새로 받은 변동 갯수보다 클 경우, 이게 그 타이밍에 동시에 배포 된 프로젝트 갯수로 취급
            // 그 값을 final_answer에 추가 후 answer_cnt는 새로 answer_list에서 받게된다.
            else {
                final_answer.add(answer_cnt);
                answer_cnt = answer_list.get(number);
            }
        }

        answer = new int[final_answer.size()];
        for (int num=0; num < final_answer.size(); num++) {
            answer[num] = final_answer.get(num);
        }

        //System.out.println(final_answer);
        return answer;
    }
}
