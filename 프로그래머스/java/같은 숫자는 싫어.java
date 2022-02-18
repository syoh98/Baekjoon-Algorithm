import java.util.*;

public class Solution {
    public ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) { // 배열의 끝이라면
				list.add(arr[i]);
				break;
			}
			if (arr[i] != arr[i + 1]) { // 연속된 숫자가 아니라면
				list.add(arr[i]);
			}
		}

        return list;
    }
}
