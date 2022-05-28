import java.util.Scanner;
import java.util.Arrays;

public class Main {
    // fInstallCheck에서 사용하기 위해 public static으로 집 좌표 선언
    public static int[] iHome_cord;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        // 집의 갯수 N
        int iHome_num = sc.nextInt();
        // 공유기 갯수 C
        int iRouter_num = sc.nextInt();
        // 입력받은 집의 갯수 만큼 배열 처리 수행
        iHome_cord = new int[iHome_num];
        
        // 반복문으로 집 좌표 배열에 입력
        for (int i=0; i < iHome_num; i++)   {
            iHome_cord[i] = sc.nextInt();
        }
        
        // 이진탐색을 행하기 전에 일단 sort로 정렬부터 처리해야함
        Arrays.sort(iHome_cord);

        // 목표 : 가장 인접한 두 공유기 사이의 최대 거리를 구하라
        // 공유기 사이의 거리로 사용할 수 있는 최소, 최대 거리를 구해야한다
        // 최소거리는 1, 최대거리는 끝 집과 첫 집 사이의 거리가 된다.
        int iMinDist = 1;
        int iMaxDist = (iHome_cord[iHome_num-1] - iHome_cord[0]) + 1;

        // UpperBound 형식으로 Max 거리를 줄여나가며 이진탐색을 점진적으로 수행
        while(iMinDist < iMaxDist)  {
            int iMidDist = (iMinDist + iMaxDist) / 2;
            // 해당 공유기가 설치가 가능한지 확인해야함
            /*
            Mid Distance 거리에 대해 설치 가능한 공유기 개수를 mInstallCheck로 확인
            해당 개수가 설치해야하는 iRouter_num 개수에 미달 = 거리를 좁혀서 설치해야한다.
            이에 따라 iMidDist 감소 (*이진탐색)
            */
            if(mInstallCheck(iMidDist) < iRouter_num)   {
                iMaxDist = iMidDist;
            }
            /*
            반대로 iRouter_num 개수보다 초과 = 거리를 더 증가시켜도 무방
            거리를 증가시키면서 적절값을 찾는 최대 거리를 찾아낸다.
            이에 따라 iMidDist 증가 (*이진탐색)
            */
            else    {
                iMinDist = iMidDist + 1;
            }
        }
        /*
        while문 탈출 시 = iMinDist가 iMaxDist를 초과
        이 때, 탐색 값을 초과하는 최초의 값이 정답
        MinDist에서 1로 시작했기 때문에 해당 분 만큼 계산 수행
        */
        System.out.println(iMinDist - 1);
    }

    // 입력받은 거리에 대하여 설치가 가능한 공유기의 갯수가 몇개인가를 확인하는 method
    public static int mInstallCheck(int iDistance)   {
        //시작 지접인 첫 번째 집에는 무조건 설치한다고 가정
        int iCnt = 1;
        int iLastInstall = iHome_cord[0];

        for (int i = 1; i < iHome_cord.length; i++) {
            int iLocation = iHome_cord[i];

            /*
            현재 탐색 집 위치와 직전에 설치했던 집의 위치간 거리를 비교
            해당 거리가 최소 거리(iDistance)보다 크거나 같을 때 공유기 설치 진행
            설치 개수 증가시키고 마지막 설치 위치 갱신
            */

            // iLocation - iLastInstall : 현재 설치하려는 위치와 직전 설치 위치 간 거리
            if (iLocation - iLastInstall >= iDistance)  {
                iCnt++;
                iLastInstall = iLocation;
            }
        }
        return iCnt;
    }
}