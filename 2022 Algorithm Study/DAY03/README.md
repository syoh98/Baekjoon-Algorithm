Indexed Tree</br>
=============

## 📋1. TOP-DOWN : Init(left, right, node)
![캡처1](https://user-images.githubusercontent.com/76934280/150173387-9700b7be-911c-403b-8257-e70cd79dd79f.PNG)

1. Root부터 시작 init(1, 8, 1)

2. 내부노드 일 경우 (left != right)
    - 왼쪽자식 init(left, mid, node * 2) 를 호출
    - 오른쪽자식 init(mid + 1, right, node * 2 + 1) 를 호출
    - 노드의 값을 리턴
3. 리프노트 일 경우(left == right)
    - 노드에 배열의 값 저장
    - 노드의 값을 리턴


## 📋2. TOP-DOWN : Query(left, right, node, queryLeft, queryRight)
![캡처2](https://user-images.githubusercontent.com/76934280/150173548-99d5ae89-00db-450d-a216-a23afe11ff7e.PNG)
1. Root부터 시작 query(1, 8, 1, 3, 7)
2. 노드가 Query 범위 밖 - 연관없음
    - 무시
3. 노드가 Query 범위 안에 들어옴 - 판단가능
    - 현재 노드 값 리턴
4. 노드가 Query 범위에 걸쳐있음 - 판단불가
    - 왼쪽 query(I, mid, node * 2, 3, 7)을 호출
    - 오른쪽 query(mid + 1, r, node * 2 + 1, 3, 7)을 호출
    - 왼쪽 query + 오른쪽 query 값을 합쳐서 리턴


## 📋3. QUERY
![캡처3](https://user-images.githubusercontent.com/76934280/150176191-447bdf90-e7dc-4110-83aa-b23cbb48d0c6.PNG)


## 📋4. TOP-DOWN : Update(left, right, node, target, diff)
![캡처4](https://user-images.githubusercontent.com/76934280/150178625-58c8cce0-75b2-4fd3-8dab-115a7ed613a9.PNG)
1. Root부터 시작 update(1, 8, 1, 3, -2)
2. 노드가 Target 미포함 - 연관 없음
3. 모드가 Target 포함
    - 현재 노드에 diff 반영
    - 자식이 있을 경우 왼쪽 update(I, mod, node * 2, 3, -2)
    - 오른쪽 update(mid + 1, r, node * 2 + 1, 3, -2)


## 📋5. BOTTOM-UP(Init)
![캡처5](https://user-images.githubusercontent.com/76934280/150179884-8b6fca02-0c02-456d-907c-e14db65fc3d5.PNG)
1. 리프노트 순회(index = [S] ~ [S + N -1]) -> 그림 상으로 1번 과정이 [S], 8번 과정이 [S + N -1]에 해당
    - 노드에 배열의 값 저장
2. 내부노드 순회(index = [S - 1] ~ [1]) -> 그림 상으로 9번 과정이 [S - 1]에 해당
    - 왼쪽 자식 index * 2
    - 오른쪽 자식 index * 2  + 1
    - 왼쪽 자식 + 오른쪽 자식 값을 합쳐서 노드에 저장


## 📋6. BOTTOM-UP Query(queryLeft, queryRight)
![캡처6](https://user-images.githubusercontent.com/76934280/150182313-41e5e7cb-dc9f-499b-9180-984abf64247d.PNG)
1. 리프 노드부터 시작 query[3, 7]
    - nodeLeft = S + queryLeft - 1
    - nodeRight = S + queryRight - 1
2. while(nodeLeft <= nodeRight)
3. leftNode 분기 조건
    - 짝수: 부모값 사용 가능 -> leftNode = leftNode / 2   -> 그림 상으로 1번 과정에 해당
    - 홀수: 현재 노드 값 추가 -> leftNode = (leftNode + 1) / 2   -> 그림 상으로 3번 과정에 해당
4. rightNode 분기 조건
    - 짝수: 현재 노드 값 추가 -> rightNode = (rightNode - 1) / 2   -> 그림 상으로 2번 과정에 해당 
    - 홀수: 부모 값 사용 가능 -> rightNode = rightNode / 2   -> 마찬가지로, 그림 상으로 2번 과정에 해당


## 📋7. BOTTOM-UP Update(target, value)
![7](https://user-images.githubusercontent.com/76934280/150184431-71f2c69f-d699-4164-804b-74ed213215a1.PNG)
1. 리프부터 시작 Update(3, 2)
2. node = S + target - 1
3. 노드를 ㅎ해당 값으로 갱신 -> 그림 상으로 1번 과정에 해당
4. 부모로 이동 node /= 2
5. while(node >= 1) -> 그림 상으로 2번 ~ 4번 과정에 해당
    - 좌측(node * 2)와 우측(node * 2 + 1) 합을 노드에 저장
    - 부모로 이동 node /= 2
