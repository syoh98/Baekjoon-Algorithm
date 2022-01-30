## 📖깊이우선탐색(DFS)
- 한 경로로 탐색 하다 특정 상황에서 최대한 깊숙하게 들어가서 확인 후 다시 돌아가 다른 경로로 탐색하는 방식
- 재귀함수를 이용하여 구현  
- DFS 활용: 백트랙킹, 단절선 찾기, 단절점 찾기, 위상정렬, 사이클 찾기  
  

### [DFS 과정]
1. 체크인
2. 목적지인가?
3. 연결된 곳을 순회  
&nbsp;&nbsp;&nbsp; 4. 갈 수 있는가?  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5. 간다  
7. 체크아웃

## 📖너비우선탐색(BFS)
- 시작 노드에서 시작하여 인접한 노드를 먼저 탐색하는 방식  
- Queue 자료구조를 이용하여 구현
- Queue는 갈 예정인 곳  
 ✏️Q 비어있지 X: 가야할 곳이 남아있다  
 ✏️Q 비어있음: 가야할 곳이 남아있지 않음  
- BFS 활용: 최단경로 찾기, 위상정렬  
  

### [BFS 과정]
1. 큐에서 꺼내옴
2. 목적지인가?
3. 연결된 곳을 순회  
&nbsp;&nbsp;&nbsp; 4. 갈 수 있는가?  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5. 체크인  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6. 큐에 넣음  
7. 체크아웃  

## 📕Compare 함수(Comparator, compareTo)
- 두개의 값을 비교하여 int 값으로 반환
![캡처](https://user-images.githubusercontent.com/76934280/151692217-bf73fddd-71d5-4e51-89e8-48994ca589ea.PNG)
