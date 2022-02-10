package Test;

import java.io.*;
import java.util.*;

public class Main3 {
	static int N;
	static int[] stair; // 각 계단 점수의 배열
	static int[] score; // 해당 계단 위치까지의 max score

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 계단의 개수
		stair = new int[301];
		score = new int[301];

		for (int i = 0; i < N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		score[0] = stair[0];
		score[1] = stair[0] + stair[1];
		score[2] = Math.max(stair[0] + stair[2], stair[1] + stair[2]);

		// 마지막 계단을 꼭 밟아야하기 때문에 바로 이전의 계단까지의 최대합을 구하기
		// -> 그 후 최대값 + 마지막 계단 => 최대값이 됨

		// 조건을 고려해서 나온 경우 => 2가지의 경우
		// 1. n-3을 밟고 n-1을 밟고 n으로 오는 경우
		// 2. n-2를 밟고 n으로 오는 경우
		// score[n] = Math.max(score[n-3] + score[n-1], score[n-2]) + stair[n]
		for (int i = 3; i < N; i++) {
			score[i] = Math.max(score[i - 3] + stair[i - 1], score[i - 2]) + stair[i];
		}

		System.out.println(score[N - 1]);
	}
}
