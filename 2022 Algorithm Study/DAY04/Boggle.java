package P9202;

import java.io.*;
import java.util.*;

public class Main {
	static int[] mx = { 0, 0, -1, 1, 1, 1, -1, -1 };
	static int[] my = { -1, 1, 0, 0, 1, -1, 1, -1 };
	static int[] score = { 0, 0, 0, 1, 1, 2, 3, 5, 11 }; // 각 

	static int W, N;
	static char[][] map;
	static boolean[][] visited;
	static String answer;
	static int count;
	static int sum;
	static StringBuilder sb = new StringBuilder();
	static TrieNode root = new TrieNode();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 단어는 최대 8글자이고, 알파벳 대문자로만 이루어져있다
		W = Integer.parseInt(br.readLine()); // 단어의 수

		for (int i = 0; i < W; i++) {
			insertTrieNode(br.readLine());
		}

		br.readLine();
		N = Integer.parseInt(br.readLine());
		StringBuilder resultSb = new StringBuilder();
		for (int n = 0; n < N; n++) {
			map = new char[4][4];
			visited = new boolean[4][4];
			answer = "";
			sum = 0;
			count = 0;
			sb = new StringBuilder();

			for (int i = 0; i < 4; i++) {
				String in = br.readLine();
				for (int k = 0; k < 4; k++) {
					map[i][k] = in.charAt(i);
				}
			}
		}
	}

	// dfs
	static void search(int y, int x, int length, TrieNode node) {
		// 1. 체크인
		visited[y][x] = true;
		sb.append(map[y][x]); // 히스토리 기억하기
		// 2. 목적지에 도달하였는가?
		if (node.isEnd && node.isHit == false) {
			node.isHit = true;
			sum += score[length];
			count++;
			String foundWord = sb.toString();
			if (compare(answer, foundWord) > 0) {
				answer = foundWord;
			}
		}
		// 3. 연결된 곳을 순회 -> 8방
		for (int i = 0; i < 8; i++) {
			int ty = y + my[i];
			int tx = x + mx[i];
			// 4. 가능한가? - map 경계, 방문하지 않았는지, node가 해당 자식을 가지고 있는지
			if (0 <= ty && ty < 4 && 0 <= tx && tx < 4) {
				if (visited[ty][tx] == false && node.hasChild(map[ty][tx])) { // 노드가 자식이 있어야만 갈 수 있음
					// 5. 간다
					search(ty, tx, length + 1, node.getChild(map[ty][tx]));
				}
			}
		}

		// 6. 체크아웃
		visited[y][x] = false;
		sb.deleteCharAt(length - 1); // 히스토리 빼기
	}

	// 따로 메소드로 빼는게 편할거임
	static int compare(String arg0, String arg1) {
		// 길이가 긴걸 찾을거임, 따라서 arg1, arg0로 바꾸어서 넣기(내림차순)
		int result = Integer.compare(arg1.length(), arg0.length());
		if (result == 0) {
			return arg0.compareTo(arg1);
		} else {
			return result;
		}
	}

	static void insertTrieNode(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			// child가 없으면
			if (!current.hasChild(word.charAt(i)) == false) {
				current.children[word.charAt(i) - 'A'] = new TrieNode(); // 그 자리에 새로 만들어줌

			}
			current = current.getChild(word.charAt(1));
		}
		current.isEnd = true; // 마킹
	}
}

class TrieNode {
	TrieNode[] children = new TrieNode[26]; // 알파벳 대문자로만 이루어짐
	boolean isEnd; // 단어의 끝을 판별
	boolean isHit;

	// 자식을 가지고 있는지
	boolean hasChild(char c) {
		return children[c - 'A'] != null; // 자식 값이 있다
	}

	TrieNode getChild(char c) {
		return children[c - 'A'];
	}

	void clearHit() {
		isHit = false;
		for (int i = 0; i < children.length; i++) {
			TrieNode child = children[i];
			if (child != null) {
				child.clearHit();
			}
		}
	}
}
