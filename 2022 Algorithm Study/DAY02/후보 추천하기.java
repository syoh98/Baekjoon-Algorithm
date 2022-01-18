package P1713;

import java.io.*;
import java.util.*;

class Student implements Comparable<Student> {
	int num; // 학생번호
	int count; // 득표수(몇 번 호출됐는지)
	int timestamp; // 이 학생이 언제 들어왔는지
	boolean isIn;

	public Student(int num, int count, int timestamp, boolean isIn) {
		super();
		this.num = num;
		this.count = count;
		this.timestamp = timestamp;
		this.isIn = isIn;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", count=" + count + ", timestamp=" + timestamp + "]";
	}

	@Override
	public int compareTo(Student o) {
		int comp1 = Integer.compare(count, o.count);
		if (comp1 == 0) {
			return Integer.compare(timestamp, o.timestamp);
		} else {
			return comp1;
		}
	}
}

public class Main {
	static int N, K;
	static Student[] students;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 사진틀의 개수
		K = Integer.parseInt(br.readLine()); // 총 추천횟수

		students = new Student[101]; // 학생을 나타내는 번호는 1부터 100까지

		List<Student> list = new ArrayList<Student>(); // 추천을 입력받는 리스트

		String temp = br.readLine(); // 추천받은 학생
		StringTokenizer st = new StringTokenizer(temp);

		for (int k = 0; k < K; k++) {
			int num = Integer.parseInt(st.nextToken()); // 2 1 4 3 5 6 2 7 2

			if (students[num] == null) {
				students[num] = new Student(num, 0, 0, false);
			}
			// 사진판에 있는 경우 -> count++;
			if (students[num].isIn == true) {
				students[num].count++;
			} else { // 사진판에 없는 경우 -> (자리가 없는 경우 하나 골라서, 제거 후) 새 후보 추가
				if (list.size() == N) {
					Collections.sort(list);
					Student s = list.remove(0);
					s.isIn = false; // 뺐음
				}
				students[num].count = 1; // 1표 득표
				students[num].isIn = true;
				students[num].timestamp = k;
				// 이 정보를 리스트에 그대로 올림
				list.add(students[num]);
			}
		}

		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return Integer.compare(o1.num, o2.num);
			}
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).num + " ");
		}
	}
}
