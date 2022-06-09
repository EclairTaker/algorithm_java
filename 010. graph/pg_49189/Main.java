import java.util.*;

public class Main {
    // 다익스트라 알고리즘 적용하여 새로 풀이 수행
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 입력받는 노드 갯수보다 +1만큼 그래프 최대 길이로 설정해야함
        List<Integer> lGraph[] = new ArrayList[n+1];
        // 방문 여부를 True, False로 구분
        boolean[] bVisited = new boolean[n+1];
        // 그래프 경로에 Cost, Weight가 존재하지 않기 때문에 boolean 2차원 배열로 그래프 설정 가능
        boolean[][] bPath = new boolean[n+1][n+1];

        for (int i = 0; i <= n; i++)    {
            lGraph[i] = new ArrayList<>();
        }

        for (int[] iEdge : edge)    {
            // 경로는 양방향이기 때문에 방문한 지점에서 그곳과 연결된 노드
            // 양쪽을 처리를 해주어야 함.
            bPath[iEdge[0]][iEdge[1]] = true;
            bPath[iEdge[1]][iEdge[0]] = true;
        }

        // 최대거리를 저장하기 위한 Queue 생성
        Queue<Integer> qBuffer = new ArrayDeque<>();
        // 시작지점은 일단 저장 후 Start
        qBuffer.add(1);
        // 시작지점인 1은 True로 Start
        bVisited[1] = true;

        // iQsize가 최고임을 확인해서 현재 최대거리인 node를 정리
        int iQsize;

        while (!qBuffer.isEmpty())  {
            iQsize = qBuffer.size();
            for (int i = 0; i < iQsize; i++)    {
                // 현재 노드 정보를 poll로 받아온다
                int now = qBuffer.poll();
                // 노드 정보를 토대로 bVisited에서 해당 노드 번호 전까지 방문 여부를 check = 방문하지 않았다면
                // 노드 정보를 토대로 bPath에서 해당 노드와 연결된 경로를 확인한다.
                for (int j = 1; j <= n; j++)    {
                    if (!bVisited[j] && bPath[now][j])  {
                        // 해당 노드를 방문한 것으로 하기 위해 bVisited를 True
                        // 해당 노드로 이동한 것이기 때문에 현재 위치로 활용하기 위해 qBuffer에 추가
                        bVisited[j] = true;
                        qBuffer.add(j);
                    }
                }
            }
            // 최종적으로 다익스트라 알고리즘을 토대로
            answer = iQsize;
        }        
        return answer;
    }
}

// I'm fkin tire

// 참조 : https://born2bedeveloper.tistory.com/43
// 참조 : https://arinnh.tistory.com/40