package com.stack_que_002;

// Java의 Queue는 전부 LinkedList가 기본. 따라서 선언할 때도 LinkedList를 활용해야 한다.
// 두개의 패키지는 항상 같이 사용되게 된다.
// PriorityQueue라는 패키지도 지원함
import java.util.LinkedList;
import java.util.Queue;

// 동시에 2개의 Queue를 제작하게 되면 너무 비효율적
// Info 클래스를 제작하여 한 번에 문서 정보/우선순위를 조회할 수 있게 한다.
public class Solution {
    class info  {
        int location;
        int prior;
        public info(int location, int prior)    {
            this.location = location;
            this.prior = prior;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // Queue로 LinkedList 써서 printer 선언
        Queue<info> printer = new LinkedList<>();

        // info 클래스에 맞게 순번과, 우선순위를 printer queue에 기록
        for (int i=0; i<priorities.length; i++) {
            printer.add(new info(i, priorities[i]));
        }
        
        int temp = 0;
        // Queue가 완전히 비거나, 정답 찾기 전까지 while 반복
        while(!printer.isEmpty())   {
            //  printer Queue에서 0번 문서 확인 (info 클래스)
            info doc_0 = printer.poll();
            boolean key = false;
            // printer Queue에 있는 모든 info 클래스에 대하여 정보 조회
            for (info docs : printer)   {
                // 0번 문서보다 더 높은 우선순위를 확인했을 경우
                if(docs.prior > doc_0.prior)    {
                    key = true;
                }
            }
            
            // 더 높은 우선순위가 존재할 경우
            if (key)    {
                // 기존 0번 문서를 뒤로 미루는 과정으로 add 수행
                printer.add(doc_0);
            }
            // 더 높은 우선순위가 존재하지 않음
            else    {
                // 즉, 일단 0번 문서 출력이 수행되기 때문에 temp++
                temp++;
                // info 클래스 정보 조회에 의거, 0번 문서의 location값과 목표 문서의 location 값 일치
                // 정답 확인
                if(doc_0.location == location)  {
                    answer = temp;
                    break;
                }
            }
        }
        return answer;
    }
}

// 참조 : https://velog.io/@yanghl98/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%94%84%EB%A6%B0%ED%84%B0-JAVA%EC%9E%90%EB%B0%94