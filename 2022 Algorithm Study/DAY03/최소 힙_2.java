package P1927;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 연산의 개수
		MinHeap mh = new MinHeap();
		
		for(int i=0; i<N; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				System.out.println(mh.delete());
			}
			else {
				mh.insert(input);
			}
		}

	}
}

class MinHeap {
	List<Integer> list;

	public MinHeap() {
		list = new ArrayList<>();
		list.add(0);
	}

	public void insert(int val) {
		// 1. leaf 마지막에 삽입
		list.add(val);

		int current = list.size() - 1;
		int parent = current / 2;

		// 2. 부모와 비교 후 조건에 맞지 않으면 swap
		// 3. 조건이 반복되거나 root까지 반복
		while (true) {
			if (parent == 0 || list.get(parent) <= list.get(current)) {
				break;
			}

			// swap하는 과정
			int temp = list.get(parent);
			list.set(parent, list.get(current));
			list.set(current, temp);

			current = parent;
			parent = current / 2;
		}
	}

	public int delete() {
		if (list.size() == 1) {
			return 0;
		}
		int top = list.get(1);

		// 1. Root에 leaf 마지막 데이터 가져옴
		list.set(1, list.get(list.size() - 1));
		list.remove(list.size() - 1);

		// 2. 자식과 비교 후 조건이 맞지 않으면 swap
		// 3. 조건이 만족되거나 leaf까지 반복(탈출 -> 1)leaf에 도착했거나 2)조건이 만족됐거나)
		int currentPos = 1; // position, value 구분하기

		while (true) {
			int leftPos = currentPos * 2;
			int rightPos = currentPos * 2 + 1;

			// 자식 존재 유뮤 확인
			if (leftPos >= list.size()) { // 왼쪽 자식이 존재하지않으면 오른쪽 자식도 존재 안함
				break;
			}

			// 왼쪽 자식 먼저 확인
			int minValue = list.get(leftPos);
			int minPos = leftPos;

			// 오른쪽 자식 확인
			if (rightPos < list.size() && list.get(rightPos) < minValue) {
				minValue = list.get(rightPos);
				minPos = rightPos;
			}

			// swap
			if (list.get(currentPos) > minValue) {
				int temp = list.get(currentPos);
				list.set(currentPos, minValue);
				list.set(minPos, temp);
				currentPos = minPos;
			}
			else { // 조건을 만족한다 -> 더 내려갈 필요가 없다
				break;
			}
		}
		return top;
	}
}
