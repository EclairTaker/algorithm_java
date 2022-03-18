# Heap
</br>

![ex_screenshot](./img_md/heap_001.jpg)
</br>
## 1. 힙의 기본적 정의
   - 힙은 앞서 조명했던 스택과 큐와 같은 자료구조와는 다르게 특히 그 목적성이 뚜렷하다.
   - 힙이 가지는 가장 특징정인 요소는 자료구조임에도 철저하게 정렬에 신경쓰는 구조가 아니다. 힙의 주안점은 "반정렬 상태"로 입력되는 값들 중 최대값 or 최소값을 찾는 것에 중점을 두고있다.
   - 힙의 세부 종류에는 최대 힙 & 최소 힙이 존재한다
     - 최대 힙 (Max Heap) : 부모 노드 > 자식 노드가 되도록 배치하여 최대값을 빠르게 구함
     - 최소 힙 (Min Heap) : 부모 노드 < 자식 노드가 되도록 배치하여 최소값을 빠르게 구함
   - 힙은 크게 2가지 과정으로 분리할 수 있다
1. 배열을 기반으로 하는 힙에 자료를 입력
2. 입력한 값 간에 부모 & 자식 노드 비교 후 그 결과에 따라 위치 교환 수행 ==> 이를 Swap이라고 한다.
<br><br>
## In Java
- Java에서는 PriorityQueue라는 이름으로 우선순위 큐 라이브러리로 제공하고 있다.
  

</br></br></br></br></br></br>
#### 참조
- https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90