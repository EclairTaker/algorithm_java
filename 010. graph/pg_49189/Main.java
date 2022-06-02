import java.util.*;

public class Main {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 그래프 구현을 위해 ArrayList를 활용
        ArrayList<ArrayList<Integer>> alGraph = new ArrayList<>();

        for (int i = 0; i < n+1; i++)   {
            alGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++)   {
            // graph가 양방향
            // 특정 경로 발견 시 해당 경로를 양방향으로 graph에 업데이트
            alGraph.get(edge[i][0]).add(edge[i][1]);
            alGraph.get(edge[i][1]).add(edge[i][1]);
        }
        for (int i = 1; i <= n; i++)    {
            Collections.sort(alGraph.get(i));
        }

        //System.out.println(alGraph);
        // 방문기록을 True, False로 기록
        boolean[] bVisited = new boolean[n + 1];
        // 1번 노드에서 가장 먼 거리를 체크해야하기 때문에 무조건 통과
        bVisited[1] = true;
        // BFS를 선언 후, 그 첫 노드로 1을 통과할 것이기 때문에
        // 노드 1에 대한 정보들 초기화
        Queue<Integer> BFS = new LinkedList<>();
        BFS.offer(1);
        bVisited[1]=true;

        int iGraph_size, iCurNode;

        // 1을 통과한 후 2~n까지의 경로 도출
        // BFS의 내용물이 바닥나기 전까지 반복 수행
        while (!BFS.isEmpty()) {
            iGraph_size = BFS.size();
            for (int i = 0; i < iGraph_size; i++)   {
                // 현재 조회하는 노드를 BFS에서 poll로 정보 확인
                iCurNode = BFS.poll();
                // iCurNode를 idx값으로 가지는 객체의 size까지 반복
                // 객체 size = 해당 경로가 연결된 루트들
                for (int j = 0; j < alGraph.get(iCurNode).size(); j++)  {
                    // 루트에 따라 이동 중 방문한 노드의 방문 기록이 false라면 true로 변경
                    // 이후, 해당 노드를 BFS에 기록
                    if(bVisited[alGraph.get(iCurNode).get(j)] == false)    {
                        bVisited[alGraph.get(iCurNode).get(j)] = true;
                        BFS.offer(alGraph.get(iCurNode).get(j));
                    }
                }
            }
            // 왜?
            answer = iGraph_size + 1;
        }
        return answer;
    }
}

// 참조 : https://born2bedeveloper.tistory.com/43
// 참조 : https://arinnh.tistory.com/40