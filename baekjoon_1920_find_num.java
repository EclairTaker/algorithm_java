import java.util.Scanner;
import java.util.Arrays;
 
public class Main{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력 1. 확인용 숫자 Arr length 변수
		int iFlag_cnt = sc.nextInt();
        // 입력 2. 확인용 기준이 될 flag_numbers Arr, 숫자를 직접 입력 받는다.
        int[] iFlag_nums = new int[iFlag_cnt];
 
        for (int i = 0; i < iFlag_cnt; i++) {
            iFlag_nums[i] = sc.nextInt();
        }
 
        // 입력 3. 대조용 숫자 (답안 갯수)
        int iAnswer_cnt = sc.nextInt();
        // 입력 4. 확인용 답안지
        int[] iAnswer_nums = new int[iAnswer_cnt];
        // 이분 탐색 결과 해당 값 유무 check용 변수
        int bAnswerCheck = 0;
        int[] iAnswer_sheet = new int[iAnswer_cnt];
 
        for (int i = 0; i < iAnswer_cnt; i++) {
            iAnswer_nums[i] = sc.nextInt();
        }
 
        // 입력받은 확인 배열 sort 정렬 수행
        // 이진탐색을 위해서는 flag array는 정렬된 상태여야 한다.
        Arrays.sort(iFlag_nums);
        StringBuilder sb = new StringBuilder();
 
        // 답안지의 원소들 하나씩 체크하는 반복문
        for (Integer iNum_Check : iAnswer_nums)   {
            bAnswerCheck = binary_calc(iNum_Check, iFlag_nums);
            if (bAnswerCheck >= 0)	{
            	sb.append(1).append('\n');
            }
            else	{
            	sb.append(0).append('\n');
            }
        }    
        System.out.println(sb);
	}
 
    // iMid_flag : 이진탐색을 위한 중간 기준점 역할
    public static int binary_calc(int iNum_Check, int[] iFlag_nums) {
        // 이진탐색을 위한 idx 정의. 각각 처음과 끝의 index 값이다
    	int iFirst_idx = 0;
        int iLast_idx = iFlag_nums.length - 1;
        
        // 시작 idx값이 종료 idx값을 추월하기 전까지는 게속 반복
        while(iFirst_idx > iLast_idx)   {
            // 이진 탐색용 flag는 중간값. 따라서, 중간 idx 값을 구해준다.
            int iMid_flag = (iFirst_idx + iLast_idx)/2;
            
            // 이진 탐색 수행 결과 Flag 값보다 클 경우 = 탐색 범위를 앞으로 좁혀야 함
            if (iNum_Check > iFlag_nums[iMid_flag]) {
                iLast_idx = iMid_flag - 1;    
            }
            // 이진 탐색 수행 결과 Flag 값보다 작을 경우 = 탐색 범위를 뒤로 좁혀야 함
            else if (iNum_Check < iFlag_nums[iMid_flag]) {
                iFirst_idx = iMid_flag + 1;
            }
            // 정확히 일치한다는 뜻
            else    {
                return iMid_flag;
            }
        }
        // 찾고자 하는 값이 존재하지 않을 경우
        return -1;
    }
}
 
