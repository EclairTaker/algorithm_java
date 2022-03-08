package com.array_002;

import java.util.Arrays;
import java.util.Comparator;
// Comparable의 ComparteTo 메소드는 매개변수가 1개
// Comparator의 compare 메소드는 매개변수가 2개
// Comparable : 자기 자신과 매개변수 객체를 비교
// Comparator : 두 매개변수 객체를 비교

public class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        // 문자열 리턴을 위한 배열 선언
        // 길이는 입력받은 숫자만큼
        String[] temp = new String[numbers.length];
        // int배열 String배열로 변환

        for(int i = 0; i < numbers.length; i++)    {
            // int 배열 numbers의 값을 String으로 변환하여 입력
            temp[i] = String.valueOf(numbers[i]);
        }

        // Comparator 인터페이스 활용
        // public static void sort ( T[] a, Comparator<? super T> c )
        // 인자 값으로 객체를 받으며, 지정된 Comparator가 가리키는 순서에 따라 지정된 객체의 배열을 정렬한다.
        // 람다 식 : Arrays.sort(temp, (str_a, str_b) -> (str_b + str_a).compareTo(str_a + str_b));
        Arrays.sort(temp, new Comparator<String>()  {
            @Override
            public int compare(String str_a, String str_b)  {
                // compareTo, 2개의 문자열을 비교 후 int값 return
                // A.compareTo(B)
                // 문자열에 대한 CompareTo를 수행할 경우
                // 같은 문자열까지는 넘기고 문자열이 다른 위치에서 그 ASCII값의 차이를 반환함
                // 내림차순으로 정렬하기 위하여 B.compareTo(A)로 수행하게 된다.
                // Arrays.sort는 fivot 2개와 3개의 구간으로 퀵정렬 수행
                return (str_b+str_a).compareTo(str_a+str_b);
            }
        });
        // 숫자 조합상 맨 앞이 0이 존재할 수 없다
        // = 맨 앞이 0이라는 뜻인 애초에 답이 0이라는 뜻.
        if (temp[0].equals("0"))
            return "0";

        for (String str : temp) {
            System.out.println(str);
            answer += str;
        }
        return answer;
    }
}

// 참조 : https://st-lab.tistory.com/243
// compareTo 이해용 참조글 : https://mine-it-record.tistory.com/133