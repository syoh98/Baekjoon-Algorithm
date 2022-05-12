import java.util.*;
import java.util.Map.Entry;

class Solution {
    static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	  static LinkedHashMap<String, Integer> countMap = new LinkedHashMap<String, Integer>();
    
    public ArrayList<Integer> solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        HashSet<String> reportList = new HashSet<String>(); // report[]의 중복을 제거하기 위해

		for (int i = 0; i < report.length; i++) {
			reportList.add(report[i]);
		}
		ArrayList<String> finalList = new ArrayList<>(reportList); // HashSet으로 중복제거 후 다시 배열을 생성

		for (int i = 0; i < id_list.length; i++) {
			countMap.put(id_list[i], 0); // count 처리를 위함
		}
        
		for (int i = 0; i < finalList.size(); i++) {
			String[] temp = finalList.get(i).split(" ");
			String userID = temp[0]; // 이용자 id
			String reportID = temp[1]; // 신고한 id

			ArrayList<String> al = new ArrayList<String>();
			map.put(reportID, al); // 다음 for문을 처리하기 위한 메모리 선언
		}

		for (int i = 0; i < finalList.size(); i++) {
			String[] temp = finalList.get(i).split(" ");
			String userID = temp[0]; // 이용자 id
			String reportID = temp[1]; // 신고한 id

			ArrayList<String> al = map.get(reportID);

			al.add(userID);
		}

		// for loop (entrySet())
		for (Entry<String, ArrayList<String>> entrySet : map.entrySet()) {
			ArrayList<String> temp = entrySet.getValue();

			if (temp.size() >= k) { // 정지 기준이 되는 신고 횟수 k 이상이면

				for (int i = 0; i < entrySet.getValue().size(); i++) {
					String tempUser = entrySet.getValue().get(i);

					int tempCount = countMap.get(tempUser);
					tempCount++;
					countMap.put(tempUser, tempCount);
				}
			}
		}
        
        // for loop (entrySet())
		for (Entry<String, Integer> entrySet : countMap.entrySet()) {
            answer.add(entrySet.getValue());
		}
        
        return answer;
    }
}
