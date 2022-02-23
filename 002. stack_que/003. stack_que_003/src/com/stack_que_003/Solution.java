package com.stack_que_003;

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights)   {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int total_weight = 0;
        int time = 0;

        for (int i=0; i < truck_weights.length; i++)    {
            int truck = truck_weights[i];

            while(true) {
                // 다리가 완전히 비었을 때 트럭이 진입할 경우
                if(bridge.isEmpty())    {
                    bridge.add(truck);
                    total_weight += truck;
                    // 다리에 올라갈 때 걸리는 시간
                    time++;
                    break;
                }
                // 다리가 트럭으로 꽉 찬 경우
                else if (bridge.size() == bridge_length)    {
                    total_weight = total_weight - bridge.poll();
                }
                // 다리에 빈 공간이 있을 경우
                else    {
                    // 하중이 되는 한도 내로 새로운 트럭을 다리 통과
                    if (total_weight + truck <= weight) {
                        bridge.add(truck);
                        total_weight += truck;
                        time++;
                        break;
                    }
                    // 하중이 오버 될 경우 0을 추가해서 기존에 있던 트럭들이 무사히 넘어가게 함
                    else    {
                        bridge.add(0);
                        time++;
                    }
                }
            }

        }
        // 마지막 트럭은 완주해야하기 때문에
        answer = time + bridge_length;
        return answer;
    }
}

// 참조 : https://minhamina.tistory.com/241