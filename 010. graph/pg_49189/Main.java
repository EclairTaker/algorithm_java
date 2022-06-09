import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++)    {
            graph.add(i, new ArrayList<>());
        }

        // Graph가 양방향 그래프이다.
        for (int i = 0; i < edge.length; i++)   {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        answer = bfs();
        return answer;
    }

    public static int bfs()  {
        Queue<Integer> queue = new LinkedList<>();
        // 시작지점
        queue.add(1);
        visited[1] = true;

        int cnt = 0;
        while (true)    {
            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty())    {
                int cur = queue.poll();
                for (int adj : graph.get(cur))  {
                    if (!visited[adj])  {
                        temp.add(adj);
                        visited[adj] = true;
                    }
                }
            }
            if (temp.isEmpty()) {
                break;
            }
            queue.addAll(temp);
            cnt = temp.size();
        }
        return cnt;
    }
}

// I'm fkin tire

// 참조 : https://born2bedeveloper.tistory.com/43
// 참조 : https://arinnh.tistory.com/40
// 참조 : https://velog.io/@hammii/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B0%80%EC%9E%A5-%EB%A8%BC-%EB%85%B8%EB%93%9C-java