import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int[] A = { 1, 2, 3, 4, 5 };
        int[] B = { 2, 1, 2, 3, 2, 4, 2, 5 };
	    int[] C = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int[] score = { 0, 0, 0 }; // 세명의 수포자

        for (int i = 0; i < answers.length; i++) {
			if (answers[i] == A[i % A.length]) {
				score[0]++;
			}
			if (answers[i] == B[i % B.length]) {
				score[1]++;
			}
			if (answers[i] == C[i % C.length]) {
				score[2]++;
			}
		}

        int max = Math.max(score[0], Math.max(score[1], score[2]));
		
		if(max == score[0]) {
			list.add(1);
		}
		if(max == score[1]) {
			list.add(2);
		}
		if(max == score[2]) {
			list.add(3);
		}

        return list;
    }
}
